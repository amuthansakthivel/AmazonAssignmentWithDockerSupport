package com.assignment.tests;

import com.assignment.driver.Driver;
import com.assignment.facade.SearchFacade;
import lombok.SneakyThrows;
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
    @Test(description = "To check whether the user can add cheapest chocolate to the cart")
    public void addToCartTest() {
        new SearchFacade().searchItem("Ferroro Rocher");
        Thread.sleep(5000);
    }
}
