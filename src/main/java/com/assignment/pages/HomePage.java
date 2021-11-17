package com.assignment.pages;

import com.assignment.pages.pagecomponents.SortByComponent;
import com.assignment.pages.pagecomponents.TopMenuComponent;

public class HomePage {

    private final TopMenuComponent topMenuComponent;
    private final SortByComponent sortByComponent;

    public HomePage(){
        topMenuComponent = new TopMenuComponent();
        sortByComponent = new SortByComponent();
    }

    public HomePage searchItemInSearchBox(String item){
        topMenuComponent.searchAnItemInSearchBar(item);
        return new HomePage();
    }

    public void sortResultsWithPriceHighToLow(){
        sortByComponent.sortResultsWithPriceLowToHigh();
    }



}
