package com.walking.testhttp.controller;

import com.walking.testhttp.converter.CarConverter;
import com.walking.testhttp.converter.CarRequestConverter;
import com.walking.testhttp.model.CarDto;
import com.walking.testhttp.model.request.CarRequest;
import com.walking.testhttp.service.CarStorageService;
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
@RequestMapping("public/v1/car")
@Tag(name = "car-controller", description = "API для работы с автомобилями")
public class CarController {
    private final CarStorageService carStorageService;

    private final CarConverter carConverter;
    private final CarRequestConverter carRequestConverter;

    @GetMapping("/list")
    @Operation(description = "Получение списка всех автомобилей")
    public ResponseEntity<List<CarDto>> getAll() {
        var result = carStorageService.getAll();

        return ResponseEntity.ok(carConverter.convert(result));
    }

    @GetMapping
    @Operation(description = "Получение автомобиля по id")
    public ResponseEntity<CarDto> getById(@RequestParam String id) {
        var result = carStorageService.getById(id);

        return ResponseEntity.ok(carConverter.convert(result));
    }

    @PostMapping
    @Operation(description = "Создание автомобиля")
    public ResponseEntity<CarDto> create(@RequestBody @Valid CarRequest request) {

        var car = carRequestConverter.convert(request);
        var result = carStorageService.create(car);

        return ResponseEntity.ok(carConverter.convert(result));
    }

    @PutMapping
    @Operation(description = "Обновление автомобиля")
    public ResponseEntity<CarDto> update(@RequestParam String id,
                                         @RequestBody @Valid CarRequest request) {

        var car = carRequestConverter.convert(request);
        var result = carStorageService.update(id, car);

        return ResponseEntity.ok(carConverter.convert(result));
    }

    @DeleteMapping
    @Operation(description = "Удаление автомобиля по id")
    public ResponseEntity<Void> delete(@RequestParam String id) {
        carStorageService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
