package com.ironhack.edgeservice.model;

import lombok.Data;

@Data
public class Team {
    private int id;
    private String name;
    private int captainId;
}
