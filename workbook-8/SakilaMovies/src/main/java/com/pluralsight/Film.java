package com.pluralsight;

public class Film {
    private int filmId;
    private String title;
    private String description;
    private int releaseYear;
    private int length;

    public Film(int filmId, String title, String description, int releaseYear, int length) {
        this.filmId = filmId;
        this.title = title;
        this.description = description;
        this.releaseYear = releaseYear;
        this.length = length;
    }

    @Override
    public String toString() {
        return "\tFilm\n" +
                "--------------------------\n" +
                "ID :\t" + filmId + '\n' +
                "Title :\t" + title + '\n' +
                "Description :\t" + description + '\n' +
                "Release Year: \t" + releaseYear + '\n' +
                "Length :\t" + length + '\n';
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
