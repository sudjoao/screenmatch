package com.sudjoao.screenmatch.models.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

@Entity
public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

     private final String title;
     private final Integer number;
     private final String rating;
     private LocalDate releaseDate;
     private final Integer seasonNumber;

     @ManyToOne
     private Season season;

    public Episode(String title, Integer number, String rating, String releaseDate, Integer seasonNumber) {
        this.title = title;
        this.number = number;
        this.rating = rating;
        try{
            this.releaseDate = LocalDate.parse(releaseDate);
        } catch(DateTimeParseException exception) {
            this.releaseDate = null;
        }

        this.seasonNumber = seasonNumber;
    }

    @Override
    public String toString() {
        return "Episode S%d-%d - %s (%s)".formatted(seasonNumber, number, title, releaseDate);
    }

    public String getTitle() {
        return title;
    }

    public Integer getNumber() {
        return number;
    }

    public String getRating() {
        return rating;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public Integer getSeasonNumber() {
        return seasonNumber;
    }
}
