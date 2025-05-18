package com.pragma.home360.domain.models;

import com.pragma.home360.domain.exceptions.DescriptionMaxSizeExceededException;
import com.pragma.home360.domain.exceptions.NameMaxSizeExceededException;
import com.pragma.home360.domain.utils.constants.DomainConstants;

import java.util.Objects;

public class CityModel {

    private Long id;
    private String name;
    private String description;
    private Long idState;
    private int nameLimitcharacters = 50;
    private int descriptionLimitcharacters = 90;

    public CityModel(Long id, String name, String description, Long idState) {
        if (name.length() > nameLimitcharacters){
            throw new NameMaxSizeExceededException("Name exceeds maximum size of 50 characters");
        }

        if (description.length() > descriptionLimitcharacters){
            throw new DescriptionMaxSizeExceededException("Description exceeds maximum size of 90 characters");
        }

        this.id = id;
        this.name = Objects.requireNonNull(name, DomainConstants.FIELD_NAME_NULL_MESSAGE);
        this.description = Objects.requireNonNull(description,  DomainConstants.FIELD_DESCRIPTION_NULL_MESSAGE);
        this.idState = idState;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        if (name.length() > nameLimitcharacters){
            throw new NameMaxSizeExceededException("Name exceeds maximum size of 50 characters");
        }
        this.name = Objects.requireNonNull(name, DomainConstants.FIELD_NAME_NULL_MESSAGE);
    }

    public void setDescription(String description) {
        if (description.length() > descriptionLimitcharacters){
            throw new DescriptionMaxSizeExceededException("Ciudad exceeds maximum size of 90 characters");
        }
        this.description = Objects.requireNonNull(description,  DomainConstants.FIELD_DESCRIPTION_NULL_MESSAGE);
    }

}