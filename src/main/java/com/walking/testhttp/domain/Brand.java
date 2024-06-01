package com.walking.testhttp.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Brand {
    private String id;

    private String name;
    private String country;
    private int foundationYear;

    private LocalDateTime created;
    private LocalDateTime updated;
}
