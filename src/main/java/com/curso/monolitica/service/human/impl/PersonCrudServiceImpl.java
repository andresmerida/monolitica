package com.curso.monolitica.service.human.impl;

import com.curso.monolitica.domain.human.Person;
import com.curso.monolitica.repository.human.PersonRepository;
import com.curso.monolitica.service.human.PersonCrudService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonCrudServiceImpl implements PersonCrudService {

    private final PersonRepository personRepository;

    public PersonCrudServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> getAllPersons() {
        return (List<Person>) personRepository.findAll();
    }
}
