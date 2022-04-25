package com.example.occupancy_manager.mapper;

import com.example.occupancy_manager.dto.RoomDto;
import com.example.occupancy_manager.model.Room;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoomMapper {

    RoomDto toDTO(Room room);
    Room toEntity(RoomDto roomDto);
}
