package com.slb.enums;

public enum Department {

    SHOP("SHOP"), FACTORY("FACTORY");

    private String value;

    Department(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
