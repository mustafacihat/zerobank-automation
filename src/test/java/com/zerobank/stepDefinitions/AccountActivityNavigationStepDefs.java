package com.zerobank.stepDefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AccountActivityNavigationStepDefs {




    @When("the user clicks on {string} link on the Account Summary page")
    public void the_user_clicks_on_link_on_the_Account_Summary_page(String link) {
        new AccountSummaryPage().clickLinks(link);
    }


    @Then("the Account Activity page should be displayed")
    public void the_Account_Activity_page_should_be_displayed() {
        String actualTitle = Driver.get().getTitle();
        String expectedTitle = "Zero - Account Activity";
        Assert.assertEquals("verify the page", expectedTitle,actualTitle);
    }

    @Then("Account drop down should have Brokerage selected")
    public void account_drop_down_should_have_Brokerage_selected() {
        String actualOption = new AccountActivityPage().defaultOption().getText();
        String expectedOption = "Brokerage";
        Assert.assertEquals("verify the default option", expectedOption, actualOption);
    }



    @Then("Account drop down should have Checking selected")
    public void account_drop_down_should_have_Checking_selected() {
        String actualOption = new AccountActivityPage().defaultOption().getText();
        String expectedOption = "Checking";
        Assert.assertEquals("verify the default option", expectedOption, actualOption);
    }



    @Then("Account drop down should have Credit Card selected")
    public void account_drop_down_should_have_Credit_Card_selected() {
        String actualOption = new AccountActivityPage().defaultOption().getText();
        String expectedOption = "Credit Card";
        Assert.assertEquals("verify the default option", expectedOption, actualOption);
    }


    @Then("Account drop down should have Loan selected")
    public void account_drop_down_should_have_Loan_selected() {
        String actualOption = new AccountActivityPage().defaultOption().getText();
        String expectedOption = "Loan";
        Assert.assertEquals("verify the default option", expectedOption, actualOption);
    }



}


