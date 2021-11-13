package com.curso.monolitica.repository.config;

import com.curso.monolitica.domain.config.Country;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country, Integer> {
}
