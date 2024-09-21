package com.sudjoao.screenmatch.models.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

@Entity
public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private Integer number;
    private String rating;
    private LocalDate releaseDate;
    private Integer seasonNumber;

    @ManyToOne
    private Series series;

    public Episode() {
    }

    public Episode(String title, Integer number, String rating, String releaseDate, Integer seasonNumber) {
        this.title = title;
        this.number = number;
        this.rating = rating;
        try {
            this.releaseDate = LocalDate.parse(releaseDate);
        } catch (DateTimeParseException exception) {
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

    public void setSeries(Series series) {
        this.series = series;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public Integer getSeasonNumber() {
        return seasonNumber;
    }
}
