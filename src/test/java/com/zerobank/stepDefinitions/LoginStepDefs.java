package com.zerobank.stepDefinitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.concurrent.TimeUnit;

public class LoginStepDefs {

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        Driver.get().manage().window().maximize();
        Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @When("the user log in with {string} {string}")
    public void the_user_log_in_with(String username, String password) {
        new LoginPage().login(username, password);
    }

    @Then("the user should be able to login")
    public void the_user_should_be_able_to_login() {
        String actualTitle = Driver.get().getCurrentUrl();
        String expectedTitle = "http://zero.webappsecurity.com/bank/account-summary.html";

        Assert.assertEquals("verify the user is in the accountsummary page ", expectedTitle, actualTitle);

    }

    @When("the user try to login {string} {string}")
    public void the_user_try_to_login(String username, String password) {
        new LoginPage().login(username, password);

    }

    @Then("the user should not be able to login")
    public void the_user_should_not_be_able_to_login() {
        Assert.assertTrue("verify the error message is displayed", new LoginPage().errorMessage.isDisplayed());

    }
}
