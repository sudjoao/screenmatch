package com.sudjoao.screenmatch.services;

import com.sudjoao.screenmatch.models.domain.GenderEnum;
import com.sudjoao.screenmatch.models.domain.Series;
import com.sudjoao.screenmatch.repository.SeriesRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class MenuService {
    private Scanner scanner = new Scanner(System.in);
    private final SeriesRepository seriesRepository;

    public MenuService(SeriesRepository seriesRepository) {
        this.seriesRepository = seriesRepository;
    }

    public void runMenu() {
        int option = -1;
        System.out.println("Welcome to the series database");
        while (option != 0) {
            showOptions();
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 0:
                    System.out.println("Leaving...");
                    break;
                case 1:
                    handleSeriesSearch();
                    break;
                case 2:
                    handleTopFiveList();
                    break;
                case 3:
                    handleSearchByGender();
                    break;
                case 4:
                    handleSearchBySeasonAndRating();
                    break;
                default:
                    System.out.println("Invalid option. Restarting menu...");
            }
        }
    }


    private void showOptions() {
        System.out.println("What do you wanna do today?");
        System.out.println("1. Search a series");
        System.out.println("2. Check the top 5 series");
        System.out.println("3. Find series by gender");
        System.out.println("4. Find series by season number and rating");
        System.out.println("0. Leave");
    }

    private void handleTopFiveList() {
        List<Series> topFiveSeries = seriesRepository.findTop5ByOrderByRateDesc();
        topFiveSeries.forEach(s -> System.out.println(s.information()));
    }

    private void handleSeriesSearch() {
        System.out.println("Which series are you looking for?");
        String name = scanner.nextLine();
        Optional<Series> foundedSeries = seriesRepository.findByNameContainingIgnoreCase(name);
        if (foundedSeries.isEmpty()) {
            System.out.println("We do not have this series in our database, I'll look for it, just a second...");
            Series series = SeriesFacade.getSeriesData(name);
            seriesRepository.save(series);
            System.out.println("Database update");
            foundedSeries = Optional.of(series);
        }
        System.out.printf("Series founded: %s\n", foundedSeries.get());

    }


    private void handleSearchByGender() {
        System.out.println("Available genders:");
        Arrays.stream(GenderEnum.values()).toList().forEach(System.out::println);
        System.out.println("Which gender do you want to search? Type the name");
        String gender = scanner.nextLine();
        List<Series> series = seriesRepository.findByGender(GenderEnum.getByName(gender));
        System.out.println("Founded series:");
        series.forEach(System.out::println);
    }

    private void handleSearchBySeasonAndRating() {
        System.out.println("Type the quantity of the seasons");
        int seasonNumber = scanner.nextInt();
        System.out.println("Type the minimum rate");
        double minRate = scanner.nextDouble();
        List<Series> series = seriesRepository.findByTotalSeasonsAndRateGreaterThanEqual(seasonNumber, minRate);
        series.forEach(System.out::println);
    }
}
