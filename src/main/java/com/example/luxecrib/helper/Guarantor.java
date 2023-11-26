package com.example.luxecrib.helper;

import jakarta.persistence.Embeddable;

@Embeddable
public class Guarantor {
    private String fullName;
    private Address address;

}
