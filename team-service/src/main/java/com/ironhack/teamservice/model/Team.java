package com.ironhack.teamservice.model;

import lombok.Data;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer captainId;
    private Integer teamMembersNum;

    public Team() {
    }

    public Team(Integer id, String name, Integer captainId, Integer teamMembersNum) {
        this.id = id;
        this.name = name;
        this.captainId = captainId;
        this.teamMembersNum = teamMembersNum;
    }
}
