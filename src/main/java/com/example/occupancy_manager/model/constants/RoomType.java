package com.example.occupancy_manager.model.constants;

public enum RoomType {
    ECONOMY("economy"),
    PREMIUM("premium");

    private final String value;

    RoomType(String roomType) {
        this.value = roomType;
    }
}
