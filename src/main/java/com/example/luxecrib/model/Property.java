package com.example.luxecrib.model;

import com.example.luxecrib.enums.HouseType;
import com.example.luxecrib.helper.Address;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String description;
    @Embedded
    private Address address;
    private HouseType houseType;
    private String photos;
    private Boolean isVacant;
    private Boolean forLease;
    private Boolean forSale;
    private Double amount;
    @ManyToOne()
    private Owner owner;
}
