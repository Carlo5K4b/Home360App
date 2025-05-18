package com.pragma.home360.domain.ports.out;

import com.pragma.home360.domain.models.LocationsModel;
import org.springframework.data.domain.Page;

public interface LocationsPersistencePort {

    void save(LocationsModel locationsModel);

    LocationsModel getLocationsBySector(String sector);

    Page<LocationsModel> getLocations(Integer page, Integer size, boolean orderAsc);

}
