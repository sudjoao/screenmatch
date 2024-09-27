package com.sudjoao.screenmatch.controllers;

import com.sudjoao.screenmatch.models.dto.EpisodeDto;
import com.sudjoao.screenmatch.models.dto.SeriesDto;
import com.sudjoao.screenmatch.services.SeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/series")
public class SeriesController {
    @Autowired
    private SeriesService seriesService;

    @GetMapping
    List<SeriesDto> getSeries() {
        return seriesService.getSeries();
    }

    @GetMapping("/top-five")
    List<SeriesDto> getTopFiveSeries() {
        return seriesService.getTopFiveSeries();
    }

    @GetMapping("/top-five-recent-episodes")
    List<SeriesDto> getTopFiveSeriesWithRecentEpisodes() {
        return seriesService.getTopFiveSeriesWithRecentEpisodes();
    }

    @GetMapping("/{id}")
    SeriesDto getSeriesById(@PathVariable Long id) {
        return seriesService.getById(id);
    }

    @GetMapping("/{id}/episodes")
    List<EpisodeDto> getSeriesEpisodes(@PathVariable Long id) {
        return seriesService.getEpisodes(id);
    }

    @GetMapping("/{id}/episodes/season/{seasonId}")
    List<EpisodeDto> getSeriesEpisodes(@PathVariable Long id, @PathVariable int seasonId) {
        return seriesService.getSeriesEpisodeFromSeason(id, seasonId);
    }

    @GetMapping("/gender/{genderName}")
    List<SeriesDto> getSeriesByGender(@PathVariable String genderName) {
        return seriesService.getSeriesByGender(genderName);
    }
}
