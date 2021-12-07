package com.automation.web.tests;

import com.automation.web.data.Data;
import com.automation.web.data.User;
import com.automation.web.pages.AccountPage;
import com.automation.web.pages.HomePage;
import com.automation.web.pages.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestSuite extends BaseTest{

    @AfterMethod
    @Parameters({"url"})
    public void launchHomePage(String url) {
        driver.getDriver().get(url);
    }

    @Test(description = "Register a user", dataProviderClass = Data.class, dataProvider = "registerdata")
    public void testCaseRegistrar(User user) {
        HomePage homePage = getHomePage();
        log.info("Click Sign in button");
        RegisterPage registerPage = homePage.register();
        log.info("Fill email address and click create button");
        registerPage.createAccount(user.getEmail());
        log.info("Fill personal information with correct data");
        log.info("Birth: "+ user.getDay_birth() + " " + user.getMonth_birth() + " " + user.getYear_birth()); //TODO delete
        registerPage.fillPersonalInfo(user.getTitle(), user.getFirstname(), user.getLastname(), user.getPassword(), user.getDay_birth(), user.getMonth_birth(), user.getYear_birth());
        log.info("Fill your address with correct data");
        registerPage.fillYourAddress(user.getCompany(), user.getAddress_1(), user.getAddress_2(), user.getCity(), user.getState(), user.getZipcode(), user.getCountry(), user.getAdditional(), user.getMobile(), user.getAlias());
        log.info("Click register button");
        AccountPage accountPage = registerPage.getAccountPage();
        accountPage.getWait();
        String strUrl = driver.getCurrentUrl();
        log.info("Assertions");
        Assert.assertEquals(strUrl, "http://automationpractice.com/index.php?controller=my-account", "THE ACOUNT PAGE IS NOT OPENED");
        Assert.assertEquals(accountPage.getAccountNameText(), user.getFirstname() + " " +user.getLastname(), "THE ACCOUNT NAME WAS NOT AS EXPECTED");
        Assert.assertTrue(accountPage.isLogoutLnkPresent(), "LOGOUT LINK IS NOT PRESENT");
        Assert.assertTrue(accountPage.isLogoutLnkEnabled(), "LOGOUT LINK IS NOT ENABLED");
    }
}
