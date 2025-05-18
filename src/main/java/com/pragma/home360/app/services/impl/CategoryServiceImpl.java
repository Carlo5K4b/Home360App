package com.pragma.home360.app.services.impl;

import com.pragma.home360.app.dto.request.CategoryRequest;
import com.pragma.home360.app.dto.response.CategoryResponse;
import com.pragma.home360.app.dto.response.SaveCategoryResponse;
import com.pragma.home360.app.mappers.CategoryDtoMapper;
import com.pragma.home360.app.services.CategoryService;
import com.pragma.home360.domain.models.CategoryModel;
import com.pragma.home360.domain.ports.in.CategoryServicePort;
import com.pragma.home360.commons.constans.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryServicePort categoryServicePort;
    private final CategoryDtoMapper categoryDtoMapper;

    @Override
    public SaveCategoryResponse save(CategoryRequest request) {
        categoryServicePort.save(categoryDtoMapper.requestToModel(request));
        return new SaveCategoryResponse(Constants.SAVE_CATEGORY_RESPONSE_MESSAGE, LocalDateTime.now());
    }

    @Override
    public Page<CategoryResponse> getCategories(Integer page, Integer size, boolean orderAsc) {
        //return categoryDtoMapper.modelListToResponseList(categoryServicePort.getCategories(page, size, orderAsc));
        Page<CategoryModel> categoryModelMyPages = categoryServicePort.getCategories(page, size, orderAsc);
        List<CategoryResponse> categoryResponses = categoryDtoMapper.modelListToResponseList(categoryModelMyPages.getContent());
        return new PageImpl<>(categoryResponses, PageRequest.of(page, size), categoryModelMyPages.getTotalElements());
    }
}
