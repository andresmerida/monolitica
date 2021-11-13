package com.curso.monolitica.dto.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CountryDTO {
    private Integer id;
    private String name;
    private String sigla;
}
