package com.pragma.home360.app.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CategoryRequest(@NotNull(message = "no puede ser vacio") @NotBlank String name, @NotNull @NotBlank String description) {
}