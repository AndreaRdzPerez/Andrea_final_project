package com.ironhack.edgeservice.client;

import com.ironhack.edgeservice.model.Field;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Optional;

@FeignClient(name = "field-service")
public interface FieldClient {

    // READ
    @GetMapping("/field/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Field findById(@PathVariable Integer id);
}
