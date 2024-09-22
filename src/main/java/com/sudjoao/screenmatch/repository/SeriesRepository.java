package com.sudjoao.screenmatch.repository;

import com.sudjoao.screenmatch.models.domain.GenderEnum;
import com.sudjoao.screenmatch.models.domain.Series;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SeriesRepository extends JpaRepository<Series, Long> {
    Optional<Series> findByNameContainingIgnoreCase(String name);

    List<Series> findTop5ByOrderByRateDesc();

    List<Series> findByGender(GenderEnum genderEnum);

    List<Series> findByTotalSeasonsAndRateGreaterThanEqual(int totalSeasons, double rate);
}
