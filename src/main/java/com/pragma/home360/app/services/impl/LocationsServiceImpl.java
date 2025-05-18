package com.pragma.home360.app.services.impl;

import com.pragma.home360.app.dto.request.SaveLocationsRequest;
import com.pragma.home360.app.dto.response.LocationsResponse;
import com.pragma.home360.app.dto.response.SaveLocationsResponse;
import com.pragma.home360.app.mappers.LocationsDtoMapper;
import com.pragma.home360.app.services.LocationsService;
import com.pragma.home360.commons.constans.Constants;
import com.pragma.home360.domain.models.LocationsModel;
import com.pragma.home360.domain.ports.in.LocationsServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor

public class LocationsServiceImpl implements LocationsService {
    private final LocationsServicePort locationsServicePort;
    private final LocationsDtoMapper locationsDtoMapper;

    @Override
    public SaveLocationsResponse save(SaveLocationsRequest request) {
        locationsServicePort.save(locationsDtoMapper.requestToModel(request));
        return new SaveLocationsResponse(Constants.SAVE_LOCATION_RESPONSE_MESSAGE, LocalDateTime.now());
    }

    @Override
    public Page<LocationsResponse> getLocations(Integer page, Integer size, boolean orderAsc) {
        Page<LocationsModel> locationsModelMyPages = locationsServicePort.getLocations(page, size, orderAsc);
        List<LocationsResponse> locationsResponses = locationsDtoMapper.modelListToResponseList(locationsModelMyPages.getContent());
        return new PageImpl<>(locationsResponses, PageRequest.of(page, size), locationsModelMyPages.getTotalElements());
    }
}