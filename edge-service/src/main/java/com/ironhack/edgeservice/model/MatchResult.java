package com.ironhack.edgeservice.model;

import lombok.Data;

@Data
public class MatchResult {
    private int id;
    private Team won;
    private Team lost;
}
