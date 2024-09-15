package com.sudjoao.screenmatch.models.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sudjoao.screenmatch.models.domain.Series;

import java.util.Arrays;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SeriesDataOmdbInput(
        String Title,
        String Year,
        Integer totalSeasons,
        String Actors,
        String Gender
) {
    public Series toDomain() {
        return new Series(Title(), totalSeasons(), Arrays.stream(Actors().strip().split(",")).toList(), Gender());
    }
}
