package com.sdb.controller;

import com.sdb.dto.CountryDto;
import com.sdb.service.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/country")
public class CountryController {
    private final CountryService countryService;

    public CountryController(CountryService countryService){
        this.countryService = countryService;
    }
    @PostMapping
    public ResponseEntity<CountryDto> create(@RequestBody CountryDto countryDto){
        return ResponseEntity.ok(countryService.createCountry(countryDto));
    }

    @GetMapping
    public List<CountryDto> getAll(){
        return countryService.getAllCountry();
    }
}
