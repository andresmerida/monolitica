package com.curso.monolitica.web.rest.config;

import com.curso.monolitica.dto.config.CountryDTO;
import com.curso.monolitica.service.config.CountryService;
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

    @PostMapping
    public ResponseEntity<CountryDTO> createCountry(@RequestBody CountryDTO countryDTO) throws URISyntaxException {
        if (countryDTO.getId() != null) {
            throw new IllegalArgumentException("A new Country cannot already have an ID");
        }
        CountryDTO dto = countryService.save(countryDTO);

        return ResponseEntity.created(new URI("/countries/" + dto.getId())).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CountryDTO> editCountry(@RequestBody CountryDTO countryDTO,
                                                  @PathVariable(value = "id") final Integer id) {
        if (countryDTO.getId() == null) {
            throw new IllegalArgumentException("Invalid country id, null value");
        }

        if (!Objects.equals(id, countryDTO.getId())) {
            throw new IllegalArgumentException("Invalid id");
        }

        return ResponseEntity.ok().body(countryService.save(countryDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCountry(@PathVariable Integer id) {
        countryService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
