package com.ironhack.matchservice.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
@Entity
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String court;
    private String refereeId;
    private Team teamA;
    private Team teamB;
    private boolean finished;
    private int resultTeamA;
    private int resultTeamB;
}
