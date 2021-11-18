package com.assignment.tests;

import com.assignment.driver.Driver;
import com.assignment.facade.CheckoutFacade;
import com.assignment.facade.SearchFacade;
import lombok.SneakyThrows;
import org.assertj.core.api.Assertions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddToCartTests {

    @BeforeMethod
    public void setUp(){
        Driver.getInstance().setUpDriver().loadURL().maximiseWindow();
    }

    @AfterMethod
    public void tearDown(){
        Driver.getInstance().tearDownDriver();
    }

    @SneakyThrows
    @Test(description = "To check whether the user can add cheapest chocolate to the cart and verify the total cost")
    public void addToCartTest() {
        Double priceOfOneItem = new SearchFacade().searchItem("Ferroro Rocher")
                .addProductWithMentionedQtyToCart(2)
                .getPriceOfOneItem();

        Double totalCartValue = new CheckoutFacade().getTotalCartValue();

        Assertions.assertThat(totalCartValue)
                        .isPositive()
                        .isEqualTo(priceOfOneItem*2);

    }


}
