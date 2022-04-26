package com.example.prode.services;

import com.example.prode.dtos.MatchDTO;
import com.example.prode.entities.Match;
import com.example.prode.repositories.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatchService {

    private MatchRepository matchRepository;

    @Autowired
    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public MatchDTO saveMatch(MatchDTO matchDto){
        Match match = matchDto.toMatch();
        match = matchRepository.save(match);
        return match.toMatchDTO();
    }
}
