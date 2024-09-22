package com.sudjoao.screenmatch.repository;

import com.sudjoao.screenmatch.models.domain.Series;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SeriesRepository extends JpaRepository<Series, Long> {
    public Optional<Series> findByNameContainingIgnoreCase(String name);
}
