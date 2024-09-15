package com.sudjoao.screenmatch.models.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sudjoao.screenmatch.models.domain.Season;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SeriesSeasonDataOmdbInput(
        @JsonProperty("Title") String title,
        @JsonProperty("Season") String seasonNumber,
        @JsonProperty("Episodes") List<SeriesEpisodeDataOmdbInput> episodes
) {

    public Season toDomain() {
        Season season = new Season(Integer.parseInt(seasonNumber()));
        season.setEpisodes(
                episodes().stream()
                        .map(e -> e.toDomain(Integer.parseInt(seasonNumber())))
                        .toList()
        );
        return season;
    }
}
