package com.assignment.tests;

import com.assignment.facade.CheckoutFacade;
import com.assignment.facade.SearchFacade;
import com.assignment.testdata.TestData;
import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CheckoutPageTests extends BaseTest{
    
    //Adding a secret to verify whether the secret-scan github action is finding it or not
    String awsAccessKey = "skdfbskfbskjfbsfsj1234==";
    String password = "abcd1234";

    @Test(dataProvider = "getData", description = "To check whether the user can add cheapest chocolate to the cart and verify the total cost")
    public void verifyTotalCartPriceInCheckoutPageTest(TestData testData) {

        Double priceOfOneItem = new SearchFacade()
                .searchItem(testData.getItemName())
                .addProductWithMentionedQtyToCart(testData.getQuantity())
                .getPriceOfOneItem();

        Double totalCartValue = new CheckoutFacade().getTotalCartValue();

        Assertions.assertThat(totalCartValue)
                .isPositive()
                .withFailMessage(()->"Total Cart price is not displayed correctly in checkout page")
                .isEqualTo(priceOfOneItem * testData.getQuantity());
    }

    @Test(dataProvider = "getData", description = "To check whether the user was forced to login if he naivagates to checkout page without login")
    public void verifyUserNavigatingToLoginPageOnCheckout(TestData testData) {

        new SearchFacade().searchItem(testData.getItemName())
                .addProductWithMentionedQtyToCart(testData.getQuantity());

        String pageTitle = new CheckoutFacade().clickProceedToBuyAndReturnTitle();

        Assertions.assertThat(pageTitle)
                .isNotNull()
                .isNotBlank()
                .withFailMessage(()->"Login Page is not displayed on checking out a item without login")
                .isEqualTo(testData.getTitleToVerify());
    }

    @DataProvider(parallel = true)
    public Object[][] getData(){
        return new Object[][]{
                {
                        TestData.builder()
                                .setItemName("Ferroro Rocher")
                                .setTitleToVerify("Amazon Sign In")
                                .setQuantity(4)
                                .build()
                }
        };
    }


}
