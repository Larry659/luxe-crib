package com.example.luxecrib.helper;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Guarantor {
    private String fullName;
    private Address address;

}
