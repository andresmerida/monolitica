package com.curso.monolitica.service.config;

import com.curso.monolitica.domain.human.Person;
import com.curso.monolitica.dto.config.CountryDTO;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<CountryDTO> getAllCountries();
    Optional<CountryDTO> getCountryById(Integer id);
    CountryDTO save(CountryDTO countryDTO);
    void delete(Integer id);
}
