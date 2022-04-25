package com.example.occupancy_manager.model;

import com.example.occupancy_manager.model.constants.RoomType;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "ROOMS")
@Data
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    private RoomType roomType;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn (name="customer_id")
    private Customer customer;


}
