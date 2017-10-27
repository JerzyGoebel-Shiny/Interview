package com.mysite.selenium;

import org.junit.Assert;
import org.junit.Test;

public class LoginTest extends FunctionalTest {

    @Test
    public void canLoginSuccessfully() {
        LogInPage logInPage = new LogInPage(driver);

        logInPage.navigateToWebpage();

        logInPage.typeUsername("admin");
        logInPage.typePassword("waction");
        logInPage.logIn();

        HomePage homePage = new HomePage(driver);

        Assert.assertEquals("Home",homePage.topTabName());
    }

    @Test
    public void failsOnInvalidCredentials() {
        LogInPage logInPage = new LogInPage(driver);

        logInPage.navigateToWebpage();

        logInPage.typeUsername("user");
        logInPage.typePassword("password");
        logInPage.logInExpectFailure();


        Assert.assertNotNull(logInPage.errorMessage());

    }

    @Test
    public void failsOnEmptyCredentials() {
        LogInPage logInPage = new LogInPage(driver);

        logInPage.navigateToWebpage();

        logInPage.logInExpectFailure();

        Assert.assertEquals("Please make sure you have filled out all the fields.", logInPage.errorMessage());
    }
}