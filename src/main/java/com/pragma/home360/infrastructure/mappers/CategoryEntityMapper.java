package com.pragma.home360.infrastructure.mappers;

import com.pragma.home360.domain.models.CategoryModel;
import com.pragma.home360.infrastructure.entities.CategoryEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryEntityMapper {
     //Convierte un objeto
    CategoryEntity modelToEntity(CategoryModel categoryModel);
     //Convierte un objeto
    CategoryModel entityToModel(CategoryEntity categoryEntity);

     //Convierte una lista de objetos
    List<CategoryModel> entityListToModelList(List<CategoryEntity> categories);
}
