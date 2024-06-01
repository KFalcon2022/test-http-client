package com.walking.testhttp.converter;

import com.walking.testhttp.domain.Brand;
import com.walking.testhttp.model.BrandDto;
import org.springframework.stereotype.Component;

import java.time.ZoneId;

@Component
public class BrandConverter implements Converter<Brand, BrandDto> {
    @Override
    public BrandDto convert(Brand source) {
        return BrandDto.builder()
                .id(source.getId())
                .name(source.getName())
                .country(source.getCountry())
                .foundationYear(source.getFoundationYear())
                .created(source.getCreated().atZone(ZoneId.systemDefault()))
                .updated(source.getUpdated().atZone(ZoneId.systemDefault()))
                .build();
    }
}
