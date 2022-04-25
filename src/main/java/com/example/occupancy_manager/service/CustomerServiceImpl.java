package com.example.occupancy_manager.service;

import com.example.occupancy_manager.model.Customer;
import com.example.occupancy_manager.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private final CustomerRepository repository;

    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    public Customer createOrUpdateCustomer(Customer customer) {
        return repository.save(customer);
    }
}
