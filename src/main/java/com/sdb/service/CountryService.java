package com.sdb.service;

import com.sdb.dto.CountryDto;

import java.util.List;

public interface CountryService {
    CountryDto createCountry(CountryDto countryDto);
    List<CountryDto> getAllCountry();
}
