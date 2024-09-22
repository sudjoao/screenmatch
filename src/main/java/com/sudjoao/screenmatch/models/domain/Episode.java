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
    private Double rating;
    private LocalDate releaseDate;
    private Integer seasonNumber;

    @ManyToOne
    private Series series;

    public Episode() {
    }

    public Episode(String title, Integer number, String rating, String releaseDate, Integer seasonNumber) {
        this.title = title;
        this.number = number;
        try {

            this.rating = Double.parseDouble(rating);
        } catch (NumberFormatException e) {
            this.rating = 0.0;
        }
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

    public Double getRating() {
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
