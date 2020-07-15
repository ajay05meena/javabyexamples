package com.akm.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "user")
@Data
public class UserEntity {
    // ids for this class must be manually assigned before calling save()
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("name")
    private String name;
}