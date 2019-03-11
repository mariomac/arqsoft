package edu.upc.swarch.jpa.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Film {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private Integer year;

    @ManyToOne
    private Author author;

    @ManyToOne
    private Genre genre;

    public Film() {} // Required by JPA

    public Film(String name, Integer year, Author author,
                Genre genre) {
        this.name = name;
        this.year = year;
        this.author = author;
        this.genre = genre;
    }

    public Integer getId() {
        return id;
    }

    // Required by JPA
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    // Required by JPA
    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    // Required by JPA
    public void setYear(Integer year) {
        this.year = year;
    }

    public Author getAuthor() {
        return author;
    }

    // Required by JPA
    public void setAuthor(Author author) {
        this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return name + " (" + year + "). " + author.getName()
                + " - " + genre.getName();
    }
}
