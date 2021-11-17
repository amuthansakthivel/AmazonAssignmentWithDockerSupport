package com.assignment.pages.pagecomponents;

import com.assignment.utils.DynamicXpathUtils;
import org.openqa.selenium.By;

import static com.assignment.utils.SeleniumActions.waitAndClick;

public final class SortByComponent {



    private final By drpdwnSort = By.xpath("//span[text()='Sort by:']");
    private final String dropdwnOption = "//a[text()='%s']";
    private final String LOWTOHIGH = "Price: Low to High";


    private SortByComponent clickSort(){
        waitAndClick(drpdwnSort,"Sort");
        return this;
    }
    private void selectSortingOption(String sortingOption){
        System.out.println(sortingOption);
        String modifiedXpath = DynamicXpathUtils.getModifiedXpath(dropdwnOption, sortingOption);
        waitAndClick(By.xpath(modifiedXpath),"Sort");
    }
    public void sortResultsWithPriceLowToHigh(){
        clickSort().selectSortingOption(LOWTOHIGH);
    }

}
