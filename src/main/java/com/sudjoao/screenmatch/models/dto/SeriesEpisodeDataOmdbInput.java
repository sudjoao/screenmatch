package com.sudjoao.screenmatch.models.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sudjoao.screenmatch.models.domain.Episode;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SeriesEpisodeDataOmdbInput(
        @JsonProperty("Title") String title,
        @JsonProperty("Episode") Integer episode,
        @JsonProperty("imdbRating") String rating,
        @JsonProperty("Released") String releaseDate
) {

    public Episode toDomain(int season) {
        return new Episode(title, episode, rating, releaseDate, season);
    }
}
