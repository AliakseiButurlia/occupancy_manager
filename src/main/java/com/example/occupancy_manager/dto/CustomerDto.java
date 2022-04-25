package com.example.occupancy_manager.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CustomerDto {
    private Long room_id;
    private BigDecimal solvency;
}
