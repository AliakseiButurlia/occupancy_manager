package com.example.occupancy_manager.service;

import com.example.occupancy_manager.model.Customer;
import com.example.occupancy_manager.model.Room;
import com.example.occupancy_manager.model.constants.RoomType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class OccupancyServiceImpl implements OccupancyService {

    @Override
    public Map<RoomType, BigDecimal> calculateOccupancy(List<Room> availableRooms, List<Customer> customers) {
        Map<RoomType, BigDecimal> result = new HashMap<>();

        Iterator<Room> premiumRooms = availableRooms.stream().filter(room -> RoomType.PREMIUM.equals(room.getRoomType())).iterator();
        Iterator<Room> economyRooms = availableRooms.stream().filter(room -> RoomType.ECONOMY.equals(room.getRoomType())).iterator();
        customers.sort(Comparator.comparing(Customer::getSolvency));

        for (Customer customer : customers) {
            BigDecimal sum = BigDecimal.ZERO;
            if (premiumRooms.hasNext()) {
                sum = sum.add(customer.getSolvency());
                result.put(RoomType.PREMIUM, sum);
                premiumRooms.next();

            } else if (economyRooms.hasNext() && customer.getSolvency().compareTo(BigDecimal.valueOf(100)) < 0) {
                sum = sum.add(customer.getSolvency());
                result.put(RoomType.ECONOMY, sum);
                economyRooms.next();
            }

        }
        return result;
    }
}
