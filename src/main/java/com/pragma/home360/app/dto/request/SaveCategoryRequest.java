package com.pragma.home360.app.dto.request;

import jakarta.validation.constraints.NotBlank;

public record SaveCategoryRequest(String name, String description) {
}