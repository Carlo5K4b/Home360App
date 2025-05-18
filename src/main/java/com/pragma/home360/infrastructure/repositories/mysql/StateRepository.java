package com.pragma.home360.infrastructure.repositories.mysql;

import com.pragma.home360.infrastructure.entities.CategoryEntity;
import com.pragma.home360.infrastructure.entities.StateEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StateRepository extends JpaRepository<StateEntity, Long> {
    Optional<StateEntity> findByName(String name);

    Page<StateEntity> findAll(Pageable pageable);
}

