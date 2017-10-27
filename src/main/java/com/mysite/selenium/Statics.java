package com.mysite.selenium;

import org.openqa.selenium.By;

public class Statics {
    public static final By CSS_BOX_USER = By.ByCssSelector.cssSelector("input[name=\"username\"]");
    public static final By CSS_BOX_PASS = By.ByCssSelector.cssSelector("input[name=\"password\"]");
    public static final By CSS_LOG_BUTN = By.ByCssSelector.cssSelector("button[type=\"submit\"]");
    public static final By CSS_MSG_ERR  = By.ByCssSelector.cssSelector(".message.error");
    public static final By TAB_HOOK     = By.id("view-title-text");

}
