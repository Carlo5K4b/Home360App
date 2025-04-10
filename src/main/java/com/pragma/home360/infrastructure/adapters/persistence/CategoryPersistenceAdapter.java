package com.pragma.home360.infrastructure.adapters.persistence;

import com.pragma.home360.domain.models.CategoryModel;
import com.pragma.home360.domain.ports.out.CategoryPersistencePort;
import com.pragma.home360.infrastructure.entities.CategoryEntity;
import com.pragma.home360.infrastructure.mappers.CategoryEntityMapper;
import com.pragma.home360.infrastructure.repositories.mysql.CategoryRepository;
import com.pragma.home360.commons.constans.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryPersistenceAdapter implements CategoryPersistencePort {
    private final CategoryRepository categoryRepository;
    private final CategoryEntityMapper categoryEntityMapper;

    @Override
    public void save(CategoryModel categoryModel) {
        categoryRepository.save(categoryEntityMapper.modelToEntity(categoryModel));
    }

    @Override
    public CategoryModel getCategoryByName(String categoryName) {
        return categoryEntityMapper.entityToModel(categoryRepository.findByName(categoryName).orElse(null));
    }

    @Override
    public Page<CategoryModel> getCategories(Integer page, Integer size, boolean orderAsc) {
        Pageable pagination;
        if (orderAsc) pagination = PageRequest.of(page, size, Sort.by(Constants.PAGEABLE_FIELD_NAME).ascending());
        else pagination = PageRequest.of(page, size, Sort.by(Constants.PAGEABLE_FIELD_NAME).descending());


        Page<CategoryEntity> categoryEntities = categoryRepository.findAll(pagination);
        List<CategoryModel> categoryModels = categoryEntityMapper.entityListToModelList(categoryEntities.getContent());
        long totalOfElements = categoryRepository.count();
        return new PageImpl<>(categoryModels, PageRequest.of(page, size), totalOfElements);
    }
}
