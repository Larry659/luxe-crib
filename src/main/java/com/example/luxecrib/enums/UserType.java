package com.example.luxecrib.enums;

public enum UserType {

    OWNER("owner"),
    OCCUPANT("occupant");


    public final String label;

    UserType(String label) {
        this.label = label;
    }
}
