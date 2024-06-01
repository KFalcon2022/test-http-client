package com.walking.testhttp.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;

@Getter
@Builder
@Schema(description = "Автомобиль")
public class CarDto {

    @Schema(description = "Id")
    private final String id;

    @Schema(description = "Id бренда")
    private String brandId;

    @Schema(description = "Год выпуска")
    private int year;

    @Schema(description = "Название модели")
    private String model;

    @Schema(description = "Цвет")
    private String color;

    @Schema(description = "Гос. номер")
    private String number;

    @Schema(description = "Актуальность тех. осмотра")
    private boolean actualTechnicalInspection;

    @Schema(description = "Дата создания автомобиля в системе")
    private ZonedDateTime created;

    @Schema(description = "Дата обновления автомобиля в системе")
    private ZonedDateTime updated;
}
