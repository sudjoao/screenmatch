package com.sudjoao.screenmatch;

import com.sudjoao.screenmatch.models.domain.Series;
import com.sudjoao.screenmatch.repository.SeriesRepository;
import com.sudjoao.screenmatch.services.SeriesFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
public class ScreenMatchApplication implements CommandLineRunner {
    @Autowired
    private SeriesRepository seriesRepository;

    public static void main(String[] args) {
        SpringApplication.run(ScreenMatchApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which series are you looking for?");
        String name = scanner.nextLine();
        Optional<Series> foundedSeries = seriesRepository.findByNameContainingIgnoreCase(name);
        if (foundedSeries.isEmpty()) {
            System.out.println("We dont have this series in our database, I'll look for it, just a second...");
            Series series = SeriesFacade.getSeriesData(name);
            seriesRepository.save(series);
            System.out.println("Database update");
            foundedSeries = Optional.of(series);
        }
        System.out.printf("Series founded: %s\n", foundedSeries.get());
    }
}
