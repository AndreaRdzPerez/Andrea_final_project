package com.ironhack.teamservice.controller;

import com.ironhack.teamservice.exception.DataNotFoundException;
import com.ironhack.teamservice.model.Team;
import com.ironhack.teamservice.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeamController {
    @Autowired
    private TeamService teamService;

    // READ

    /**
     * Find all the Teams.
     *
     * @return Returns a List with all the Leads.
     */
    @GetMapping("/teams")
    @ResponseStatus(HttpStatus.OK)
    public List<Team> findAll() {
        return teamService.findAll();
    }

    /**
     * Find a Team by Id.
     *
     * @param id Receives the Id of the Team for searching by Param.
     * @return Returns the Team with the Id given.
     * @throws DataNotFoundException a Exception
     */
    @GetMapping("/team/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Team findById(@PathVariable Integer id) {
            return teamService.findById(id);
    }

    /**
     * Finds a List of Teams by Name.
     *
     * @param name Receives the Name for searching by Param.
     * @return Returns a List of Leads matching the given Name.
     * @throws DataNotFoundException a Exception
     */
    @GetMapping("/team/{name}")
    @ResponseStatus(HttpStatus.OK)
    public List<Team> findByNameContaining(@PathVariable String name) {
            return teamService.findByNameContaining(name);
    }

    // CREATE

    /**
     * Creates a new Team.
     *
     * @param team Receives the Team Object by Body.
     * @return Returns the new Team.
     */
    @PostMapping("/team")
    @ResponseStatus(HttpStatus.CREATED)
    public Team createTeam(@RequestBody Team team) {
        return teamService.createTeam(team);
    }

    // UPDATE

    /**
     * Updates a Team.
     *
     * @param id   Receives the Id of the Team to update by Param.
     * @param team Receives a Team Object with the information to update by Body.
     * @throws DataNotFoundException a Exception
     */
    @PutMapping("/team/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTeam(@PathVariable Integer id, @RequestBody Team team) {
            teamService.updateTeam(id, team);
    }

    // DELETE

    /**
     * Deletes a Team by Id.
     *
     * @param id Receives the Id of the Team to delete by Param.
     * @throws DataNotFoundException a Exception
     */
    @DeleteMapping("/team/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTeamById(@PathVariable Integer id) {
        teamService.deleteTeamById(id);
    }
}
