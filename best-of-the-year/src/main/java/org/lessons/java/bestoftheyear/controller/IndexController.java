package org.lessons.java.bestoftheyear.controller;

import org.lessons.java.bestoftheyear.model.Movie;
import org.lessons.java.bestoftheyear.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/")
public class IndexController {
    private static final String myName = "Fabio";

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("name", myName);
        return "home-page";
    }

    private List<Movie> getBestMovies() {
        Movie[] moviesArray = {new Movie(1, "Back To The Future"), new Movie(2, "Catch Me If You Can"), new Movie(3, "Oppenheimer"), new Movie(4, "Kill Bill"), new Movie(5, "Inception")};
        List<Movie> movies = new ArrayList<>(Arrays.asList(moviesArray));
        return movies;
    }

    private List<Song> getBestSongs() {
        Song[] songsArray = {new Song(6, "Master of Puppets"), new Song(7, "Highway to Hell"), new Song(8, "Ace of Spades"), new Song(9, "Fear Of The Dark"), new Song(10, "Wind of Change")};
        List<Song> songs = new ArrayList<>(Arrays.asList(songsArray));
        return songs;
    }

    @GetMapping("movies")
    public String movies(Model model) {
        List<Movie> myMovies = getBestMovies();
        model.addAttribute("movies", myMovies);
        return "movies-list";
    }

    @GetMapping("songs")
    public String songs(Model model) {
        List<Song> mySongs = getBestSongs();
        model.addAttribute("songs", mySongs);
        return "songs-list";
    }

    @GetMapping("movies/{id}")
    public String movieDetail(@PathVariable("id") int movieId, Model model) {
        Movie movie = getMovieById(movieId);
        model.addAttribute("movie", movie);
        return "movie-details";
    }

    @GetMapping("songs/{id}")
    public String songDetail(@PathVariable("id") int songId, Model model) {
        Song song = getSongById(songId);
        model.addAttribute("song", song);
        return "song-details";
    }

    private Movie getMovieById(int id) {
        for (Movie movie : getBestMovies()) {
            if (movie.getId() == id) {
                return movie;
            }
        }
        return null;
    }

    private Song getSongById(int id) {
        for (Song song : getBestSongs()) {
            if (song.getId() == id) {
                return song;
            }
        }
        return null;
    }
}
