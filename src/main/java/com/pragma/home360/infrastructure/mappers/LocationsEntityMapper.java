package com.pragma.home360.infrastructure.mappers;

import com.pragma.home360.domain.models.LocationsModel;
import com.pragma.home360.infrastructure.entities.LocationsEntity;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface LocationsEntityMapper {
    //Convierte un objeto
    LocationsEntity modelToEntity(LocationsModel locationsModel);
    //Convierte un objeto
    LocationsModel entityToModel(LocationsEntity locationsEntity);

    //Convierte una lista de objetos
    List<LocationsModel> entityListToModelList(List<LocationsEntity> Locations);
}
