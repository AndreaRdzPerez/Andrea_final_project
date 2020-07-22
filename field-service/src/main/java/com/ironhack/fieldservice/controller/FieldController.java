package com.ironhack.fieldservice.controller;

import com.ironhack.fieldservice.exception.DataNotFoundException;
import com.ironhack.fieldservice.model.SportsField;
import com.ironhack.fieldservice.service.FieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    public SportsField findById(@PathVariable Integer id) {
        return fieldService.findById(id);
    }

}
