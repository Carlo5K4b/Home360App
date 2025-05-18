package com.pragma.home360.app.services;

import com.pragma.home360.app.dto.request.SaveLocationsRequest;
import com.pragma.home360.app.dto.response.LocationsResponse;
import com.pragma.home360.app.dto.response.SaveLocationsResponse;
import org.springframework.data.domain.Page;

public interface LocationsService {
    SaveLocationsResponse save(SaveLocationsRequest request);

    Page<LocationsResponse> getLocations(Integer page, Integer size, boolean orderAsc);
}
