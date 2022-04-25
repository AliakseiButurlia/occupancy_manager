package com.example.occupancy_manager.service;

import com.example.occupancy_manager.model.Room;

import java.util.List;

public interface RoomService {

    Room createOrUpdateRoom(Room room);

    List<Room> getAvailableRooms();
}
