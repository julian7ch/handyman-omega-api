package com.co.ias.Handyman.application.person.ports.out;

import com.co.ias.Handyman.application.person.domain.Person;
import com.co.ias.Handyman.application.person.domain.PersonId;

public interface PersonRepository {

    Integer store(Person product);
    Person getId(PersonId productId);
    Person update(Person product);
    Integer delete(PersonId productId);

}
