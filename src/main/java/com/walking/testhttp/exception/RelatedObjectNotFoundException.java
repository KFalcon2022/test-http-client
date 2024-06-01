package com.walking.testhttp.exception;

public class RelatedObjectNotFoundException extends ObjectNotFoundException {
    public RelatedObjectNotFoundException(Class<?> clazz, String id) {
        super(clazz, id);
    }
}
