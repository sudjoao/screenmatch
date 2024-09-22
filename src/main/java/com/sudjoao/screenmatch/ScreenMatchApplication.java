package com.sudjoao.screenmatch;

import com.sudjoao.screenmatch.repository.EpisodesRepository;
import com.sudjoao.screenmatch.repository.SeriesRepository;
import com.sudjoao.screenmatch.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenMatchApplication implements CommandLineRunner {
    @Autowired
    private SeriesRepository seriesRepository;
    @Autowired
    private EpisodesRepository episodesRepository;

    public static void main(String[] args) {
        SpringApplication.run(ScreenMatchApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        MenuService menuService = new MenuService(seriesRepository, episodesRepository);
        menuService.runMenu();
    }
}
