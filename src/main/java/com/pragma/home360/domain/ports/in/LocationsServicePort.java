package com.pragma.home360.domain.ports.in;
import com.pragma.home360.domain.models.LocationsModel;
import org.springframework.data.domain.Page;

public interface LocationsServicePort {

    void save(LocationsModel locationsModel);

    Page<LocationsModel> getLocations(Integer page, Integer size, boolean orderAsc);

}
