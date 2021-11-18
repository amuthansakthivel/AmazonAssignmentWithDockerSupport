package com.assignment.pages;

import com.assignment.pages.pagecomponents.CartSummaryComponent;

public final class CheckoutPage {

    private final CartSummaryComponent cartSummaryComponent;

    public CheckoutPage(){
        cartSummaryComponent = new CartSummaryComponent();
    }

    public Double getPriceFromCheckoutPage(){
        return cartSummaryComponent.getTotalCartPrice();
    }

    public void clickOnProceedToBuy(){
        cartSummaryComponent.clickProceedToBuy();
    }
}
