package com.ironhack.fieldservice.repository;

import com.ironhack.fieldservice.model.SportsField;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FieldRepository extends MongoRepository<SportsField, String> {
    /**
     * This method finds fields whose id matches with param
     *
     * @param id A integer value
     * @return A Optional Team whose lead's id matches with param.
     */
    public Optional<SportsField> findById(Integer id);
}
