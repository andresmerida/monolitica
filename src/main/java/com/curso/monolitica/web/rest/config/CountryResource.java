package com.curso.monolitica.web.rest.config;

import com.curso.monolitica.dto.config.CountryDTO;
import com.curso.monolitica.service.config.CountryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryResource {

    private final CountryService countryService;


    public CountryResource(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public List<CountryDTO> getAllPersons() {
        return countryService.getAllCountries();
    }
}
