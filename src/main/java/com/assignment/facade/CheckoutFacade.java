package com.assignment.facade;

import com.assignment.pages.CheckoutPage;

public final class CheckoutFacade {

    private final CheckoutPage checkoutPage;

    public CheckoutFacade(){
        checkoutPage = new CheckoutPage();
    }

    public Double getTotalCartValue(){
        return checkoutPage.getPriceFromCheckoutPage();
    }
    public void navigateToLoginOrPaymentPage(){
        checkoutPage.clickOnProceedToBuy();
    }
}
