package com.automation.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class for interact with the Account page.
 * @author feliciti.huarancca
 */

public class AccountPage extends BasePage{

    @FindBy(className = "account")
    private WebElement accountNameLnk;

    @FindBy(className = "logout")
    private WebElement logoutLnk;

    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */
    public AccountPage(WebDriver pDriver) {
        super(pDriver);
    }

    /**
     * Get Account name text.
     * @return String value
     */
    public String getAccountNameText() {
        return getElementText(accountNameLnk);
    }

    /**
     * Return if logout link is present or not.
     * @return boolean
     */
    public boolean isLogoutLnkPresent() {
        return elementPresent(logoutLnk);
    }

    /**
     * Return if logout link is enabled or not.
     * @return boolean
     */
    public boolean isLogoutLnkEnabled() {
        return elementEnabled(logoutLnk);
    }

}
