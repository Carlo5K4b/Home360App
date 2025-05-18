package com.pragma.home360.infrastructure.endpoints.rest;

import com.pragma.home360.app.dto.request.SaveLocationsRequest;
import com.pragma.home360.app.dto.response.LocationsResponse;
import com.pragma.home360.app.dto.response.SaveLocationsResponse;
import com.pragma.home360.app.services.LocationsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v2/location")
@RequiredArgsConstructor

public class LocationsController {
    private final LocationsService locationsService;

    @Operation(summary = "Save location")
    @PostMapping("/")
    public ResponseEntity<SaveLocationsResponse> save(@RequestBody SaveLocationsRequest saveLocationsRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(locationsService.save(saveLocationsRequest));
    }


    @Operation(summary = "List locations")
    @GetMapping("/")
    public ResponseEntity<Page<LocationsResponse>> getAllLocations(
            @RequestParam Integer page,
            @RequestParam  Integer size,
            @RequestParam  boolean orderAsc) {
        return ResponseEntity.ok(locationsService.getLocations(page, size, orderAsc));
    }
}


