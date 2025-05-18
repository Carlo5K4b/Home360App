package com.pragma.home360.commons.beans;

import com.pragma.home360.domain.ports.in.CategoryServicePort;
import com.pragma.home360.domain.ports.in.LocationsServicePort;
import com.pragma.home360.domain.ports.out.CategoryPersistencePort;
import com.pragma.home360.domain.ports.out.LocationsPersistencePort;
import com.pragma.home360.domain.usecases.CategoryUseCase;
import com.pragma.home360.domain.usecases.LocationsUseCase;
import com.pragma.home360.infrastructure.adapters.persistence.CategoryPersistenceAdapter;
import com.pragma.home360.infrastructure.adapters.persistence.LocationsPersistenceAdapter;
import com.pragma.home360.infrastructure.mappers.CategoryEntityMapper;
import com.pragma.home360.infrastructure.mappers.LocationsEntityMapper;
import com.pragma.home360.infrastructure.repositories.mysql.CategoryRepository;
import com.pragma.home360.infrastructure.repositories.mysql.LocationsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final CategoryRepository categoryRepository;
    private final CategoryEntityMapper categoryEntityMapper;
    private final LocationsRepository locationsRepository;
    private final LocationsEntityMapper locationsEntityMapper;


    @Bean
    public CategoryServicePort categoryServicePort() {
        return new CategoryUseCase(categoryPersistencePort());
    }

    @Bean
    public CategoryPersistencePort categoryPersistencePort() {
        return new CategoryPersistenceAdapter(categoryRepository, categoryEntityMapper);
    }

    @Bean
    public LocationsServicePort locationsServicePort() {
        return new LocationsUseCase(locationsPersistencePort());
    }

    @Bean
    public LocationsPersistencePort locationsPersistencePort() {
        return new LocationsPersistenceAdapter(locationsRepository, locationsEntityMapper);
    }

}
