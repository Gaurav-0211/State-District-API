package com.sdb.service.impl;

import com.sdb.dto.DistrictDto;
import com.sdb.entity.District;
import com.sdb.repo.DistrictRepo;
import com.sdb.service.DistrictService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DistrictServiceImpl implements DistrictService {

    private final DistrictRepo districtRepo;
    private final ModelMapper mapper;

    public DistrictServiceImpl(DistrictRepo districtRepo, ModelMapper mapper){
        this.districtRepo  = districtRepo;
        this.mapper = mapper;
    }

    @Override
    public DistrictDto createDistrict(DistrictDto districtDto) {
        District district = mapper.map(districtDto, District.class);
        District saved = districtRepo.save(district);
        return mapper.map(saved, DistrictDto.class);
    }

    @Override
    public List<DistrictDto> getAllDistrict() {
        return districtRepo.findAll()
                .stream()
                .map(d -> mapper.map(d, DistrictDto.class))
                .collect(Collectors.toList());
    }
}
