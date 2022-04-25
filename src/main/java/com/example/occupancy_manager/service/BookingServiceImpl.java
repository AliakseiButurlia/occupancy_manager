package com.example.occupancy_manager.service;

import com.example.occupancy_manager.model.Customer;
import com.example.occupancy_manager.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private final RoomService roomService;

    @Autowired
    private final CustomerService customerService;

    public BookingServiceImpl(RoomService roomService, CustomerService customerService) {
        this.roomService = roomService;
        this.customerService = customerService;
    }

    @Override
    @Transactional
    public void bookRoomForCustomer(Customer customer, Room room) {
        room.setCustomer(customer);
        customer.setRoom(room);
        roomService.createOrUpdateRoom(room);
        customerService.createOrUpdateCustomer(customer);
    }


}
