package com.walking.testhttp.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Car {
    private String id;

    private String brandId;

    private int year;
    private String model;
    private String color;
    private String number;
    private boolean actualTechnicalInspection;

    private LocalDateTime created;
    private LocalDateTime updated;
}
