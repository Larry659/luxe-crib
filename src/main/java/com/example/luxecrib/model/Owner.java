package com.example.luxecrib.model;

import com.example.luxecrib.helper.Address;
import com.example.luxecrib.helper.Guarantor;
import com.vladmihalcea.hibernate.type.json.internal.JsonTypeDescriptor;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Type;

import java.util.List;

@Entity
@Data
@TypeDef(name = "json", typeClass = JsonType.class)
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ownerId;

    @Column(columnDefinition = "json")
    @Type(JsonType)
    private Guarantor guarantor;
    private Boolean stayIn;
    @Type(type = "json")
    @Column(columnDefinition = "json")
    private Address address;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "owner", cascade = CascadeType.ALL)
    private List<Property> propertyList;
}
