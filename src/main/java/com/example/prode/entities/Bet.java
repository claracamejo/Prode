package com.example.prode.entities;

import com.example.prode.dtos.BetDTO;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

// N-to-N Relationship tutorial: https://www.baeldung.com/jpa-many-to-many
@Entity
@Data
public class Bet {

    @EmbeddedId
    private BetKey id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("matchId")
    @JsonManagedReference()
    private Match match;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("appUserId")
    @JsonManagedReference()
    private AppUser appUser;

    private Integer team1PredictionScore;
    private Integer team2PredictionScore;
    private Integer points;

    public BetDTO toBetDTO() {
        BetDTO betDTO = new BetDTO();
        betDTO.setId(id);
        betDTO.setTeam2PredictionScore(team2PredictionScore);
        betDTO.setTeam1PredictionScore(team1PredictionScore);
        betDTO.setPoints(points);
        return betDTO;
    }
}
