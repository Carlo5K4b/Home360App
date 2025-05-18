package com.pragma.home360.infrastructure.mappers;

import com.pragma.home360.domain.models.StateModel;
import com.pragma.home360.infrastructure.entities.StateEntity;

import java.util.List;

public interface StateEntityMapper {

    //Convierte un objeto
    StateEntity modelToEntity(StateModel stateModel);
    //Convierte un objeto
    StateModel entityToModel(StateEntity stateEntity);

    //Convierte una lista de objetos
    List<StateModel> entityListToModelList(List<StateEntity> states);
}

