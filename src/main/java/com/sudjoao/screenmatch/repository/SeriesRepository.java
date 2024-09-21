package com.sudjoao.screenmatch.repository;

import com.sudjoao.screenmatch.models.domain.Series;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeriesRepository extends JpaRepository<Series, Long> {
}
