package com.example.occupancy_manager.controller;

import com.example.occupancy_manager.dto.CustomerDto;
import com.example.occupancy_manager.mapper.CustomerMapper;
import com.example.occupancy_manager.model.Customer;
import com.example.occupancy_manager.model.Room;
import com.example.occupancy_manager.model.constants.RoomType;
import com.example.occupancy_manager.service.OccupancyService;
import com.example.occupancy_manager.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/occupancy")
public class OccupancyController {

    private final OccupancyService occupancyService;
    private final CustomerMapper customerMapper;
    private final RoomService roomService;

    @Autowired
    public OccupancyController(OccupancyService occupancyService, CustomerMapper customerMapper, RoomService roomService) {
        this.occupancyService = occupancyService;
        this.customerMapper = customerMapper;
        this.roomService = roomService;
    }


    @PostMapping("/result")
    ResponseEntity<Map<RoomType, BigDecimal>> getOccupancyResult(@RequestBody List<CustomerDto> customerDtoList) {
        List<Customer> customers = customerDtoList.stream().map(customerMapper::toEntity).collect(Collectors.toList());
        List<Room> availableRooms = roomService.getAvailableRooms();
        if (!availableRooms.isEmpty() && !customers.isEmpty()) {
            return new ResponseEntity<>(occupancyService.calculateOccupancy(availableRooms, customers), HttpStatus.OK);
        }
        return new ResponseEntity<>(new HashMap<>(), HttpStatus.BAD_REQUEST);
    }
}
