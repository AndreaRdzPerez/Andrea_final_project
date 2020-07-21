package com.ironhack.fieldservice.repository;

import com.ironhack.fieldservice.model.Field;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FieldRepository extends JpaRepository<Field, String> {
    /**
     * This method finds fields whose id matches with param
     *
     * @param id A integer value
     * @return A Optional Team whose lead's id matches with param.
     */
    public Optional<Field> findById(Integer id);
}
