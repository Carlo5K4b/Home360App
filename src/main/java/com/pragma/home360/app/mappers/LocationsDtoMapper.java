package com.pragma.home360.app.mappers;

import com.pragma.home360.app.dto.request.SaveLocationsRequest;
import com.pragma.home360.app.dto.response.LocationsResponse;
import com.pragma.home360.domain.models.LocationsModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface LocationsDtoMapper {

    LocationsModel requestToModel(SaveLocationsRequest saveLocationsRequest);

    LocationsResponse modelToResponse(LocationsModel locationsModel);

    List<LocationsResponse> modelListToResponseList(List<LocationsModel> locations);

}
