package com.walking.testhttp.service;

import com.walking.testhttp.domain.Brand;
import com.walking.testhttp.domain.Car;
import com.walking.testhttp.exception.ObjectNotFoundException;
import com.walking.testhttp.exception.RelatedObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
@RequiredArgsConstructor
public class CarStorageService {
    private final BrandStorageService brandStorageService;

    private final Map<String, Car> storage = new ConcurrentHashMap<>();

    public List<Car> getAll() {
        return new ArrayList<>(storage.values());
    }

    public Car getById(String id) {
        var car = storage.get(id);

        if (car == null) {
            throw new ObjectNotFoundException(Car.class, id);
        }

        return car;
    }

    public Car create(Car car) {
        validateBrand(car.getBrandId());

        var id = UUID.randomUUID().toString();

        car.setId(id);

        var now = LocalDateTime.now();
        car.setCreated(now);
        car.setUpdated(now);

        storage.put(id, car);

        return car;
    }

    public Car update(String id, Car car) {
        validateBrand(car.getBrandId());

        var old = getById(id);

        car.setId(id);
        car.setCreated(old.getCreated());
        car.setUpdated(LocalDateTime.now());

        storage.put(id, car);

        return car;
    }

    public void delete(String id) {
        storage.remove(id);
    }

    private void validateBrand(String brandId) {
        if (!brandStorageService.existsById(brandId)) {
            throw new RelatedObjectNotFoundException(Brand.class, brandId);
        }
    }
}
