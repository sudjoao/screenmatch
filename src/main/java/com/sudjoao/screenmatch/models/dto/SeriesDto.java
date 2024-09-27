package com.sudjoao.screenmatch.models.dto;

import com.sudjoao.screenmatch.models.domain.GenderEnum;
import com.sudjoao.screenmatch.models.domain.Series;

import java.util.List;

public record SeriesDto(Long id, String name, int totalSeasons, List<String> actors, GenderEnum gender, Double rate) {
    public static SeriesDto fromDomain(Series series) {
        return new SeriesDto(series.getId(), series.getName(), series.getTotalSeasons(), series.getActors(), series.getGender(), series.getRate());
    }
}
