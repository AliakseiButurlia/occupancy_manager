package com.example.occupancy_manager.dto;

import com.example.occupancy_manager.model.constants.RoomType;
import lombok.Data;

@Data
public class RoomDto {
    private RoomType roomType;
    private Long customer_id;
}
