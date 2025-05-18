package com.pragma.home360.infrastructure.adapters.persistence;

import com.pragma.home360.commons.constans.Constants;
import com.pragma.home360.domain.models.LocationsModel;
import com.pragma.home360.domain.ports.out.LocationsPersistencePort;
import com.pragma.home360.infrastructure.entities.LocationsEntity;
import com.pragma.home360.infrastructure.mappers.LocationsEntityMapper;
import com.pragma.home360.infrastructure.repositories.mysql.LocationsRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class LocationsPersistenceAdapter implements LocationsPersistencePort {
    private  final LocationsRepository locationsRepository;
    private  final LocationsEntityMapper locationsEntityMapper;

    @Override
    public void save(LocationsModel locationsModel) {
        locationsRepository.save(locationsEntityMapper.modelToEntity(locationsModel));
    }


    @Override
    public LocationsModel getLocationsBySector(String Sector) {
        return locationsEntityMapper.entityToModel(locationsRepository.findBySector(Sector).orElse(null));
    }

    @Override
    public Page<LocationsModel> getLocations(Integer page, Integer size, boolean orderAsc) {
        Pageable pagination;
        if (orderAsc) pagination = PageRequest.of(page, size, Sort.by(Constants.PAGEABLE_FIELD_NAME).ascending());
        else pagination = PageRequest.of(page, size, Sort.by(Constants.PAGEABLE_FIELD_NAME).descending());


        Page<LocationsEntity> locationsEntities = locationsRepository.findAll(pagination);
        List<LocationsModel> locationsModels = locationsEntityMapper.entityListToModelList(locationsEntities.getContent());
        long totalOfElements = locationsRepository.count();
        return new PageImpl<>(locationsModels, PageRequest.of(page, size), totalOfElements);
    }
}
