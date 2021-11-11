package com.curso.monolitica.service.human.impl;

import com.curso.monolitica.domain.human.Person;
import com.curso.monolitica.repository.human.PersonRepository;
import com.curso.monolitica.service.human.PersonCrudService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<Person> getPersonById(Integer id) {
        return personRepository.findById(id);
    }

    @Override
    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public void deletePerson(Integer id) {
        personRepository.deleteById(id);
    }
}
