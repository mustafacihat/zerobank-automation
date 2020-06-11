package com.zerobank.stepDefinitions;

import com.zerobank.pages.NewPayeePage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.Map;

public class NewPayeeStepDefs {

    @Given("Add New Payee tab")
    public void add_New_Payee_tab() {
        new NewPayeePage().addNewPayeeButton.click();
        BrowserUtils.waitFor(2);
    }

    @Given("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String, String> payeeTable) {
        NewPayeePage newPayeePage = new NewPayeePage();
        newPayeePage.payeeName.sendKeys(payeeTable.get("Payee Name"));
        newPayeePage.payeeAddress.sendKeys(payeeTable.get("Payee Address"));
        newPayeePage.payeeAccount.sendKeys(payeeTable.get("Account"));
        newPayeePage.payeeDetails.sendKeys(payeeTable.get("Payee details"));
        newPayeePage.addButton.click();
        BrowserUtils.waitFor(2);
    }

    @Then("message The new payee The Law Offices of Hyde, Price & Scharks was successfully created. should be displayed")
    public void message_The_new_payee_The_Law_Offices_of_Hyde_Price_Scharks_was_successfully_created_should_be_displayed() {
        Assert.assertTrue("verify the message", new NewPayeePage().messagePayee.isDisplayed());

    }
}
