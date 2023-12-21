package com.example.luxecrib.dto.response;

import com.example.luxecrib.enums.HouseType;
import com.example.luxecrib.helper.Address;
import com.example.luxecrib.model.Owner;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class PropertyResponse {
    private String description;
    private Address address;
    private HouseType houseType;
    private String photos;
    private Boolean isVacant;
    private Boolean forLease;
    private Boolean forSale;
    private Double amount;
    private Owner ownerId;

}
