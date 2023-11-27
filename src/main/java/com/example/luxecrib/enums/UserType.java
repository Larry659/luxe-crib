package com.example.luxecrib.enums;

public enum UserType {

    OWNER("owner"),
    AGENT("agent"),
    OCCUPANT("occupant");


    public final String label;

    UserType(String label) {
        this.label = label;
    }
}
