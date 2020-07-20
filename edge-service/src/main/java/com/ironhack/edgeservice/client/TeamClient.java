package com.ironhack.edgeservice.client;

import com.ironhack.edgeservice.model.Team;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "team-service")
public interface TeamClient {

    // READ

    @GetMapping("/teams")
    @ResponseStatus(HttpStatus.OK)
    public List<Team> findAll();

    @GetMapping("/team/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Team findById(@PathVariable Integer id);

    @GetMapping("/team/{name}")
    @ResponseStatus(HttpStatus.OK)
    public List<Team> findByNameContaining(@PathVariable String name);

    // CREATE

    @PostMapping("/team")
    @ResponseStatus(HttpStatus.CREATED)
    public Team createTeam(@RequestBody Team team);

    // UPDATE

    @PutMapping("/team/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTeam(@PathVariable Integer id, @RequestBody Team team);

    // DELETE

    @DeleteMapping("/team/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTeamById(@PathVariable Integer id);
}
