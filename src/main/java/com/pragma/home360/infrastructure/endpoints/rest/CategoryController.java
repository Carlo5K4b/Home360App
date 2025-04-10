package com.pragma.home360.infrastructure.endpoints.rest;


import com.pragma.home360.app.dto.request.SaveCategoryRequest;
import com.pragma.home360.app.dto.response.CategoryResponse;
import com.pragma.home360.app.dto.response.SaveCategoryResponse;
import com.pragma.home360.app.services.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping("/")
    @Operation(summary = "Guardar categoria")
    public ResponseEntity<SaveCategoryResponse> save(@RequestBody SaveCategoryRequest saveCategoryRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.save(saveCategoryRequest));
    }

    @GetMapping("/")
    @Operation(summary = "Listar categorias")
    public ResponseEntity<Page<CategoryResponse>> getAllCategories(@RequestParam Integer page,
                                                                   @RequestParam Integer size,
                                                                   @RequestParam boolean orderAsc) {
        return ResponseEntity.ok(categoryService.getCategories(page, size, orderAsc));
    }

}
