package com.assignment.tests;

import com.assignment.config.FrameworkConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AddToCartTests {

    @Test(description = "To check whether the user can add cheapest chocolate to the cart")
    public void addToCartTest() {
        FrameworkConfig frameworkConfig = ConfigFactory.create(FrameworkConfig.class);
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get(frameworkConfig.url());
    }
}
