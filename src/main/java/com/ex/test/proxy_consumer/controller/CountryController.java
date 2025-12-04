package com.ex.test.proxy_consumer.controller;

import com.ex.test.proxy_consumer.dto.CountryDto;
import com.ex.test.proxy_consumer.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/countries")
public class CountryController {
    @Autowired
    private CountryService countryService;

    @GetMapping
    public List<CountryDto> getAllCountries() {
        return countryService.getAllCountries();
    }

    @GetMapping("/{id}")
    public CountryDto getCountry(@PathVariable Long id) {
        return countryService.getCountryById(id);
    }

    @PostMapping
    public CountryDto createCountry(@RequestBody CountryDto dto) {
        return countryService.saveCountry(dto);
    }
}