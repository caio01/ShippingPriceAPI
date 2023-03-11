package com.practicaltest.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Zipcode {
    private String zipcode;

    public Zipcode (String zipcode) {
        this.zipcode = zipcode;
    }

    public Zipcode () {}
}
