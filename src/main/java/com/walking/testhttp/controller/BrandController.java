package com.walking.testhttp.controller;

import com.walking.testhttp.converter.BrandConverter;
import com.walking.testhttp.converter.BrandRequestConverter;
import com.walking.testhttp.model.BrandDto;
import com.walking.testhttp.model.request.BrandRequest;
import com.walking.testhttp.service.BrandStorageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("public/v1/brand")
@Tag(name = "brand-controller", description = "API для работы с брендами автомобилей")
public class BrandController {
    private final BrandStorageService brandStorageService;

    private final BrandConverter brandConverter;
    private final BrandRequestConverter brandRequestConverter;

    @GetMapping("/list")
    @Operation(description = "Получение списка всех брендов")
    public ResponseEntity<List<BrandDto>> getAll() {
        var result = brandStorageService.getAll();

        return ResponseEntity.ok(brandConverter.convert(result));
    }

    @GetMapping
    @Operation(description = "Получение бренда по id")
    public ResponseEntity<BrandDto> getById(@RequestParam String id) {
        var result = brandStorageService.getById(id);

        return ResponseEntity.ok(brandConverter.convert(result));
    }

    @PostMapping
    @Operation(description = "Создание бренда")
    public ResponseEntity<BrandDto> create(@RequestBody @Valid BrandRequest request) {

        var brand = brandRequestConverter.convert(request);
        var result = brandStorageService.create(brand);

        return ResponseEntity.ok(brandConverter.convert(result));
    }

    @PutMapping
    @Operation(description = "Обновление бренда")
    public ResponseEntity<BrandDto> update(@RequestParam String id,
                                           @RequestBody @Valid BrandRequest request) {

        var brand = brandRequestConverter.convert(request);
        var result = brandStorageService.update(id, brand);

        return ResponseEntity.ok(brandConverter.convert(result));
    }

    @DeleteMapping
    @Operation(description = "Удаление бренда по id")
    public ResponseEntity<Void> delete(@RequestParam String id) {
        brandStorageService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
