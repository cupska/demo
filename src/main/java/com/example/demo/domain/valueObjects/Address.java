package com.example.demo.domain.valueObjects;

import lombok.Value;

@Value
public class Address {
    String street;
    String region;
    String province;
    String state;
}