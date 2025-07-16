package com.sdb.service.impl;

import com.sdb.dto.DistrictDto;
import com.sdb.dto.StateDto;
import com.sdb.entity.State;
import com.sdb.repo.StateRepo;
import com.sdb.service.StateService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StateServiceImpl implements StateService {
    private final StateRepo stateRepo;
    private final ModelMapper mapper;

    public StateServiceImpl(StateRepo stateRepo, ModelMapper mapper){
        this.stateRepo = stateRepo;
        this.mapper = mapper;
    }

    @Override
    public StateDto createState(StateDto stateDto) {
        State state = mapper.map(stateDto, State.class);
        State saved = stateRepo.save(state);
        return mapToStateDto(saved);
    }

    @Override
    public List<StateDto> getAllState() {
        return stateRepo.findAll()
                .stream()
                .map(this::mapToStateDto)
                .collect(Collectors.toList());
    }

    private StateDto mapToStateDto(State state) {
        StateDto dto = mapper.map(state, StateDto.class);

        if (state.getDistricts() != null) {
            List<DistrictDto> districtDtos = state.getDistricts().stream()
                    .map(d -> mapper.map(d, DistrictDto.class))
                    .collect(Collectors.toList());
            dto.setDistricts(districtDtos);
        }

        return dto;
    }
}
