package com.ironhack.edgeservice.client;

import com.ironhack.edgeservice.exception.DataNotFoundException;
import com.ironhack.edgeservice.model.Match;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "match-service")
public interface MatchClient {

    // READ

    @GetMapping("/matches")
    @ResponseStatus(HttpStatus.OK)
    public List<Match> findAll();

    @GetMapping("/match/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Match findById(@PathVariable Integer id) throws DataNotFoundException;

    // CREATE

    @PostMapping("/match")
    @ResponseStatus(HttpStatus.CREATED)
    public Match createMatch(@RequestBody Match match);

    // UPDATE

    @PutMapping("/match/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateMatch(@PathVariable Integer id, @RequestBody Match match);

    // DELETE

    @DeleteMapping("/match/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMatchById(@PathVariable Integer id);
}
