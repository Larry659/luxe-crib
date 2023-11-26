package com.example.luxecrib.enums;

public enum HouseType {
    One_BEDROOM("1bed"),
    Two_BEDROOM("2bed"),
   Three_BEDROOM("3bed");



    public final String label;

    HouseType(String label) {
        this.label = label;
    }
}
