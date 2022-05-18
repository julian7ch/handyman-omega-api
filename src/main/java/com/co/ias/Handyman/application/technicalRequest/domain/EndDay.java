package com.co.ias.Handyman.application.technicalRequest.domain;

import java.util.Date;

public class EndDay {

    private final Date value;

    public EndDay(Date value) {
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
