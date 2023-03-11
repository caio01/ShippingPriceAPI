package com.practicaltest.model;

public class Zipcode {
    private String zipcode;

    public Zipcode (String zipcode) {
        this.zipcode = zipcode;
    }

    public Zipcode () {}

    public String getCep() {
        return zipcode;
    }
    public void setCep(String zipcode) {
        this.zipcode = zipcode;
    }
}
