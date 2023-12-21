package com.example.luxecrib.dto.request;

import com.example.luxecrib.enums.HouseType;
import com.example.luxecrib.helper.Address;
import com.example.luxecrib.model.Owner;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PropertyRequest {
    private String description;
    private String ownerEmail;
    private AddressRequest address;
    private HouseType houseType;
    private String photos;
    private Boolean isVacant;
    private Boolean forLease;
    private Boolean forSale;
    private Double amount;
//    private Owner owner;

}
