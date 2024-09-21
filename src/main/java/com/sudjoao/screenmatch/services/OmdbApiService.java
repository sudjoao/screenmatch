package com.sudjoao.screenmatch.services;

import com.sudjoao.screenmatch.models.dto.SeriesDataOmdbInput;
import com.sudjoao.screenmatch.models.dto.SeriesEpisodeDataOmdbInput;
import com.sudjoao.screenmatch.models.dto.SeriesSeasonDataOmdbInput;

import java.util.Map;

public class OmdbApiService extends ApiService {
    private static final String URL = "https://www.omdbapi.com";
    private static final String API_KEY = System.getenv("OMDB_API_KEY");

    public static <T> T getSeries(Map<String, String> params, Class<T> className) {
        String seriesData = get(baseUrl() + '&' + MapperService.mapToQueryParams(params));
        return MapperService.toObject(seriesData, className);
    }

    public static SeriesDataOmdbInput getSeriesInfo(String name) {
        Map<String, String> params = Map.of("t", name);
        return getSeries(params, SeriesDataOmdbInput.class);
    }


    public static SeriesSeasonDataOmdbInput getSeasonInfo(String name, String season) {
        Map<String, String> params = Map.of("t", name, "season", season);
        return getSeries(params, SeriesSeasonDataOmdbInput.class);
    }


    public static SeriesEpisodeDataOmdbInput getEpisodeInfo(String name, String season, String episode) {
        Map<String, String> params = Map.of("t", name, "episode", episode, "season", season);
        return getSeries(params, SeriesEpisodeDataOmdbInput.class);
    }

    private static String baseUrl() {
        return "%s/?apikey=%s".formatted(URL, API_KEY);
    }
}
