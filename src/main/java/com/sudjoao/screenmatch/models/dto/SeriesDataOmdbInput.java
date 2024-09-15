package com.sudjoao.screenmatch.models.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sudjoao.screenmatch.models.domain.Series;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SeriesDataOmdbInput(
        String Title,
        String Year,
        Integer totalSeasons
) {
    public Series toDomain() {
        return new Series(Title(), totalSeasons());
    }
}
