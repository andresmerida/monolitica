package com.curso.monolitica.service.config.impl;

import com.curso.monolitica.domain.config.Country;
import com.curso.monolitica.dto.config.CountryDTO;
import com.curso.monolitica.repository.config.CountryRepository;
import com.curso.monolitica.service.config.CountryService;
import com.curso.monolitica.service.config.mapper.CountryMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;
    private final CountryMapper countryMapper;

    public CountryServiceImpl(CountryRepository countryRepository, CountryMapper countryMapper) {
        this.countryRepository = countryRepository;
        this.countryMapper = countryMapper;
    }

    @Override
    public List<CountryDTO> getAllCountries() {
        List<Country> countryList = (List<Country>) countryRepository.findAll();
        return countryList.stream().map(countryMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public Optional<CountryDTO> getCountryById(Integer id) {
        return Optional.empty();
    }

    @Override
    public CountryDTO save(CountryDTO countryDTO) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
