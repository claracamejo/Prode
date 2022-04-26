package com.example.prode.dtos;

import com.example.prode.entities.Match;
import lombok.Data;

@Data
public class MatchDTO {

    private Long id;
    private String team1;
    private String team2;
    private Integer scoreTeam1;
    private Integer scoreTeam2;

    public Match toMatch() {
        Match match = new Match();
        match.setId(id);
        match.setTeam1(team1);
        match.setTeam2(team2);
        match.setScoreTeam1(scoreTeam1);
        match.setScoreTeam2(scoreTeam2);
        return match;
    }
}
