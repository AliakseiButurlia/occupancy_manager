package com.example.occupancy_manager.service;

import com.example.occupancy_manager.model.Customer;
import com.example.occupancy_manager.model.Room;
import com.example.occupancy_manager.model.constants.RoomType;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface OccupancyService {

    Map<RoomType, BigDecimal>  calculateOccupancy(List<Room> availableRooms, List<Customer> customers);
}
