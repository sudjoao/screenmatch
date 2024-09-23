package com.sudjoao.screenmatch.repository;

import com.sudjoao.screenmatch.models.domain.Episode;
import com.sudjoao.screenmatch.models.domain.GenderEnum;
import com.sudjoao.screenmatch.models.domain.Series;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SeriesRepository extends JpaRepository<Series, Long> {
    Optional<Series> findByNameContainingIgnoreCase(String name);

    List<Series> findTop5ByOrderByRateDesc();

    List<Series> findByGender(GenderEnum genderEnum);

    @Query("select s from Series s WHERE s.totalSeasons <= :totalSeasons AND s.rate >= :rate")
    List<Series> findBySeasonWithRate(int totalSeasons, double rate);

    @Query("select e from Series s JOIN s.episodes e WHERE e.series = :series ORDER BY e.rating DESC limit 5")
    List<Episode> topFiveBySeries(Series series);

    @Query("select e from Series s JOIN s.episodes e WHERE series = :series AND YEAR(e.releaseDate) >= :year")
    List<Episode> seriesEpisodesAfterYear(Series series, int year);
}
