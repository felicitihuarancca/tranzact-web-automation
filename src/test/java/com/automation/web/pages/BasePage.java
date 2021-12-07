package com.automation.web.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {

    private WebDriver driver;
    private WebDriverWait wait;
    public Logger log = Logger.getLogger(BasePage.class);

    /**
     * Constructor.
     * @param pDriver WebDriver
     */
    public BasePage (WebDriver pDriver) {
        PageFactory.initElements(pDriver, this);
        wait = new WebDriverWait(pDriver, 20);
        driver = pDriver;
    }

    /**
     * Get the web driver wait.
     * @return {@link WebDriverWait}
     */
    public WebDriverWait getWait() {
        return wait;
    }

    /**
     * Get the  web driver.
     * @return {@link WebDriver}
     */
    protected WebDriver getDriver() {
        return driver;
    }

    /**
     * Close the web driver.
     */
    public void dispose() {
        if (driver != null) {
            driver.quit();
        }
    }

    /**
     * Wait element to be visible.
     * @param element WebElement
     */
    public void waitElementVisibility(WebElement element) {
        getWait().until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Wait element to be visible.
     * @param elements list WebElement
     */
    public void waitElementsVisibility(List<WebElement> elements) {
        getWait().until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    /**
     * Wait element to be visible.
     * @param element WebElement
     */
    public void waitElementInvisibility(WebElement element) {
        getWait().until(ExpectedConditions.invisibilityOf(element));
    }

    /**
     * Get element text.
     * @param element WebElement
     * @return String
     */
    public String getElementText(WebElement element) {
        waitElementVisibility(element);
        return element.getText();
    }

    /**
     * Wait element and Set the values.
     * @param element WebElement
     * @param text	String text
     */
    public void sendElementText(WebElement element, String text) {
        waitElementVisibility(element);
        element.click();
        element.sendKeys(text);
    }

    /**
     * Clear text.
     * @param element WebElement
     */
    public void clearElementText(WebElement element) {
        waitElementVisibility(element);
        element.clear();
    }

    /**
     * Wait element auntil it is clickable.
     * @param element WebElement
     */
    public void waitElementClickable(WebElement element) {
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Wait and click the element.
     * @param element WebElement
     */
    public void clickElement(WebElement element){
        waitElementClickable(element);
        element.click();
    }

    /**
     * Refresh current page.
     */
    public void refreshPage() {
        getDriver().navigate().refresh();
    }

    /**
     * Get if element is present or not.
     * @param element WebElement
     * @return boolean
     */
    public boolean elementPresent(WebElement element) {
        return element.isDisplayed();
    }

    /**
     * Get if element is enabled or not.
     * @param element WebElement
     * @return boolen
     */
    public boolean elementEnabled(WebElement element) {
        return element.isEnabled();
    }

    /**
     * Select option by value.
     * @param element WebElement
     * @param option String
     */
    public void selectOptionByValue(WebElement element, String option) {
        Select myDropdown = new Select(element);
        myDropdown.selectByValue(option);
    }

    /**
     * Select option by text.
     * @param element WebElement
     * @param option String
     */
    public void selectOptionByText(WebElement element, String option) {
        Select myDropdown = new Select(element);
        myDropdown.selectByVisibleText(option);
    }
}
