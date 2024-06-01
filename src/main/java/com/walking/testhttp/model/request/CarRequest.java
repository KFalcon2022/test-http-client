package com.walking.testhttp.model.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
@Schema(description = "Запрос для создания/обновления автомобиля")
public class CarRequest {

    @NotEmpty
    @Schema(description = "Id бренда")
    private String brandId;

    @Min(1900)
    @NotNull
    @Schema(description = "Год выпуска")
    private Integer year;

    @NotEmpty
    @Schema(description = "Название модели")
    private String model;

    @NotEmpty
    @Schema(description = "Цвет")
    private String color;

    @NotEmpty
    @Schema(description = "Гос. номер")
    private String number;

    @Schema(description = "Актуальность тех. осмотра")
    private boolean actualTechnicalInspection;
}
