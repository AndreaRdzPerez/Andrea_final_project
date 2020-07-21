package com.ironhack.matchservice.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Match {
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
}
