package com.pragma.home360.domain.usecases;

import com.pragma.home360.domain.exceptions.LocationsAlreadyExistsException;
import com.pragma.home360.domain.models.LocationsModel;
import com.pragma.home360.domain.ports.in.LocationsServicePort;
import com.pragma.home360.domain.ports.out.LocationsPersistencePort;
import org.springframework.data.domain.Page;

public class LocationsUseCase implements LocationsServicePort {

    private final LocationsPersistencePort locationsPersistencePort;

    public LocationsUseCase(LocationsPersistencePort locationsPersistencePort) {
        this.locationsPersistencePort = locationsPersistencePort;
    }

    @Override
    public void save(LocationsModel locationsModel) {
        locationsPersistencePort.save(locationsModel);
    }

    @Override
    public Page<LocationsModel> getLocations(Integer page, Integer size, boolean orderAsc) {
        return locationsPersistencePort.getLocations(page, size, orderAsc);
    }
}
