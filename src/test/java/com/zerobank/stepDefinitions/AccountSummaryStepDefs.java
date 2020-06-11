package com.zerobank.stepDefinitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AccountSummaryStepDefs {

    @Given("the user logged in homepage")
    public void the_user_logged_in_homepage() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        Driver.get().manage().window().maximize();
        Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        new LoginPage().login("username", "password");

    }

    @Then("the title should be {string}")
    public void the_title_should_be(String title) {

        String expectedTitle = title;
        String actualTitle = Driver.get().getTitle();

        Assert.assertEquals("verify the title", expectedTitle, actualTitle);
    }

    @Then("Account Summary Page has these account types")
    public void account_Summary_Page_has_these_account_types() {
        Assert.assertTrue("verify these account types" ,new AccountSummaryPage().compareAccountTypes());

    }

    @Then("Credit Accounts table should have Account, Credit Card and Balance")
    public void credit_Accounts_table_should_have_Account_Credit_Card_and_Balance() {
        List<String> actualColumns = new AccountSummaryPage().creditAccountsColumns();
        List<String> expectedColumns = new ArrayList<>(Arrays.asList("Account","Credit Card","Balance"));
        System.out.println(actualColumns);
        System.out.println(expectedColumns);
        Assert.assertEquals("verify the columns", expectedColumns,actualColumns);
    }


}
