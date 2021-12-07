package com.automation.web.data;

import com.automation.web.data.util.State;
import com.automation.web.data.util.Title;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;
import java.util.UUID;

@Getter
@Setter
public class User {

    private String title;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String day_birth;
    private String month_birth;
    private String year_birth;
    private String company;
    private String address_1;
    private String address_2;
    private String city;
    private String state;
    private String zipcode;
    private String country;
    private String additional;
    private String phone;
    private String mobile;
    private String alias;

    Random random = new Random();
    UUID uniqueKey = UUID.randomUUID();

    public User() {
        this.title = Title.getRandom().name();
        this.firstname = "firstname test";
        this.lastname = "lastname test";
        this.email = "email-"+uniqueKey+"@gmail.com";
        this.password = RandomStringUtils.randomAlphabetic(10);
        this.day_birth = getRandomNumberInRange(1,30);
        this.month_birth = getRandomNumberInRange(1,12);
        this.year_birth = getRandomNumberInRange(2000,2021);
        this.company = "company-"+uniqueKey;
        this.address_1 = "Street Mancora, Lima";
        this.address_2 = "";
        this.city = "city-"+uniqueKey;
        this.state = State.getRandom().name();
        this.zipcode = "00000";
        this.country = "United States";
        this.additional = "additional"+uniqueKey;
        this.phone = phone;
        this.mobile = "123123123";
        this.alias = "alias";
    }

    public String  getRandomNumberInRange(int min, int max) {
        int randomNumber = random.nextInt((max - min) + 1) + min;
        return String.valueOf(randomNumber);
    }
}
