package com.pragma.home360.domain.exceptions;

public class LocationsAlreadyExistsException extends RuntimeException {
    public LocationsAlreadyExistsException(String message) {
        super(message);
    }
}
