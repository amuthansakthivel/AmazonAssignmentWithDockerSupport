package com.assignment.pages.pagecomponents;


import org.openqa.selenium.By;

import static com.assignment.utils.SeleniumActions.waitAndClick;
import static com.assignment.utils.SeleniumActions.waitAndEnterText;

public final class TopMenuComponent {

    private final By txtboxSearch = By.id("twotabsearchtextbox");
    private final By btnSearch = By.id("nav-search-submit-button");

    public TopMenuComponent setTextInSearch(String item){
        waitAndEnterText(txtboxSearch,item,"Text Box Search");
        return this;
    }

    public void clickSearch(){
        waitAndClick(btnSearch,"Search");
    }

}
