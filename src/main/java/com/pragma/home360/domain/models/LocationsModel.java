package com.pragma.home360.domain.models;

import com.pragma.home360.domain.exceptions.NameMaxSizeExceededException;
import com.pragma.home360.domain.utils.constants.DomainConstants;
import java.util.Objects;

public class LocationsModel {
    private Long id;
    private Long idCity;
    private String sector;

    private static final int SECTOR_LIMIT_CHARACTERS = 90;

    // Constructor
    public LocationsModel(Long id, Long idCity, String sector) {
        this.id = id;
        this.idCity = Objects.requireNonNull(idCity, DomainConstants.FIELD_IDCITY_NULL_MESSAGE);
        this.sector = validateSector(sector);
    }

    // Getters
    public Long getId() {
        return id;
    }

    public Long getIdCity() {
        return idCity;
    }

    public String getSector() {
        return sector;
    }

    // Setter
    public void setSector(String sector) {
        this.sector = validateSector(sector);
    }

    // Método privado para validar el sector
    private String validateSector(String sector) {
        Objects.requireNonNull(sector, DomainConstants.FIELD_SECTOR_NULL_MESSAGE);
        if (sector.length() > SECTOR_LIMIT_CHARACTERS) {
            throw new NameMaxSizeExceededException("The sector exceeds maximum size of 90 characters");
        }
        return sector;
    }
}