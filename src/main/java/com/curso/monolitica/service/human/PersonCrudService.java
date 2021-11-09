package com.curso.monolitica.service.human;

import com.curso.monolitica.domain.human.Person;

import java.util.List;

public interface PersonCrudService {
    List<Person> getAllPersons();
}
