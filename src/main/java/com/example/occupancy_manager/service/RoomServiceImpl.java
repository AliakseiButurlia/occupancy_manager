package com.example.occupancy_manager.service;

import com.example.occupancy_manager.model.Room;
import com.example.occupancy_manager.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private final RoomRepository repository;

    public RoomServiceImpl(RoomRepository repository) {
        this.repository = repository;
    }

    @Override
    public Room createOrUpdateRoom(Room room) {
        return repository.save(room);
    }

    @Override
    public List<Room> getAvailableRooms() {
        List<Room> rooms = (List<Room>) repository.findAll();
        return rooms.stream().filter(room -> room.getCustomer() != null).collect(Collectors.toList());
    }
}
