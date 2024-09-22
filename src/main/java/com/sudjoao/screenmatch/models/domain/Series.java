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
    private int totalSeasons;
    @OneToMany(mappedBy = "series", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Episode> episodes;
    private List<String> actors;
    private GenderEnum gender;
    private Double rate;

    public Series() {
    }

    public Series(String name, int totalSeasons, List<String> actors, Optional<String> gender) {
        this.name = name;
        this.totalSeasons = totalSeasons;
        this.actors = actors;
        this.gender = gender.map(s -> GenderEnum.getByName(s.trim().split(",")[0])).orElse(GenderEnum.UNKNOWN);
        this.episodes = new ArrayList<>();
    }

    public void setEpisodes(List<Episode> episodes) {
        episodes.forEach(e -> e.setSeries(this));
        this.episodes = episodes;
        this.rate = this.episodes.stream().mapToDouble(Episode::getRating).average().orElse(0);
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

    public List<Episode> getEpisodes() {
        return episodes;
    }

    public List<Episode> getEpisodesAfterDate(LocalDate date) {
        return episodes.stream()
                .filter(e -> e.getReleaseDate() != null && e.getReleaseDate().isAfter(date))
                .toList();
    }

    public String information() {
        return "Series: %s, it contains %d episodes in %d seasons (%s). Rate: %.2f. Actors: %s\n".formatted(name, episodes.size(), totalSeasons, gender, rate, actors);
    }

    @Override
    public String toString() {
        return information() + episodes;
    }
}
