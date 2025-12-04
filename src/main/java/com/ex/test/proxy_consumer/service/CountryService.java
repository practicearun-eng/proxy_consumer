package com.ex.test.proxy_consumer.service;

import com.ex.test.proxy_consumer.dto.CountryDto;
import com.ex.test.proxy_consumer.entity.Country;
import com.ex.test.proxy_consumer.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;

    public List<CountryDto> getAllCountries() {
        return countryRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public CountryDto getCountryById(Long id) {
        return countryRepository.findById(id).map(this::toDto).orElse(null);
    }

    public CountryDto saveCountry(CountryDto dto) {
        Country country = new Country();
        country.setName(dto.getName());
        country.setCode(dto.getCode());
        Country saved = countryRepository.save(country);
        return toDto(saved);
    }

    private CountryDto toDto(Country country) {
        CountryDto dto = new CountryDto();
        dto.setId(country.getId());
        dto.setName(country.getName());
        dto.setCode(country.getCode());
        return dto;
    }
}