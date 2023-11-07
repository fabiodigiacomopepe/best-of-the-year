package org.lessons.java.bestoftheyear.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

    private List<String> getBestMovies() {
        String[] moviesArray = {"Back To The Future", "Catch Me If You Can", "Oppenheimer", "Kill Bill", "Inception"};
        List<String> movies = new ArrayList<>(Arrays.asList(moviesArray));
        return movies;
    }

    private List<String> getBestSongs() {
        String[] songsArray = {"Master of Puppets", "Highway to Hell", "Ace of Spades", "Fear Of The Dark", "Wind of Change"};
        List<String> songs = new ArrayList<>(Arrays.asList(songsArray));
        return songs;
    }

    @GetMapping("movies")
    public String movies(Model model) {
        List<String> myMovies = getBestMovies();
        String bestMovies = String.join(", ", myMovies.subList(0, myMovies.size() - 1)) + ", " + myMovies.get(myMovies.size() - 1);
        model.addAttribute("movies", bestMovies);
        model.addAttribute("name", myName);
        return "home-page";
    }

    @GetMapping("songs")
    public String songs(Model model) {
        List<String> mySongs = getBestSongs();
        String bestSongs = String.join(", ", mySongs.subList(0, mySongs.size() - 1)) + ", " + mySongs.get(mySongs.size() - 1);
        model.addAttribute("songs", bestSongs);
        model.addAttribute("name", myName);
        return "home-page";
    }
}
