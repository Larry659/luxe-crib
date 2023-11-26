package com.example.luxecrib.helper;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
    private String state;
    private String city;
    private String street;
}
