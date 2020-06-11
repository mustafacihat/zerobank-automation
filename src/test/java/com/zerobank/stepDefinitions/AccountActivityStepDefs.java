package com.zerobank.stepDefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AccountActivityStepDefs {

    @Given("the user should be in Account Activity Page")
    public void the_user_should_be_in_Account_Activity_Page() {
        new AccountActivityPage().accountActivityTab.click();
    }

    @Then("the default option should be Savings")
    public void the_default_option_should_be_Savings() {
        String actualOption = new AccountActivityPage().defaultOption().getText();
        String expectedOption = "Savings";
        Assert.assertEquals("verify the default option", expectedOption, actualOption);
    }

    @Then("the options should be Savings, Checking, Loan, Credit Card, Brokerage")
    public void the_options_should_be_Savings_Checking_Loan_Credit_Card_Brokerage() {
        List<String> actualOptions = new AccountActivityPage().accountDropDown();
        List<String> expectedOptions = new ArrayList<>(Arrays.asList("Savings", "Checking", "Loan", "Credit Card", "Brokerage"));
        System.out.println("actualOptions = " + actualOptions);
        System.out.println("expectedOptions = " + expectedOptions);
        Assert.assertEquals("verify the options", expectedOptions, actualOptions);
    }

    @Then("Transactions table should have Date, Description, Deposit, Withdrawal")
    public void transactions_table_should_have_Date_Description_Deposit_Withdrawal() {
        List<String> actualColumns = new AccountActivityPage().creditAccountsColumns();
        List<String> expectedColumns = new ArrayList<>(Arrays.asList("Date", "Description", "Deposit", "Withdrawal"));
        System.out.println(actualColumns);
        System.out.println(expectedColumns);
        Assert.assertEquals("verify the columns", expectedColumns, actualColumns);
    }


}
