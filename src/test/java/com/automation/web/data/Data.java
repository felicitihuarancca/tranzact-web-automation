package com.automation.web.data;

import org.testng.annotations.DataProvider;

public class Data {

    @DataProvider(name = "registerdata")
    public Object[][] loginData() {
        return new Object[][] {{
            new User()
        }};
    }
}
