package com.assignment.facade;

import com.assignment.pages.HomePage;

public final class SearchFacade {

    private final HomePage homePage;

    public SearchFacade(){
        homePage = new HomePage();
    }
    public void searchItem(String item){
        homePage.searchItemInSearchBox(item).sortResultsWithPriceHighToLow();
    }
}
