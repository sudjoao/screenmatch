package com.sudjoao.screenmatch.models.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Series {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private final String name;
    private final int totalSeasons;
    @OneToMany
    private List<Season> seasons;
    private final List<String> actors;
    private final String gender;

    public Series(String name, int totalSeasons, List<String> actors, String gender) {
        this.name = name;
        this.totalSeasons = totalSeasons;
        this.actors = actors;
        this.gender = gender;
        this.seasons = new ArrayList<>();
    }

    public void setSeasons(List<Season> seasons) {
        this.seasons = seasons;
    }

    public String getName() {
        return name;
    }

    public int getTotalSeasons() {
        return totalSeasons;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Season> getSeasons() {
        return seasons;
    }

    public List<Episode> getAllEpisodes() {
        return seasons.stream()
                .flatMap(s -> s.getEpisodes().stream())
                .toList();
    }

    public List<Episode> getEpisodesAfterDate(LocalDate date) {
        return  getAllEpisodes().stream()
                .filter(e -> e.getReleaseDate() != null && e.getReleaseDate().isAfter(date))
                .toList();
    }

    @Override
    public String toString() {
        return "Series: %s %d seasons (%s). Actors: %s\n".formatted(name, totalSeasons, gender, actors) +
                getAllEpisodes();
    }
}
