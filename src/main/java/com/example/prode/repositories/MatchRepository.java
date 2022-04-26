package com.example.prode.repositories;

import com.example.prode.entities.Match;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface MatchRepository extends CrudRepository<Match, Long> {

    List<Match> findAll();
    Optional<Match> findById(Long id);
    List<Match> findByTeam1(String team1);
    List<Match> findByTeam2(String team2);

}
