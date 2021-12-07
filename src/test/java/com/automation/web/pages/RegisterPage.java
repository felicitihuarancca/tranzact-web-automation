package com.automation.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

/**
 * Class for interact with the Register page.
 * @author feliciti.huarancca
 */
public class RegisterPage extends BasePage {

    @FindBy(id = "email_create")
    private WebElement emailTxt;

    @FindBy(id = "SubmitCreate")
    private WebElement createButton;

    @FindBy (id= "uniform-id_gender1")
    private WebElement maleRadio;

    @FindBy (id= "uniform-id_gender2")
    private WebElement femaleRadio;

    @FindBy (id= "customer_firstname")
    private WebElement firstnameTxt;

    @FindBy (id= "customer_lastname")
    private WebElement lastnameTxt;

    @FindBy (id= "passwd")
    private WebElement passwordTxt;

    @FindBy(id= "days")
    private WebElement daysCmb;

    @FindBy(id= "months")
    private WebElement monthsCmb;

    @FindBy(id= "years")
    private WebElement yearsCmb;

    @FindBy(id= "newsletter")
    private WebElement newsletterCheckBox;

    @FindBy(id= "optin")
    private WebElement optionCheckBox;

    @FindBy(id = "company")
    private WebElement companyTxt;

    @FindBy(id = "address1")
    private WebElement address1Txt;

    @FindBy(id = "address2")
    private WebElement address2Txt;

    @FindBy(id = "city")
    private WebElement cityTxt;

    @FindBy(id = "id_state")
    private WebElement stateCmb;

    @FindBy(id = "postcode")
    private WebElement postcodeTxt;

    @FindBy(id = "id_country")
    private WebElement countryCmb;

    @FindBy(id = "other")
    private WebElement otherTxt;

    @FindBy(id = "phone")
    private WebElement phoneTxt;

    @FindBy(id = "phone_mobile")
    private WebElement mobileTxt;

    @FindBy(id = "alias")
    private WebElement aliasTxt;

    @FindBy(id = "submitAccount")
    private WebElement submitButton;

    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */
    public RegisterPage(WebDriver pDriver) {
        super(pDriver);
    }

    /**
     * Create account with email value and Click the button.
     * @param email String
     */
    public void createAccount(String email) {
        sendElementText(emailTxt,email);
        clickElement(createButton);
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    /**
     * Fill personal information.
     * @param title String
     * @param firstname String
     * @param lastname String
     * @param password String
     * @param day String
     * @param month String
     * @param year String
     */
    public void fillPersonalInfo(String title, String firstname, String lastname, String password, String day, String month, String year) {
        if (title.equals("Mr")) {
            clickElement(maleRadio);
        } else {
            clickElement(femaleRadio);
        }

        sendElementText(firstnameTxt, firstname);
        sendElementText(lastnameTxt, lastname);
        sendElementText(passwordTxt, password);
        selectOptionByValue(daysCmb, day);
        selectOptionByValue(monthsCmb, month);
        selectOptionByValue(yearsCmb, year);
    }

    /**
     * Fill Adrress information.
     * @param company String
     * @param address_1 String
     * @param address_2 String
     * @param city String
     * @param state String
     * @param zipcode String
     * @param country String
     * @param additional String
     * @param mobile String
     * @param alias String
     */
    public void fillYourAddress(String company, String address_1, String address_2, String city, String state, String zipcode, String country, String additional, String mobile, String alias) {
        sendElementText(companyTxt, company);
        sendElementText(address1Txt, address_1);
        sendElementText(address2Txt, address_2);
        sendElementText(cityTxt, city);
        selectOptionByText(stateCmb, state);
        sendElementText(postcodeTxt, zipcode);
        selectOptionByText(countryCmb, country);
        sendElementText(otherTxt, additional);
        sendElementText(mobileTxt, mobile);
        sendElementText(aliasTxt, alias);
    }

    /**
     * Get Account page.
     * @return {@link AccountPage}
     */
    public AccountPage getAccountPage() {
        clickElement(submitButton);
        return new AccountPage(getDriver());
    }
}
