package com.sudjoao.screenmatch.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SerieDataOMBDDTO(
        String Title,
        String Year,
        String totalSeasons
) {
}
