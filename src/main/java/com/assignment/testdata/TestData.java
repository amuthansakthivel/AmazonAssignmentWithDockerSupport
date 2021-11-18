package com.assignment.testdata;


import lombok.Builder;
import lombok.Getter;

@Builder(setterPrefix = "set")
@Getter
public class TestData {

    private String itemName;
    private int quantity;
    private String titleToVerify;
}
