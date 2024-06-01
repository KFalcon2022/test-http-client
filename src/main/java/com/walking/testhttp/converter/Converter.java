package com.walking.testhttp.converter;

import java.util.List;

public interface Converter<S, T> {
    T convert(S source);

    default List<T> convert(List<S> sources) {
        return sources.stream()
                .map(this::convert)
                .toList();
    }
}
