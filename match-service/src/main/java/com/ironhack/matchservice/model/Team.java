package com.ironhack.matchservice.model;

import lombok.Data;

@Data
public class Team {
    private int id;
    private String name;
    private int captainId;
}
