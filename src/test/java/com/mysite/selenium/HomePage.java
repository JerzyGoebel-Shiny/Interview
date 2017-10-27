package com.mysite.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends PageObject{

    private WebDriverWait _timeout = new WebDriverWait(driver,10);

    public boolean isOpened(){
        return _timeout.until(ExpectedConditions.elementToBeClickable(driver.findElement(Statics.TAB_HOOK))).isDisplayed();
    }

    public HomePage(WebDriver driver){
        super(driver);
    }


}
