package com.assignment.pages;

import com.assignment.pages.pagecomponents.ProductSummaryComponent;
import com.assignment.utils.SeleniumActions;

public final class ProductDescriptionPage {

    private final ProductSummaryComponent productSummaryComponent;

    public ProductDescriptionPage(){
        productSummaryComponent = new ProductSummaryComponent();
    }

    public ProductDescriptionPage switchToNewWindow(){
        SeleniumActions.switchToNewlyOpenedWindow();
        return this;
    }

    public ProductDescriptionPage addQtyToCart(int qty){
        productSummaryComponent.selectQty(qty).clickAddToCart();
        return this;
    }

    public Double getPriceOfOneItem(){
        return productSummaryComponent.getPriceOfOneItem();
    }


}
