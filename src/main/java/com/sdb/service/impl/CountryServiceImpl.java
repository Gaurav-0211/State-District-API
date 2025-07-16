package com.sdb.service.impl;

import com.sdb.dto.CountryDto;
import com.sdb.dto.DistrictDto;
import com.sdb.dto.StateDto;
import com.sdb.entity.Country;
import com.sdb.repo.CountryRepo;
import com.sdb.service.CountryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepo countryRepo;
    private final ModelMapper mapper;

    public CountryServiceImpl(CountryRepo countryRepo, ModelMapper mapper){
        this.countryRepo = countryRepo;
        this.mapper = mapper;
    }

    @Override
    public CountryDto createCountry(CountryDto countryDto) {
        Country country = mapper.map(countryDto, Country.class);
        Country saved = countryRepo.save(country);
        return mapToCountryDto(saved);
    }

    @Override
    public List<CountryDto> getAllCountry() {
        return countryRepo.findAll()
                .stream()
                .map(this::mapToCountryDto)
                .collect(Collectors.toList());
    }

    private CountryDto mapToCountryDto(Country country) {
        CountryDto dto = mapper.map(country, CountryDto.class);

        if (country.getStates() != null) {
            List<StateDto> stateDtos = country.getStates().stream().map(state -> {
                StateDto stateDto = mapper.map(state, StateDto.class);

                if (state.getDistricts() != null) {
                    List<DistrictDto> districtDtos = state.getDistricts().stream()
                            .map(district -> mapper.map(district, DistrictDto.class))
                            .collect(Collectors.toList());
                    stateDto.setDistricts(districtDtos);
                }

                return stateDto;
            }).collect(Collectors.toList());

            dto.setStates(stateDtos);
        }

        return dto;
    }
}
