package com.curso.monolitica.service.config.mapper;

import com.curso.monolitica.domain.config.Country;
import com.curso.monolitica.dto.config.CountryDTO;
import com.curso.monolitica.service.CustomMapper;
import com.curso.monolitica.util.StringCustomUtil;
import org.springframework.stereotype.Component;

@Component
public class CountryMapper implements CustomMapper<CountryDTO, Country> {

    @Override
    public CountryDTO toDto(Country country) {
        CountryDTO countryDTO = new CountryDTO();
        countryDTO.setId(country.getId());
        countryDTO.setName(country.getName());
        countryDTO.setSigla(country.getInitials());

        return countryDTO;
    }

    @Override
    public Country toEntity(CountryDTO countryDTO) {
        Country country = new Country();
        country.setId(countryDTO.getId());
        country.setName(StringCustomUtil.toUpperCaseAllFirstChar(countryDTO.getName().trim()));
        country.setInitials(countryDTO.getSigla().trim().toUpperCase());

        return country;
    }
}
