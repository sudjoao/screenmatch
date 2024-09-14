package com.sudjoao.screenmatch;

import com.sudjoao.screenmatch.models.domain.Episode;
import com.sudjoao.screenmatch.models.domain.Season;
import com.sudjoao.screenmatch.models.domain.Series;
import com.sudjoao.screenmatch.models.dto.SeriesDataOmdbInput;
import com.sudjoao.screenmatch.models.dto.SeriesEpisodeDataOmdbInput;
import com.sudjoao.screenmatch.models.dto.SeriesSeasonDataOmdbInput;
import com.sudjoao.screenmatch.services.OmdbApiService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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
        SeriesDataOmdbInput seriesDataOmdbInput = OmdbApiService.getSeriesInfo(name);
        System.out.println(seriesDataOmdbInput);
        List<SeriesSeasonDataOmdbInput> seasons = new ArrayList<>();
        for (int i = 1; i <= seriesDataOmdbInput.totalSeasons(); i++) {
            SeriesSeasonDataOmdbInput seasonDataOmdbInput = OmdbApiService.getSeasonInfo(name, String.valueOf(i));
            seasons.add(seasonDataOmdbInput);
        }

        Series series = seriesDataOmdbInput.toDomain();
        List<Season> seasonList = seasons.stream()
                .map(SeriesSeasonDataOmdbInput::toDomain)
                .toList();
        series.setSeasons(seasonList);

        series.getAllEpisodes().forEach(System.out::println);

        System.out.println("Type the date that you want to filter");
        var year = scanner.nextInt();
        LocalDate localDate = LocalDate.of(year, 1, 1);
        series.getEpisodesAfterDate(localDate).forEach(System.out::println);
    }
}
