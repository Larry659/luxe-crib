package com.example.luxecrib.model;

import com.example.luxecrib.helper.Address;
import com.example.luxecrib.helper.Guarantor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ownerId;
    @Embedded
    private Guarantor guarantor;
    private Boolean stayIn;
    @Embedded
    private Address address;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "owner", cascade = CascadeType.ALL)
private List<Property> propertyList;
}
