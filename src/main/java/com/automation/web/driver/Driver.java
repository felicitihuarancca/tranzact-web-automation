package com.automation.web.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

    private WebDriver driver;

    public Driver (String browser) {
        switch (browser) {
            case "chrome" :
                System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver96.exe");
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "./src/main/resources/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            default:
                break;
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
