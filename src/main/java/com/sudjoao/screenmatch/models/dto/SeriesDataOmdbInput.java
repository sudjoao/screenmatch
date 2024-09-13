package com.sudjoao.screenmatch.models.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SeriesDataOmdbInput(
        String Title,
        String Year,
        Integer totalSeasons
) {
}
