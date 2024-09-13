package com.sudjoao.screenmatch.services;

import com.sudjoao.screenmatch.models.SerieDataOMBDDTO;

public class OMBDApiService extends ApiService {
    private static final String URL = "https://www.omdbapi.com";
    private static final String API_KEY = "";

    public static SerieDataOMBDDTO getSerie(String serie){
        String uri = "%s/?t=%s&apikey=%s".formatted(URL, serie, API_KEY);
        String serieData = get(uri);
        return MapperService.toObject(serieData, SerieDataOMBDDTO.class);
    }
}
