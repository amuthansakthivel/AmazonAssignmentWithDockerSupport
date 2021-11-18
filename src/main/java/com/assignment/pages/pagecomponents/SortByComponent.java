package com.assignment.pages.pagecomponents;

import com.assignment.utils.DynamicXpathUtils;
import org.openqa.selenium.By;

import static com.assignment.utils.SeleniumActions.waitAndClick;

public final class SortByComponent {

    private final By drpdwnSort = By.xpath("//span[text()='Sort by:']");
    private static final String DROPDWN_OPTION = "//a[text()='%s']";
    private static final String LOW_TO_HIGH = "Price: Low to High";

    private SortByComponent clickSort(){
        waitAndClick(drpdwnSort,"Sort");
        return this;
    }
    private void selectSortingOption(String sortingOption){
        String modifiedXpath = DynamicXpathUtils.getModifiedXpath(DROPDWN_OPTION, sortingOption);
        waitAndClick(By.xpath(modifiedXpath),"Sort");
    }
    public void sortResultsWithPriceLowToHigh(){
        clickSort().selectSortingOption(LOW_TO_HIGH);
    }

}
