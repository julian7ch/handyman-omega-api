package com.co.ias.Handyman.application.person.domain;

import com.co.ias.Handyman.application.person.domain.PersonId;
import com.co.ias.Handyman.application.person.domain.PersonNames;
import com.co.ias.Handyman.application.person.domain.PersonIdentification;
import com.co.ias.Handyman.application.person.domain.IdTypeIdentification;

public class Person {

    private final PersonId personId;
    private final PersonNames personNames;
    private final PersonIdentification personIdentification;
    private final IdTypeIdentification idTypeIdentification;



    public Person(PersonId personId, PersonNames personNames, PersonIdentification personIdentification, IdTypeIdentification idTypeIdentification) {
        this.personId = personId;
        this.personNames = personNames;
        this.personIdentification = personIdentification;
        this.idTypeIdentification = idTypeIdentification;
    }

    public PersonId getPersonId() {
        return personId;
    }

    public PersonNames getPersonNames() {
        return personNames;
    }

    public PersonIdentification getPersonIdentification() {
        return personIdentification;
    }

    public IdTypeIdentification getIdTypeIdentification() {
        return idTypeIdentification;
    }
}
