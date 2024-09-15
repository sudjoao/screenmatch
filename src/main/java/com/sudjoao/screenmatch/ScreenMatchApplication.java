package com.sudjoao.screenmatch;

import com.sudjoao.screenmatch.models.domain.Season;
import com.sudjoao.screenmatch.models.domain.Series;
import com.sudjoao.screenmatch.models.dto.SeriesDataOmdbInput;
import com.sudjoao.screenmatch.models.dto.SeriesSeasonDataOmdbInput;
import com.sudjoao.screenmatch.services.OmdbApiService;
import com.sudjoao.screenmatch.services.SeriesFacade;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class ScreenMatchApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ScreenMatchApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type the series name");
        String name = scanner.nextLine();
        Series series = SeriesFacade.getSeriesData(name);
        System.out.println(series);
    }
}
