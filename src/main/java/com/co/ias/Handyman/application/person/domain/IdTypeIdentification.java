package com.co.ias.Handyman.application.person.domain;

public class IdTypeIdentification {

    private final Integer value;

    public IdTypeIdentification(Integer value) {
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
