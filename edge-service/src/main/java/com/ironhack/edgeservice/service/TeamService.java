package com.ironhack.edgeservice.service;

import com.ironhack.edgeservice.client.TeamClient;
import com.ironhack.edgeservice.exception.DataNotFoundException;
import com.ironhack.edgeservice.model.Team;
import com.ironhack.edgeservice.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    /**
     * Attributes
     */
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private TeamClient teamClient;

    // READ

    /**
     * This method return all elements from teamRepository's list
     * @return a team's list
     */
    public List<Team> findAll() {
        return teamClient.findAll();
    }

    /**
     * This method get a team whose id attribute matches id patam
     * @param id a integer value
     * @return  A team which was found
     * @throws DataNotFoundException if there isn't any team whose id doesn't matches id param
     */
    public Team findById(Integer id) throws DataNotFoundException {
        return teamClient.findById(id);
    }


    /**
     * This method gets leads whose InformationContact's name matches with name param
     * @param name a String value
     * @return A team's list whose elements' name matches with param
     * @throws DataNotFoundException If teamRepository's list size is less than 1
     */
    public List<Team> findByNameContaining(String name) throws DataNotFoundException {
        return teamClient.findByNameContaining(name);
    }

    // CREATE
    /**
     * This method creates a new Team and adds in teamRepository's list
     * @param team  a team element
     * @return The team which was added in teamRepository's list
     */
    public Team createTeam(Team team) {
        return teamClient.createTeam(team);
    }

    // UPDATE
    /**
     * This method  update team's properties.
     * @param id  a integer value to find a exist team
     * @param team a team element to update a exist team
     * @throws DataNotFoundException if there isn't a team whose id attribute doesn't match with id param
     */
    public void updateTeam(Integer id, Team team) throws DataNotFoundException {
        teamClient.updateTeam(id,team);
    }

    // DELETE
    /**
     * This method found a match between a team's id and param id then these team will be deleted.
     * @param id a integer value to find a exist team
     * @throws DataNotFoundException if there isn't a team whose id attribute doesn't match with id param
     */
    public void deleteTeamById(Integer id) throws DataNotFoundException {
        teamClient.deleteTeamById(id);
    }

}
