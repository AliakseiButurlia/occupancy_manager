package com.example.occupancy_manager.controller;

import com.example.occupancy_manager.dto.RoomDto;
import com.example.occupancy_manager.mapper.RoomMapper;
import com.example.occupancy_manager.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/room")
public class RoomController {


    private final RoomService roomService;

    private final RoomMapper roomMapper;


    @Autowired
    public RoomController(RoomService roomService, RoomMapper roomMapper) {
        this.roomService = roomService;
        this.roomMapper = roomMapper;
    }

    @PostMapping("/create")
    ResponseEntity<Void> createRoom(@RequestBody RoomDto roomDto) {
        roomService.createOrUpdateRoom(roomMapper.toEntity(roomDto));
        return ResponseEntity.ok().build();
    }
}
