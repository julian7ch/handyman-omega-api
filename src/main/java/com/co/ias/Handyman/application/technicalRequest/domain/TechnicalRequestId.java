package com.co.ias.Handyman.application.technicalRequest.domain;

import org.apache.commons.lang3.Validate;

public class TechnicalRequestId {

    private final Integer value;

    public TechnicalRequestId(Integer value) {
        Validate.notNull(value, "Technical Request ID can't be null");
        Validate.isTrue( value < 99999999, "Product ID can't be longer than 10 characters" );
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


