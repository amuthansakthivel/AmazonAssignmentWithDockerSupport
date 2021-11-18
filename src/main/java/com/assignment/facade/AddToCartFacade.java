package com.assignment.facade;

import com.assignment.pages.ProductDescriptionPage;

public final class AddToCartFacade {


    private final ProductDescriptionPage productDescriptionPage;
    private Double priceOfOneItem;

    public AddToCartFacade(){
        productDescriptionPage = new ProductDescriptionPage();
    }

    public AddToCartFacade addProductWithMentionedQtyToCart(int qty){
        priceOfOneItem = productDescriptionPage.switchToNewWindow().getPriceOfOneItem();
        productDescriptionPage.addQtyToCart(qty);
        return this;
    }
    public Double getPriceOfOneItem(){
        return priceOfOneItem;
    }
}
