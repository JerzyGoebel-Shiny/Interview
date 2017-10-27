package com.mysite.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends PageObject{

    private WebDriverWait _timeout = new WebDriverWait(driver,10);

    private WebElement topTab = _timeout.until(ExpectedConditions.elementToBeClickable(driver.findElement(Statics.TAB_HOOK)));

    public HomePage(WebDriver driver){
        super(driver);
    }

    public String topTabName(){
        return topTab.getText();
    }

}
