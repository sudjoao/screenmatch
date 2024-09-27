package com.sudjoao.screenmatch.services;

import com.sudjoao.screenmatch.models.domain.Series;
import com.sudjoao.screenmatch.models.dto.SeriesDto;
import com.sudjoao.screenmatch.repository.SeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeriesService {
    @Autowired
    SeriesRepository seriesRepository;


    public List<SeriesDto> getSeries() {
        return convertSeriesToDomain(seriesRepository.findAll());
    }

    public List<SeriesDto> getTopFiveSeries() {
        return convertSeriesToDomain(seriesRepository.findTop5ByOrderByRateDesc());
    }

    private List<SeriesDto> convertSeriesToDomain(List<Series> series) {
        return series.stream()
                .map(SeriesDto::fromDomain)
                .toList();
    }

    public List<SeriesDto> getTopFiveSeriesWithRecentEpisodes() {
        return convertSeriesToDomain(seriesRepository.findTopFiveSeriesWithRecentEpisodes());
    }
}
