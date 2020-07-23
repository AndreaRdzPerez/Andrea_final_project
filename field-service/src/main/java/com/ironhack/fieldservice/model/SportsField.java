package com.ironhack.fieldservice.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document
@Data
public class SportsField {
    @Id
    private String id;
    private String name;
    private String location;
}
