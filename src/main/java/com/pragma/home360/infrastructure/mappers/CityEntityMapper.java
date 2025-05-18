package com.pragma.home360.infrastructure.mappers;

import com.pragma.home360.domain.models.CityModel;
import com.pragma.home360.infrastructure.entities.CityEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CityEntityMapper {
    //Convierte un objeto
    CityEntity modelToEntity(CityModel cityModel);
    //Convierte un objeto
    CityModel entityToModel(CityEntity cityEntity);

    //Convierte una lista de objetos
    List<CityModel> entityListToModelList(List<CityEntity> cities);
}
