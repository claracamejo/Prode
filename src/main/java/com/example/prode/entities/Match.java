package com.example.prode.entities;

import com.example.prode.dtos.MatchDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Data
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String team1;
    private String team2;
    private Integer scoreTeam1;
    private Integer scoreTeam2;

    @OneToMany(mappedBy="match", fetch = FetchType.LAZY)
    @JsonBackReference
    private Set<Bet> bets;

    public MatchDTO toMatchDTO() {
        MatchDTO matchDTO = new MatchDTO();
        matchDTO.setId(id);
        matchDTO.setTeam1(team1);
        matchDTO.setTeam2(team2);
        matchDTO.setScoreTeam1(scoreTeam1);
        matchDTO.setScoreTeam2(scoreTeam2);
        return matchDTO;
    }
}
