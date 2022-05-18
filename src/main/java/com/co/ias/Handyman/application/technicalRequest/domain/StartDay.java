package com.co.ias.Handyman.application.technicalRequest.domain;

import org.apache.commons.lang3.Validate;

import java.util.Date;

public class StartDay {

    private final Date value;

    public StartDay(Date value) {
        Validate.notNull(value, "Start Day can't be null");
        this.value = value;
    }

    public Date getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
