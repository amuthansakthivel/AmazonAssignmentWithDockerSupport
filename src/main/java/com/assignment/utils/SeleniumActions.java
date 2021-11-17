package com.assignment.utils;

import com.assignment.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class SeleniumActions {

    private SeleniumActions(){}

    public void waitAndClick(By by,String elementname){
        waitForElementToBePresent(by).click();
        //TODO element name for logging
    }

    public void waitAndEnterText(By by,String value,String elementname){
        waitForElementToBePresent(by).sendKeys(value);
    }

    private WebElement waitForElementToBePresent(By by){
        return new WebDriverWait(DriverManager.getDriver(),10)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

}
