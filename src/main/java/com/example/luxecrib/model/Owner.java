package com.example.luxecrib.model;

import com.example.luxecrib.helper.Address;
import com.example.luxecrib.helper.Guarantor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vladmihalcea.hibernate.type.json.internal.JsonTypeDescriptor;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Type;

import java.util.List;

@Entity
@Data

public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

   @Embedded
    private Guarantor guarantor;
    private Boolean stayIn;
    @Embedded
    private Address address;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "owner", cascade = CascadeType.ALL)
    private List<Property> propertyList;
}
