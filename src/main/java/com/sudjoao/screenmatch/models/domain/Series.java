package com.sudjoao.screenmatch.models.domain;

import java.time.LocalDate;
import java.util.List;

public class Series {
    private final String name;
    private final int totalSeasons;
    private List<Season> seasons;
    private final List<String> actors;
    private final String gender;

    public Series(String name, int totalSeasons, List<String> actors, String gender) {
        this.name = name;
        this.totalSeasons = totalSeasons;
        this.actors = actors;
        this.gender = gender;
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
