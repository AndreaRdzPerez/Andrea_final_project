package com.ironhack.edgeservice.controller;

import com.ironhack.edgeservice.exception.DataNotFoundException;
import com.ironhack.edgeservice.model.Field;
import com.ironhack.edgeservice.service.FieldService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Lead Controller")
@RestController
public class FieldController {

    @Autowired
    private FieldService fieldService;

    // READ

    /**
     * Find a Field by Id.
     *
     * @param id Receives the Id of the Field for searching by Param.
     * @return Returns the Field with the Id given.
     * @throws DataNotFoundException a Exception
     */
    @GetMapping("/field/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Field findById(@PathVariable Integer id) {
        return fieldService.findById(id);
    }

}
