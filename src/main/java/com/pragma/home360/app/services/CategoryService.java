package com.pragma.home360.app.services;

import com.pragma.home360.app.dto.request.CategoryRequest;
import com.pragma.home360.app.dto.response.CategoryResponse;
import com.pragma.home360.app.dto.response.SaveCategoryResponse;
import org.springframework.data.domain.Page;

public interface CategoryService {
    SaveCategoryResponse save(CategoryRequest request);

    Page<CategoryResponse> getCategories(Integer page, Integer size, boolean orderAsc);
}
