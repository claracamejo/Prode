package com.example.prode.services;

import com.example.prode.dtos.BetDTO;
import com.example.prode.entities.AppUser;
import com.example.prode.entities.Bet;
import com.example.prode.entities.Match;
import com.example.prode.repositories.BetRepository;
import org.springframework.stereotype.Service;

@Service
public class BetService {

    private final BetRepository betRepository;

    public BetService(BetRepository betRepository) {
        this.betRepository = betRepository;
    }

    public BetDTO save(BetDTO betDTO) {
        Bet bet = betDTO.toBet();
        Match match = new Match();
        match.setId(bet.getId().getMatchId());
        AppUser appUser = new AppUser();
        appUser.setId(bet.getId().getAppUserId());
        bet.setMatch(match);
        bet.setAppUser(appUser);
        Bet saved = this.betRepository.save(bet);
        return saved.toBetDTO();
    }
}

