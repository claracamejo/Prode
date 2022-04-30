package com.example.prode.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class BetKey implements Serializable {

    @Column(name = "app_user_id")
    private Long appUserId;

    @Column(name = "match_id")
    private Long matchId;
}
