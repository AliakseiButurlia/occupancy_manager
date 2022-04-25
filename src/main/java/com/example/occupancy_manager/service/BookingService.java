package com.example.occupancy_manager.service;

import com.example.occupancy_manager.model.Customer;
import com.example.occupancy_manager.model.Room;

public interface BookingService {

    void bookRoomForCustomer(Customer customer, Room room);
}
