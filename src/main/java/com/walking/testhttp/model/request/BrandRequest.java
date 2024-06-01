package com.walking.testhttp.model.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
@Schema(description = "Запрос для создания/обновления бренда автомобиля")
public class BrandRequest {

    @NotEmpty
    @Schema(description = "Название")
    private String name;

    @NotEmpty
    @Schema(description = "Страна")
    private String country;

    @Min(1900)
    @NotNull
    @Schema(description = "Год основания компании")
    private Integer foundationYear;
}
