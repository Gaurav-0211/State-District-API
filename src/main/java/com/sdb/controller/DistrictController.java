package com.sdb.controller;

import com.sdb.dto.DistrictDto;
import com.sdb.service.DistrictService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/district")
public class DistrictController {

    private final DistrictService districtService;
    public DistrictController(DistrictService districtService){
        this.districtService = districtService;
    }

    @PostMapping
    public ResponseEntity<DistrictDto> create(@RequestBody DistrictDto districtDto){
        return ResponseEntity.ok(districtService.createDistrict(districtDto));
    }

    @GetMapping
    public List<DistrictDto> getAll(){
        return districtService.getAllDistrict();
    }
}
