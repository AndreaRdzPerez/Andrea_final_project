package com.ironhack.teamservice.repository;

import com.ironhack.teamservice.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {

    // READ

    /**
     * This method finds all teams from leadRepository.
     *
     * @return A Team's list (List)
     */
    public List<Team> findAll();

    /**
     * This method finds teams whose id matches with param
     *
     * @param id A integer value
     * @return A Optional Team whose lead's id matches with param.
     */
    public Optional<Team> findById(Integer id);

    /**
     * This method gets teams whose informationContact's name attribute matches with name param.
     *
     * @param name A String value
     * @return A lead's list (List)
     */
    public List<Team> findByNameContaining(String name);

}