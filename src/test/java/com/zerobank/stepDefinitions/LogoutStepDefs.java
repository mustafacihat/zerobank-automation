package com.zerobank.stepDefinitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class LogoutStepDefs {

    @Then("the user should be able to logout succesfully")
    public void the_user_should_be_able_to_logout_succesfully() {
        new LoginPage().logout();

        String actualUrl = Driver.get().getCurrentUrl();
        String expectedUrl = "http://zero.webappsecurity.com/login.html";

        Assert.assertEquals("verify url", expectedUrl,actualUrl);
    }
}

