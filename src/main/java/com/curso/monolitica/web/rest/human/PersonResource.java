package com.curso.monolitica.web.rest.human;

import com.curso.monolitica.domain.human.Person;
import com.curso.monolitica.service.human.PersonCrudService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/persons")
public class PersonResource {

    private final PersonCrudService personCrudService;

    public PersonResource(PersonCrudService personCrudService) {
        this.personCrudService = personCrudService;
    }

    @GetMapping
    public List<Person> getAllPersons() {
        return personCrudService.getAllPersons();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable final Integer id) {
        Person person = personCrudService.getPersonById(id)
                .orElseThrow(() -> new IllegalArgumentException("Person with id " + id + " is not existed."));
        return ResponseEntity.ok(person);
    }

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person) throws URISyntaxException {
        if (person.getId() != null) {
            throw new IllegalArgumentException("A new Person cannot already have an ID");
        }
        Person personDB = personCrudService.savePerson(person);

        return ResponseEntity.created(new URI("/persons/" + personDB.getId())).body(personDB);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> editPerson(@RequestBody Person person, @PathVariable(value = "id") final Integer id) {
        if (person.getId() == null) {
            throw new IllegalArgumentException("Invalid person id, null not allowed");
        }

        if (!Objects.equals(person.getId(), id)) {
            throw new IllegalArgumentException("Invalid id");
        }

        Person personUpdated = personCrudService.savePerson(person);

        return ResponseEntity.ok().body(personUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Integer id) {
        personCrudService.deletePerson(id);

        return ResponseEntity.ok().build();
    }
}
