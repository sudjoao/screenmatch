package com.sudjoao.screenmatch.models.domain;

import java.util.List;

public class Season {
    private final int number;
    private List<Episode> episodes;

    public Season(int number) {
        this.number = number;
    }

    public void setEpisodes(List<Episode> episodes) {
        this.episodes = episodes;
    }

    public int getNumber() {
        return number;
    }

    public List<Episode> getEpisodes() {
        return episodes;
    }
}
