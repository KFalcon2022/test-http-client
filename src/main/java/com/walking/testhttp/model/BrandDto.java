package com.walking.testhttp.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;

@Getter
@Builder
@Schema(description = "Бренд автомобиля")
public class BrandDto {

    @Schema(description = "Id")
    private final String id;

    @Schema(description = "Название")
    private String name;

    @Schema(description = "Страна")
    private String country;

    @Schema(description = "Год основания компании")
    private int foundationYear;

    @Schema(description = "Дата создания бренда в системе")
    private ZonedDateTime created;

    @Schema(description = "Дата обновления бренда в системе")
    private ZonedDateTime updated;
}
