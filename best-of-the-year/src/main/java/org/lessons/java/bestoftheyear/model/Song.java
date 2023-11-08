package org.lessons.java.bestoftheyear.model;

public class Song {
    // ATTRIBUTI
    private int id;
    private String title;

    // COSTRUTTORE
    public Song(int id, String title) {
        this.id = id;
        this.title = title;
    }

    // GETTER E SETTER
    // ID
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // TITOLO
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
