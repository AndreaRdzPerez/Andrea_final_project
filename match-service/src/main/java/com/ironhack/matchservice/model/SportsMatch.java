package com.ironhack.matchservice.model;

import lombok.Data;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
@Entity
public class SportsMatch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String fieldId;
    private String refereeId;
    private Integer teamAid;
    private Integer teamBid;
    private boolean finished;
    private int resultTeamA;
    private int resultTeamB;

    public SportsMatch() {
    }

    public SportsMatch(Integer id, String fieldId, String refereeId, Integer teamAid, Integer teamBid, boolean finished, int resultTeamA, int resultTeamB) {
        this.id = id;
        this.fieldId = fieldId;
        this.refereeId = refereeId;
        this.teamAid = teamAid;
        this.teamBid = teamBid;
        this.finished = finished;
        this.resultTeamA = resultTeamA;
        this.resultTeamB = resultTeamB;
    }
}
