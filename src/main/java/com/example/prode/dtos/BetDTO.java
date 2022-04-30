package com.example.prode.dtos;

import com.example.prode.entities.Bet;
import com.example.prode.entities.BetKey;
import lombok.Data;

@Data
public class BetDTO {

    private BetKey id;
    private Integer team1PredictionScore;
    private Integer team2PredictionScore;
    private Integer points;

    public Bet toBet() {
        Bet bet = new Bet();
        bet.setId(id);
        bet.setPoints(points);
        bet.setTeam1PredictionScore(team1PredictionScore);
        bet.setTeam2PredictionScore(team2PredictionScore);
        return bet;
    }
}
