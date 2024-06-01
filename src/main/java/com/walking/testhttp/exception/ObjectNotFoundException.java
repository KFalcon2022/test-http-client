package com.walking.testhttp.exception;

public class ObjectNotFoundException extends RuntimeException {
    public ObjectNotFoundException(Class<?> clazz, String id) {
        super("%s с id '%s' не найден".formatted(clazz.getSimpleName(), id));
    }
}
