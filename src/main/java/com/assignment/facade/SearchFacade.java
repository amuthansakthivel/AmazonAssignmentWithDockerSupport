package com.assignment.facade;

import com.assignment.pages.HomePage;
import com.assignment.pages.SearchResultsPage;

public final class SearchFacade {

    private final HomePage homePage;
    private final SearchResultsPage searchResultsPage;

    public SearchFacade(){
        homePage = new HomePage();
        searchResultsPage = new SearchResultsPage();
    }
    public AddToCartFacade searchItem(String item){
        homePage.searchItemInSearchBox(item).sortResultsWithPriceHighToLow();
        searchResultsPage.chooseLowestPricedItem();
        return new AddToCartFacade();
    }
}
