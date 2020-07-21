package com.ironhack.edgeservice.service;

import com.ironhack.edgeservice.client.MatchClient;
import com.ironhack.edgeservice.exception.DataNotFoundException;
import com.ironhack.edgeservice.model.Match;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {

    /**
     * Attributes
     */
    @Autowired
    private MatchClient matchClient;

    // READ

    /**
     * This method return all elements from matchRepository's list
     * @return a match's list
     */
    public List<Match> findAll() {
        //String leadToken = "Bearer " + jwtUtil.generateToken("match-service");
        return matchClient.findAll();
    }

    /**
     * This method get a match whose id attribute matches id param
     * @param id a integer value
     * @return  A match which was found
     * @throws DataNotFoundException if there isn't any match whose id doesn't matches id param
     */
    public Match findById(Integer id) throws DataNotFoundException {
        //String leadToken = "Bearer " + jwtUtil.generateToken("match-service");
        return matchClient.findById(id);
    }

    // CREATE
    /**
     * This method creates a new Match and adds in matchRepository's list
     * @param match  a match element
     * @return The match which was added in matchRepository's list
     */
    public Match createMatch(Match match) {
        return matchClient.createMatch(match);
    }

    // UPDATE
    /**
     * This method  update match's properties.
     * @param id  a integer value to find a exist match
     * @param match a match element to update a exist match
     * @throws DataNotFoundException if there isn't a match whose id attribute doesn't match with id param
     */
    public void updateMatch(Integer id, Match match) throws DataNotFoundException {
        matchClient.updateMatch(id,match);
    }

    // DELETE
    /**
     * This method found a match between a match's id and param id then these match will be deleted.
     * @param id a integer value to find a exist match
     * @throws DataNotFoundException if there isn't a match whose id attribute doesn't match with id param
     */
    public void deleteMatchById(Integer id) throws DataNotFoundException {
        matchClient.deleteMatchById(id);
    }
}
