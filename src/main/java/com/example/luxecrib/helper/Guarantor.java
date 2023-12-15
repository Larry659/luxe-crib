package com.example.luxecrib.helper;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.Data;

@Data
@Embeddable
public class Guarantor {
    private String fullName;
    @Embedded
    private Address address;

}
