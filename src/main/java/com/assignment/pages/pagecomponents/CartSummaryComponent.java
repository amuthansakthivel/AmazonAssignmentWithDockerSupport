package com.assignment.pages.pagecomponents;

import com.assignment.utils.SeleniumActions;
import org.openqa.selenium.By;

import static com.assignment.utils.SeleniumActions.getText;

public final class CartSummaryComponent {

    private final By labelTotalCartPrice = By.xpath("(//b[text()='Cart subtotal'])[1]/../following-sibling::span");
    private final By btnProceedToBuy = By.xpath("//a[contains(text(),'Proceed to Buy')]");

    public Double getTotalCartPrice(){
        return Double.valueOf(removeRupeeSymbol(getText(labelTotalCartPrice)));
    }

    public void clickProceedToBuy(){
        SeleniumActions.waitAndClick(btnProceedToBuy,"Proceed to buy");
    }

    private String removeRupeeSymbol(String price){
        return price.substring(1);
    }


}
