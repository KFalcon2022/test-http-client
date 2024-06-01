package com.walking.testhttp.converter;

import com.walking.testhttp.domain.Car;
import com.walking.testhttp.model.request.CarRequest;
import org.springframework.stereotype.Component;

@Component
public class CarRequestConverter implements Converter<CarRequest, Car> {
    @Override
    public Car convert(CarRequest source) {
        var target = new Car();

        target.setNumber(source.getNumber());
        target.setBrandId(source.getBrandId());
        target.setModel(source.getModel());
        target.setColor(source.getColor());
        target.setYear(source.getYear());
        target.setActualTechnicalInspection(source.isActualTechnicalInspection());

        return target;
    }
}
