package com.sdb.controller;

import com.sdb.dto.StateDto;
import com.sdb.service.StateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/state")
public class StateController {

    private final StateService stateService;

    public StateController(StateService stateService){
        this.stateService = stateService;
    }

    @PostMapping
    public ResponseEntity<StateDto> create(@RequestBody StateDto stateDto){
        return ResponseEntity.ok(stateService.createState(stateDto));
    }
    @GetMapping
    public List<StateDto> getAll(){
        return stateService.getAllState();
    }

}
