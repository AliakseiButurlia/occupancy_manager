package com.example.occupancy_manager.mapper;

import com.example.occupancy_manager.dto.CustomerDto;
import com.example.occupancy_manager.model.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerDto toDTO(Customer customer);
    Customer toEntity(CustomerDto roomDto);
}
