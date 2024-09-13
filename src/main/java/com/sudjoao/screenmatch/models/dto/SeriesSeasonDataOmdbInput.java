package com.sudjoao.screenmatch.models.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SeriesSeasonDataOmdbInput(
        @JsonProperty("Title") String title,
        @JsonProperty("Season") String seasonNumber,
        @JsonProperty("Episodes")List<SeriesEpisodeDataOmdbInput> episodes
        ) {
}
