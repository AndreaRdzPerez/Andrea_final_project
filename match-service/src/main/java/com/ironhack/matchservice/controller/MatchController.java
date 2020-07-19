package com.ironhack.matchservice.controller;

import com.ironhack.matchservice.exception.DataNotFoundException;
import com.ironhack.matchservice.model.Match;
import com.ironhack.matchservice.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MatchController {
    @Autowired
    private MatchService matchService;

    // READ

    /**
     * Find all the Matches.
     *
     * @return Returns a List with all the Matches.
     */
    @GetMapping("/matches")
    @ResponseStatus(HttpStatus.OK)
    public List<Match> findAll() {
        return matchService.findAll();
    }

    /**
     * Find a Match by Id.
     *
     * @param id Receives the Id of the Match for searching by Param.
     * @return Returns the Match with the Id given.
     * @throws DataNotFoundException a Exception
     */
    @GetMapping("/match/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Match findById(@PathVariable Integer id) throws DataNotFoundException {
        return matchService.findById(id);
    }

    // CREATE

    /**
     * Creates a new Match.
     *
     * @param match Receives the Match Object by Body.
     * @return Returns the new Match.
     */
    @PostMapping("/match")
    @ResponseStatus(HttpStatus.CREATED)
    public Match createTeam(@RequestBody Match match) {
        return matchService.createMatch(match);
    }

    // UPDATE

    /**
     * Updates a Match.
     *
     * @param id   Receives the Id of the Match to update by Param.
     * @param match Receives a Match Object with the information to update by Body.
     * @throws DataNotFoundException a Exception
     */
    @PutMapping("/match/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTeam(@PathVariable Integer id, @RequestBody Match match) {
        matchService.updateMatch(id, match);
    }

    // DELETE

    /**
     * Deletes a Match by Id.
     *
     * @param id Receives the Id of the Match to delete by Param.
     * @throws DataNotFoundException a Exception
     */
    @DeleteMapping("/match/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMatchById(@PathVariable Integer id) {
        matchService.deleteMatchById(id);
    }
}
