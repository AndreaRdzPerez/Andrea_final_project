package com.ironhack.matchservice.service;

import com.ironhack.matchservice.exception.DataNotFoundException;
import com.ironhack.matchservice.model.Match;
import com.ironhack.matchservice.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {

    /**
     * Attributes
     */
    @Autowired
    private MatchRepository matchRepository;

    // READ

    /**
     * This method return all elements from matchRepository's list
     * @return a match's list
     */
    public List<Match> findAll() {
        List<Match> result = matchRepository.findAll();
        return result;
    }

    /**
     * This method get a match whose id attribute matches id patam
     * @param id a integer value
     * @return  A match which was found
     * @throws DataNotFoundException if there isn't any match whose id doesn't matches id param
     */
    public Match findById(Integer id) throws DataNotFoundException {
        return matchRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Could not find that Match."));
    }

    // CREATE
    /**
     * This method creates a new Match and adds in matchRepository's list
     * @param match  a match element
     * @return The match which was added in matchRepository's list
     */
    public Match createMatch(Match match) {
        return matchRepository.save(match);
    }

    // UPDATE
    /**
     * This method  update match's properties.
     * @param id  a integer value to find a exist match
     * @param match a match element to update a exist match
     * @throws DataNotFoundException if there isn't a match whose id attribute doesn't match with id param
     */
    public void updateMatch(Integer id, Match match) throws DataNotFoundException {
        Match targetMatch = matchRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Could not find that Match."));
        targetMatch.setId(targetMatch.getId());
        targetMatch.setFieldId(match.getFieldId());
        targetMatch.setRefereeId(match.getRefereeId());
        targetMatch.setTeamAid(match.getTeamAid());
        targetMatch.setTeamBid(match.getTeamBid());
        targetMatch.setFinished(match.isFinished());
        targetMatch.setResultTeamA(match.getResultTeamA());
        targetMatch.setResultTeamB(match.getResultTeamB());
        matchRepository.save(targetMatch);
    }

    // DELETE
    /**
     * This method found a match between a match's id and param id then these match will be deleted.
     * @param id a integer value to find a exist match
     * @throws DataNotFoundException if there isn't a match whose id attribute doesn't match with id param
     */
    public void deleteMatchById(Integer id) throws DataNotFoundException {
        Match targetMatch = matchRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Could not find that match."));
        matchRepository.delete(targetMatch);
    }
}
