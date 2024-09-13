package com.sudjoao.screenmatch;

import com.sudjoao.screenmatch.models.SeriesDataOmdbInput;
import com.sudjoao.screenmatch.models.SeriesEpisodeDataOmdbInput;
import com.sudjoao.screenmatch.models.SeriesSeasonDataOmdbInput;
import com.sudjoao.screenmatch.services.OmdbApiService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Comparator;
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
		SeriesDataOmdbInput seriesDataOmdbInput = OmdbApiService.getSeriesInfo(name);
		System.out.println(seriesDataOmdbInput);
		List<SeriesSeasonDataOmdbInput> seasons = new ArrayList<>();
		for(int i=1; i <= seriesDataOmdbInput.totalSeasons(); i++){
			SeriesSeasonDataOmdbInput seasonDataOmdbInput = OmdbApiService.getSeasonInfo(name, String.valueOf(i));
			seasons.add(seasonDataOmdbInput);
		}

		List<SeriesEpisodeDataOmdbInput> topRatedEpisodes = seasons.stream()
				.flatMap(s -> s.episodes().stream())
				.filter(s-> !s.rating().equals("N/A"))
				.sorted(Comparator.comparing((SeriesEpisodeDataOmdbInput::rating)).reversed())
				.limit(5)
				.toList();
		topRatedEpisodes.forEach(System.out::println);
	}
}
