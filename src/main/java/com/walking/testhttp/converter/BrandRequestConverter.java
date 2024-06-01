package com.walking.testhttp.converter;

import com.walking.testhttp.domain.Brand;
import com.walking.testhttp.model.request.BrandRequest;
import org.springframework.stereotype.Component;

@Component
public class BrandRequestConverter implements Converter<BrandRequest, Brand> {
    @Override
    public Brand convert(BrandRequest source) {
        var target = new Brand();

        target.setName(source.getName());
        target.setCountry(source.getCountry());
        target.setFoundationYear(source.getFoundationYear());

        return target;
    }
}
