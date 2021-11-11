package com.curso.monolitica.service.human;

import com.curso.monolitica.domain.human.Person;

import java.util.List;
import java.util.Optional;

public interface PersonCrudService {
    List<Person> getAllPersons();
    Optional<Person> getPersonById(Integer id);
    Person savePerson(Person person);
    void deletePerson(Integer id);
}
