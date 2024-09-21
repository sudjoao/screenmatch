package com.sudjoao.screenmatch.services;

import com.sudjoao.screenmatch.models.domain.Episode;
import com.sudjoao.screenmatch.models.domain.Series;
import com.sudjoao.screenmatch.models.dto.SeriesDataOmdbInput;
import com.sudjoao.screenmatch.models.dto.SeriesSeasonDataOmdbInput;

import java.util.ArrayList;
import java.util.List;

public class SeriesFacade {
    public static Series getSeriesData(String seriesName) {
        SeriesDataOmdbInput seriesDataOmdbInput = OmdbApiService.getSeriesInfo(seriesName);
        List<SeriesSeasonDataOmdbInput> seasons = new ArrayList<>();
        for (int i = 1; i <= seriesDataOmdbInput.totalSeasons(); i++) {
            SeriesSeasonDataOmdbInput seasonDataOmdbInput = OmdbApiService.getSeasonInfo(seriesName, String.valueOf(i));
            seasons.add(seasonDataOmdbInput);
        }

        Series series = seriesDataOmdbInput.toDomain();
        List<Episode> seasonList = seasons.stream()
                .flatMap(s -> s.episodes().stream().map(e -> e.toDomain(Integer.parseInt(s.seasonNumber()))))
                .toList();
        series.setEpisodes(seasonList);

        return series;
    }
}
