package com.example.occupancy_manager.service;

import com.example.occupancy_manager.model.Customer;
import com.example.occupancy_manager.model.Room;
import com.example.occupancy_manager.model.constants.RoomType;
import com.example.occupancy_manager.repository.RoomRepository;
import org.junit.*;
import org.mockito.Mock;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OccupancyServiceTest {

    private RoomService roomService;
    private OccupancyService occupancyService;

    @Mock
    private RoomRepository roomRepository;


    @Before
    public void initTest() {
        roomService = new RoomServiceImpl(roomRepository);
        occupancyService = new OccupancyServiceImpl();
    }


    @Test
    public void testCalculateOccupancyPositiveCase() throws Exception {
        Room premiumRoom = new Room();
        Room economyRoom = new Room();
        premiumRoom.setRoomType(RoomType.PREMIUM);
        economyRoom.setRoomType(RoomType.ECONOMY);

        Customer customer1 = new Customer();
        Customer customer2 = new Customer();
        customer1.setSolvency(BigDecimal.TEN);
        customer2.setSolvency(BigDecimal.valueOf(101));
        List<Room> avalaibleRooms = Arrays.asList(premiumRoom, economyRoom);
        List<Customer> customers = Arrays.asList(customer1, customer2);
        Map<RoomType, BigDecimal> result = occupancyService.calculateOccupancy(avalaibleRooms, customers);
        assertEquals(BigDecimal.valueOf(101), result.get(RoomType.PREMIUM));
        assertEquals(BigDecimal.valueOf(10), result.get(RoomType.ECONOMY));
    }
}
