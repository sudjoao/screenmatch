package com.sudjoao.screenmatch.controllers;

import com.sudjoao.screenmatch.models.dto.SeriesDto;
import com.sudjoao.screenmatch.services.SeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
