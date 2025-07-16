package com.sdb.service;

import com.sdb.dto.DistrictDto;

import java.util.List;

public interface DistrictService {
    DistrictDto createDistrict(DistrictDto districtDto);
    List<DistrictDto> getAllDistrict();
}
