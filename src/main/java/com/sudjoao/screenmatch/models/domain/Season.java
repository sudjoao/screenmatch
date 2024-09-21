package com.sudjoao.screenmatch.models.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Season {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private final int number;
    @OneToMany
    private List<Episode> episodes;

    @ManyToOne
    private Series series;

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
