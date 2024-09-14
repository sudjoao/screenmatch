package com.sudjoao.screenmatch.models.domain;

import java.time.LocalDate;
import java.util.List;

public class Series {
    private final String name;
    private final int totalSeasons;
    private List<Season> seasons;

    public Series(String name, int totalSeasons) {
        this.name = name;
        this.totalSeasons = totalSeasons;
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
}
