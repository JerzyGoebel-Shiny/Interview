package com.mysite.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogInPage extends PageObject{

    WebDriverWait _timeout = new WebDriverWait(driver, 10);



    private WebElement username   = _timeout.until(ExpectedConditions.elementToBeClickable(driver.findElement(Statics.CSS_BOX_USER)));
    private WebElement password   = _timeout.until(ExpectedConditions.elementToBeClickable(driver.findElement(Statics.CSS_BOX_PASS)));
    private WebElement logButton  = _timeout.until(ExpectedConditions.elementToBeClickable(driver.findElement(Statics.CSS_LOG_BUTN)));


    public LogInPage(WebDriver driver){
        super(driver);
    }

    public void typeUsername(String phrase){
        this.username.clear();
        this.username.sendKeys(phrase);
    }

    public void typePassword(String phrase){
        this.password.clear();
        this.password.sendKeys(phrase);
    }


    public HomePage logIn(){
        logButton.click();
        return new HomePage(driver);
    }

    public void logInExpectFailure(){
        logButton.click();
    }


    public String errorMessage(){
        WebElement errorBox   = _timeout.until(ExpectedConditions.elementToBeClickable(driver.findElement(Statics.CSS_MSG_ERR)));
        return errorBox.getText();
    }
}
