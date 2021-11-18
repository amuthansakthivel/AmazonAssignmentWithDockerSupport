package com.assignment.pages;

import com.assignment.driver.DriverManager;
import com.assignment.utils.DynamicXpathUtils;
import com.assignment.utils.SeleniumActions;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public final class SearchResultsPage {

    private final String lnkTitle = "//h2/a";
    private final By labelPrice = By.xpath("//span[contains(@cel_widget_id,'MAIN-SEARCH_RESULTS')]//span[@class='a-price-whole']");
    private String lnkResultFromPrice = "//span[@class='a-price-whole' and text()='%s']/ancestor::span[contains(@cel_widget_id,'MAIN-SEARCH_RESULTS')]";

    @SneakyThrows
    public void chooseLowestPricedItem(){
        Thread.sleep(3000);
        DriverManager.getDriver().findElements(labelPrice)
                .stream()
                .limit(10)
                .map(WebElement::getText)
                .mapToInt(Integer::valueOf)
                .min()
                .ifPresent(this::clickCorrespondingLink);
    }

    private void clickCorrespondingLink(int price){
        String modifiedXpath = DynamicXpathUtils.getModifiedXpath(lnkResultFromPrice, String.valueOf(price));
        SeleniumActions.waitAndClick(By.xpath(modifiedXpath+lnkTitle),"Lowest priced item");
    }
}
