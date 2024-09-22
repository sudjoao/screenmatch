package com.sudjoao.screenmatch.repository;

import com.sudjoao.screenmatch.models.domain.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EpisodesRepository extends JpaRepository<Episode, Long> {
    @Query("select e FROM Episode e WHERE e.title ILIKE %:name%")
    List<Episode> getEpisodesByName(String name);
}
