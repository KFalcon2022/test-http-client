package com.walking.testhttp.converter;

import com.walking.testhttp.domain.Car;
import com.walking.testhttp.model.CarDto;
import org.springframework.stereotype.Component;

import java.time.ZoneId;

@Component
public class CarConverter implements Converter<Car, CarDto> {
    @Override
    public CarDto convert(Car source) {
        return CarDto.builder()
                .id(source.getId())
                .brandId(source.getBrandId())
                .model(source.getModel())
                .number(source.getNumber())
                .year(source.getYear())
                .color(source.getColor())
                .actualTechnicalInspection(source.isActualTechnicalInspection())
                .created(source.getCreated().atZone(ZoneId.systemDefault()))
                .updated(source.getUpdated().atZone(ZoneId.systemDefault()))
                .build();
    }
}
