package com.assignment.tests;

import com.assignment.config.FrameworkConfig;
import com.assignment.driver.Driver;
import com.assignment.driver.DriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddToCartTests {

    @BeforeMethod
    public void setUp(){
        Driver.getInstance().setUpDriver();
    }

    @AfterMethod
    public void tearDown(){
        Driver.getInstance().tearDownDriver();
    }

    @Test(description = "To check whether the user can add cheapest chocolate to the cart")
    public void addToCartTest() {
        FrameworkConfig frameworkConfig = ConfigFactory.create(FrameworkConfig.class);
        DriverManager.getDriver().get(frameworkConfig.url());
    }
}
