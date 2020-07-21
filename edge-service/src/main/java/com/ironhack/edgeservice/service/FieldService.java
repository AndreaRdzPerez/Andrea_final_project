package com.ironhack.edgeservice.service;

import com.ironhack.edgeservice.client.FieldClient;
import com.ironhack.edgeservice.exception.DataNotFoundException;
import com.ironhack.edgeservice.model.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FieldService {

    /**
     * Attributes
     */

    @Autowired
    private FieldClient fieldClient;

    /**
     * This method get a team whose id attribute matches id patam
     * @param id a integer value
     * @return  A team which was found
     * @throws DataNotFoundException if there isn't any team whose id doesn't matches id param
     */
    public Field findById(Integer id) throws DataNotFoundException {
        //String fieldToken = "Bearer " + jwtUtil.generateToken("field-service");
        return fieldClient.findById(id);
    }

}
