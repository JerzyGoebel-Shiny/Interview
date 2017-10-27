package com.mysite.selenium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LoginTest extends FunctionalTest {

    LogInPage logInPage;

    @Before
    public void initiateLoginPage(){
        logInPage = new LogInPage(driver);
        logInPage.navigateToWebpage();
    }

    @Test
    public void canLoginSuccessfully() {

        logInPage.typeUsername("admin");
        logInPage.typePassword("waction");
        logInPage.logIn();

        HomePage homePage = new HomePage(driver);

        Assert.assertTrue(homePage.isOpened());
    }

    @Test
    public void failsOnInvalidCredentials() {

        logInPage.typeUsername("user");
        logInPage.typePassword("password");
        logInPage.logInExpectFailure();


        Assert.assertNotNull(logInPage.errorMessage());

    }

    @Test
    public void failsOnEmptyCredentials() {

        logInPage.logInExpectFailure();

        Assert.assertEquals("Please make sure you have filled out all the fields.", logInPage.errorMessage());
    }
}