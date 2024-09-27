package com.sudjoao.screenmatch.models.dto;

import com.sudjoao.screenmatch.models.domain.Episode;

public record EpisodeDto(Long id, int season, int number, String title) {
    public static EpisodeDto fromDomain(Episode episode) {
        return new EpisodeDto(episode.getId(), episode.getSeasonNumber(), episode.getNumber(), episode.getTitle());
    }
}
