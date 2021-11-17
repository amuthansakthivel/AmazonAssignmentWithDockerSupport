package com.assignment.pages;

import com.assignment.pages.pagecomponents.TopMenuComponent;

public class HomePage {

    private final TopMenuComponent topMenuComponent;

    public HomePage(){
        topMenuComponent = new TopMenuComponent();
    }

    public void searchItemInSearchBox(String item){
        topMenuComponent
                .setTextInSearch(item)
                .clickSearch();
    }



}
