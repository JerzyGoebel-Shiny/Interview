package com.mysite.selenium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StriimTest {
    private static ChromeDriver driver;

    @Before
    public void Setup(){
        System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test
    public void StriimLoginTest(){
        driver.get("localhost:9080");
        WebDriverWait _timeout = new WebDriverWait(driver,10);

        WebElement userBox = _timeout.until(ExpectedConditions.elementToBeClickable(Striim.CSS_BOX_USER));
        userBox.sendKeys("admin");

        WebElement passBox = _timeout.until(ExpectedConditions.elementToBeClickable(Striim.CSS_BOX_PASS));
        passBox.sendKeys("waction");

        WebElement cnctBtn = _timeout.until(ExpectedConditions.elementToBeClickable(Striim.CSS_LOG_BUTN));
        cnctBtn.click();

        WebElement hookTab = _timeout.until(ExpectedConditions.elementToBeClickable(Striim.TAB_HOOK));
        Assert.assertEquals(Striim.EXP_TAB, driver.getTitle());

        driver.quit();

    }
}
