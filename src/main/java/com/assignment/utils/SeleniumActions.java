package com.assignment.utils;

import com.assignment.constants.FrameworkConstants;
import com.assignment.driver.DriverManager;
import com.assignment.reports.FrameworkLogger;
import com.assignment.reports.LogType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;
import java.util.function.Consumer;

public final class SeleniumActions {

    private SeleniumActions(){}

    public static void waitAndClick(By by,String elementname){
        waitForElementToBePresent(by).click();
        FrameworkLogger.log(LogType.PASS,elementname+ "is clicked successfully");
    }
    public static String getText(By by){
        return waitForElementToBePresent(by).getText();
    }

    public static void selectValueInDropDown(By by, Consumer<Select> consumer) {
        WebElement element = waitForElementToBePresent(by);
        Select select = new Select(element);
        consumer.accept(select);
    }

    public static void switchToNewlyOpenedWindow(){
        String parentWinHandle = DriverManager.getDriver().getWindowHandle();

        Set<String> winHandles = DriverManager.getDriver().getWindowHandles();
        for(String temp:winHandles) {
            if(!temp.equalsIgnoreCase(parentWinHandle)) {
                DriverManager.getDriver().switchTo().window(temp);
                FrameworkLogger.log(LogType.INFO, "Switched to new window successfully");
            }
        }

    }

    public static void waitAndEnterText(By by,String value,String elementname){
        waitForElementToBePresent(by).sendKeys(value);
        FrameworkLogger.log(LogType.PASS,String.format("%s is entered in %s successfully",value,elementname));
    }

    private static WebElement waitForElementToBePresent(By by){
        return new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getTimeout())
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

}
