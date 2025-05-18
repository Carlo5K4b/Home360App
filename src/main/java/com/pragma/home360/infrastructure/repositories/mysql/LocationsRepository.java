package com.pragma.home360.infrastructure.repositories.mysql;

import com.pragma.home360.infrastructure.entities.LocationsEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LocationsRepository extends JpaRepository<LocationsEntity, Long> {

    Optional<LocationsEntity> findBySector(String sector);

    Page<LocationsEntity> findAll(Pageable pageable);
}
