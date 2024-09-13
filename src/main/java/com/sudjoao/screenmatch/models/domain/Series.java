package com.sudjoao.screenmatch.models.domain;

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
}
