package com.pragma.home360.app.services;

import com.pragma.home360.app.dto.request.SaveCategoryRequest;
import com.pragma.home360.app.dto.response.CategoryResponse;
import com.pragma.home360.app.dto.response.SaveCategoryResponse;
import org.springframework.data.domain.Page;

public interface CategoryService {
    SaveCategoryResponse save(SaveCategoryRequest request);

    Page<CategoryResponse> getCategories(Integer page, Integer size, boolean orderAsc);
}
