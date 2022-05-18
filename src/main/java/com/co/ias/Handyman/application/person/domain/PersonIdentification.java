package com.co.ias.Handyman.application.person.domain;

public class PersonIdentification {

    private final String value;

    public PersonIdentification(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
