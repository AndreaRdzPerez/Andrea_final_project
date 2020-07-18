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
     * @return Returns a List with all the Leads.
     */
    @GetMapping("/teams")
    @ResponseStatus(HttpStatus.OK)
    public List<Team> findAll(){
        return teamService.findAll();
    }

    /**
     * Find a Team by Id.
     * @param id Receives the Id of the Team for searching by Param.
     * @return Returns the Team with the Id given.
     * @throws DataNotFoundException a Exception
     */
    @GetMapping("/team/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Team findById(@PathVariable Integer id) throws DataNotFoundException {
        try {
            return teamService.findById(id);
        } catch (Exception e) {
            throw new DataNotFoundException(e.getMessage());
        }
    }

    /**
     * Finds a List of Teams by Name.
     * @param name Receives the Name for searching by Param.
     * @return Returns a List of Leads matching the given Name.
     * @throws DataNotFoundException a Exception
     */
    @GetMapping("/team/{name}")
    @ResponseStatus(HttpStatus.OK)
    public List<Team> findByInformationContactNameContaining(@PathVariable String name) throws DataNotFoundException {
        try {
            return teamService.findByNameContaining(name);
        } catch (Exception e) {
            throw new DataNotFoundException(e.getMessage());
        }
    }

    // CREATE

    /**
     * Creates a new Team.
     * @param team Receives the Lead Object by Body.
     * @return Returns the new Lead.
     */
    @PostMapping("/lead")
    @ResponseStatus(HttpStatus.CREATED)
    public Team createTeam(@RequestBody Team team) {
        return teamService.createTeam(team);
    }

    // UPDATE

    /**
     * Updates a Lead.
     * @param id Receives the Id of the Lead to update by Param.
     * @param team Receives a Lead Object with the information to update by Body.
     * @throws DataNotFoundException a Exception
     */
    @PutMapping("/team/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateLead(@PathVariable Integer id, @RequestBody Team lead) throws DataNotFoundException {
        try {
            teamService.updateTeam(id, team);
        } catch (Exception e) {
            throw new DataNotFoundException(e.getMessage());
        }
    }

    // DELETE

    /**
     * Deletes a Lead by Id.
     * @param id Receives the Id of the Lead to delete by Param.
     * @throws DataNotFoundException a Exception
     */
    @DeleteMapping("/team/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLeadById(@PathVariable Integer id) throws DataNotFoundException {
        try {
            Team targetLead = teamService.findById(id);
            teamService.deleteLeadById(targetLead.getId());
        } catch (Exception e) {
            throw new DataNotFoundException(e.getMessage());
        }
    }
}
