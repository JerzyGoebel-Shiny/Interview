package com.mysite.selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTest extends FunctionalTest {

    @Test
    public void canLoginSuccessfully() {
        driver.get("localhost:9080");
        WebDriverWait _timeout = new WebDriverWait(driver, 10);

        WebElement userBox = _timeout.until(ExpectedConditions.elementToBeClickable(Striim.CSS_BOX_USER));
        userBox.sendKeys("admin");

        WebElement passBox = _timeout.until(ExpectedConditions.elementToBeClickable(Striim.CSS_BOX_PASS));
        passBox.sendKeys("waction");

        WebElement cnctBtn = _timeout.until(ExpectedConditions.elementToBeClickable(Striim.CSS_LOG_BUTN));
        cnctBtn.click();

        WebElement hookTab = _timeout.until(ExpectedConditions.elementToBeClickable(Striim.TAB_HOOK));
        Assert.assertEquals(Striim.EXP_TAB, driver.getTitle());
    }

    @Test
    public void failsOnInvalidCredentials() {
        driver.get("localhost:9080");
        WebDriverWait _timeout = new WebDriverWait(driver, 10);

        WebElement userBox = _timeout.until(ExpectedConditions.elementToBeClickable(Striim.CSS_BOX_USER));
        userBox.sendKeys("nimda");

        WebElement passBox = _timeout.until(ExpectedConditions.elementToBeClickable(Striim.CSS_BOX_PASS));
        passBox.sendKeys("111111");

        WebElement cnctBtn = _timeout.until(ExpectedConditions.elementToBeClickable(Striim.CSS_LOG_BUTN));
        cnctBtn.click();

        WebElement errorBox = _timeout.until(ExpectedConditions.elementToBeClickable(Striim.MSG_ERR));
        Assert.assertNotNull(errorBox);
    }

    @Test
    public void failsOnEmptyCredentials() {
        driver.get("localhost:9080");
        WebDriverWait _timeout = new WebDriverWait(driver, 10);

        WebElement cnctBtn = _timeout.until(ExpectedConditions.elementToBeClickable(Striim.CSS_LOG_BUTN));
        cnctBtn.click();

        WebElement errorBox = _timeout.until(ExpectedConditions.elementToBeClickable(Striim.MSG_ERR));
        Assert.assertEquals("Please make sure you have filled out all the fields.", errorBox.getText());
    }
}