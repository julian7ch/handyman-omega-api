package com.co.ias.Handyman.application.person.domain;

import org.apache.commons.lang3.Validate;

public class IdTypeIdentification {

    private final Integer value;

    public IdTypeIdentification(Integer value) {
        Validate.notNull(value, "Id Type of Identification can't be null");
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
