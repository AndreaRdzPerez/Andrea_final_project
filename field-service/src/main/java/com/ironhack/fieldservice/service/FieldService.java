package com.ironhack.fieldservice.service;

import com.ironhack.fieldservice.exception.DataNotFoundException;
import com.ironhack.fieldservice.model.Field;
import com.ironhack.fieldservice.repository.FieldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FieldService {

    /**
     * Attributes
     */
    @Autowired
    private FieldRepository fieldRepository;

    /**
     * This method get a team whose id attribute matches id patam
     * @param id a integer value
     * @return  A team which was found
     * @throws DataNotFoundException if there isn't any team whose id doesn't matches id param
     */
    public Field findById(Integer id) throws DataNotFoundException {
        return fieldRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Could not find that Field."));
    }

}
