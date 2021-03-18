package com.asylzhan.spring.entity;

import javax.persistence.*;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String genre;
    private String premiere;
    private String director;
    @ManyToOne
    private User user;

    public Movie(String name, String genre, String premiere, String director) {
        this.name = name;
        this.genre = genre;
        this.premiere = premiere;
        this.director = director;
    }

    public Movie(String name, String genre, String premiere, String director, User user) {
        this.name = name;
        this.genre = genre;
        this.premiere = premiere;
        this.director = director;
        this.user = user;
    }

    public Movie() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPremiere() {
        return premiere;
    }

    public void setPremiere(String premiere) {
        this.premiere = premiere;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}
