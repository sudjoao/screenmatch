package com.sudjoao.screenmatch.models.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class Episode {
     private final String title;
     private final Integer number;
     private final String rating;
     private final LocalDate releaseDate;
     private final Integer season;

    public Episode(String title, Integer number, String rating, String releaseDate, Integer season) {
        this.title = title;
        this.number = number;
        this.rating = rating;
        this.releaseDate = LocalDate.parse(releaseDate);
        this.season = season;
    }

    @Override
    public String toString() {
        return "Episode S%d-%d - %s (%s)".formatted(season, number, title, releaseDate);
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

    public Integer getSeason() {
        return season;
    }
}
