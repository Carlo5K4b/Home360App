package com.pragma.home360.domain.ports.in;

import com.pragma.home360.domain.models.CategoryModel;
import org.springframework.data.domain.Page;

public interface CategoryServicePort {

    void save(CategoryModel categoryModel);

    Page<CategoryModel> getCategories(Integer page, Integer size, boolean orderAsc);

}
