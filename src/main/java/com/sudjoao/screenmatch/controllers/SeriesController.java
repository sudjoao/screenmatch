package com.sudjoao.screenmatch.controllers;

import com.sudjoao.screenmatch.models.dto.SeriesDto;
import com.sudjoao.screenmatch.repository.SeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SeriesController {
    @Autowired
    SeriesRepository seriesRepository;

    @GetMapping("/series")
    List<SeriesDto> getSeries() {
        return seriesRepository.findAll()
                .stream().map(SeriesDto::fromDomain)
                .toList();
    }
}
