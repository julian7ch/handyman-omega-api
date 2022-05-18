package com.co.ias.Handyman.application.service.domain;

public class ServiceId {

    private final Integer value;

    public ServiceId(Integer value) {
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
