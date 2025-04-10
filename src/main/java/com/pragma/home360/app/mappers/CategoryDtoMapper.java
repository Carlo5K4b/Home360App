package com.pragma.home360.app.mappers;

import com.pragma.home360.app.dto.request.SaveCategoryRequest;
import com.pragma.home360.app.dto.response.CategoryResponse;
import com.pragma.home360.domain.models.CategoryModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryDtoMapper {
    CategoryModel requestToModel(SaveCategoryRequest saveCategoryRequest);

    CategoryResponse modelToResponse(CategoryModel categoryModel);

    List<CategoryResponse> modelListToResponseList(List<CategoryModel> categories);

}
