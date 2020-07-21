package com.ironhack.matchservice.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String fieldId;
    private String refereeId;
    private Team teamAid;
    private Team teamBid;
    private boolean finished;
    private int resultTeamA;
    private int resultTeamB;
}
