package com.automation.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class for interact with the home page.
 * @author feliciti.huarancca
 */
public class HomePage extends BasePage {

    @FindBy(className = "login")
    private WebElement register;

    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */
    public HomePage(WebDriver pDriver, String url) {
        super(pDriver);
        pDriver.get(url);
    }


    /**
     * Get Register Page.
     * @return {@link RegisterPage}
     */
    public RegisterPage register() {
        clickElement(register);
        return new RegisterPage(getDriver());
    }
}
