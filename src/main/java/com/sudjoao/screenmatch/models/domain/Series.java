package com.sudjoao.screenmatch.models.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
public class Series {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int totalEpisodes;
    @OneToMany(mappedBy = "series", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Episode> episodes;
    private List<String> actors;
    private GenderEnum gender;

    public Series() {
    }

    public Series(String name, int totalEpisodes, List<String> actors, Optional<String> gender) {
        this.name = name;
        this.totalEpisodes = totalEpisodes;
        this.actors = actors;
        this.gender = gender.map(s -> GenderEnum.getByName(s.trim().split(",")[0])).orElse(GenderEnum.UNKNOWN);
        this.episodes = new ArrayList<>();
    }

    public void setEpisodes(List<Episode> episodes) {
        episodes.forEach(e -> e.setSeries(this));
        this.episodes = episodes;
    }

    public String getName() {
        return name;
    }

    public int getTotalEpisodes() {
        return totalEpisodes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Episode> getEpisodes() {
        return episodes;
    }

    public List<Episode> getEpisodesAfterDate(LocalDate date) {
        return episodes.stream()
                .filter(e -> e.getReleaseDate() != null && e.getReleaseDate().isAfter(date))
                .toList();
    }

    @Override
    public String toString() {
        return "Series: %s %d episodes (%s). Actors: %s\n".formatted(name, totalEpisodes, gender, actors) +
                episodes;
    }
}
