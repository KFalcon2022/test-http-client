package com.walking.testhttp.service;

import com.walking.testhttp.domain.Brand;
import com.walking.testhttp.exception.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class BrandStorageService {

    private final Map<String, Brand> storage = new ConcurrentHashMap<>();

    public List<Brand> getAll() {
        return new ArrayList<>(storage.values());
    }

    public Brand getById(String id) {
        var brand = storage.get(id);

        if (brand == null) {
            throw new ObjectNotFoundException(Brand.class, id);
        }

        return brand;
    }

    public boolean existsById(String id) {
        return storage.containsKey(id);
    }

    public Brand create(Brand brand) {
        var id = UUID.randomUUID().toString();

        brand.setId(id);

        var now = LocalDateTime.now();
        brand.setCreated(now);
        brand.setUpdated(now);

        storage.put(id, brand);

        return brand;
    }

    public Brand update(String id, Brand brand) {
        var old = getById(id);

        brand.setId(id);
        brand.setCreated(old.getCreated());
        brand.setUpdated(LocalDateTime.now());

        storage.put(id, brand);

        return brand;
    }

    public void delete(String id) {
        storage.remove(id);
    }
}
