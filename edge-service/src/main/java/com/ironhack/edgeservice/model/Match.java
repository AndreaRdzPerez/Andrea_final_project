package com.ironhack.edgeservice.model;

import lombok.Data;

@Data
public class Match {
    private int id;
    private String fieldId;
    private String refereeId;
    private Team teamAid;
    private Team teamBid;
    private boolean finished;
    private int resultTeamA;
    private int resultTeamB;
}
