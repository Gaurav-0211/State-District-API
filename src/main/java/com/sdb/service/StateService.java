package com.sdb.service;

import com.sdb.dto.StateDto;

import java.util.List;

public interface StateService {
    StateDto createState(StateDto stateDto);
    List<StateDto> getAllState();
}
