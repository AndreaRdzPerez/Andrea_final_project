package com.ironhack.matchservice.repository;

import com.ironhack.matchservice.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MatchRepository extends JpaRepository<Match, Integer> {

    // READ

    /**
     * This method finds all matches from matchRepository.
     *
     * @return A Team's list (List)
     */
    public List<Match> findAll();

    /**
     * This method finds matches whose id matches with param
     *
     * @param id A integer value
     * @return A Optional Team whose lead's id matches with param.
     */
    public Optional<Match> findById(Integer id);

}
