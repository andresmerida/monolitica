package com.curso.monolitica.repository.human;

import com.curso.monolitica.domain.human.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Integer> {
}
