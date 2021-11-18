package com.assignment.tests;

import com.assignment.driver.Driver;
import com.assignment.facade.CheckoutFacade;
import com.assignment.facade.SearchFacade;
import com.assignment.testdata.TestData;
import org.assertj.core.api.Assertions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CheckoutPageTests {

    @BeforeMethod
    public void setUp(){
        Driver.getInstance().setUpDriver().loadURL().maximiseWindow();
    }

    @AfterMethod
    public void tearDown(){
        Driver.getInstance().tearDownDriver();
    }

    @Test(dataProvider = "getData", description = "To check whether the user can add cheapest chocolate to the cart and verify the total cost")
    public void verifyTotalCartPriceInCheckoutPageTest(TestData testData) {

        Double priceOfOneItem = new SearchFacade().searchItem(testData.getItemName())
                .addProductWithMentionedQtyToCart(testData.getQuantity())
                .getPriceOfOneItem();

        Double totalCartValue = new CheckoutFacade().getTotalCartValue();

        Assertions.assertThat(totalCartValue)
                        .isPositive()
                        .isEqualTo(priceOfOneItem * testData.getQuantity());
    }

    @DataProvider
    public Object[][] getData(){
        return new Object[][]{
                {TestData.builder().setItemName("Ferroro Rocher").setQuantity(2).build()}
        };
    }


}
