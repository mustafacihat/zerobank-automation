package com.zerobank.stepDefinitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;

public class PayBillsStepDefs {

    @Given("the user should be in Pay Bills Page")
    public void the_user_should_be_in_Pay_Bills_Page() {
        new PayBillsPage().payBillsTab.click();
    }

    @Then("the user should be able to complete pay operation succesfully with {string} {string} {string}")
    public void the_user_should_be_able_to_complete_pay_operation_succesfully_with(String amount, String date, String description) {
        PayBillsPage payBillsPage = new PayBillsPage();
        payBillsPage.amountBox.sendKeys(amount);
        payBillsPage.dateBox.sendKeys(date);
        payBillsPage.descriptionBox.sendKeys(description);
        payBillsPage.payButton.click();
        System.out.println("payBillsPage.payMessage.getText() = " + payBillsPage.payMessage.getText());
        Assert.assertTrue("verify the pay operation message is displayed", payBillsPage.payMessage.isDisplayed());
    }

    @Then("the user should receive an message {string} {string}")
    public void the_user_should_receive_an_message(String amount, String date) {
        PayBillsPage payBillsPage = new PayBillsPage();

        payBillsPage.amountBox.sendKeys(amount);
        payBillsPage.dateBox.sendKeys(date);
        payBillsPage.payButton.click();
        String actualMessage = "";
        if (amount.isEmpty()) {
            actualMessage = Driver.get().findElement(By.cssSelector("input[name='amount']")).getAttribute("validationMessage");
        } else if (date.isEmpty()) {
            actualMessage = Driver.get().findElement(By.cssSelector("input[name='date']")).getAttribute("validationMessage");
        }

        System.out.println("actualMessage = " + actualMessage);
        String expectedMessage = "Please fill out this field.";

        Assert.assertEquals("verify the recieved message", expectedMessage, actualMessage);

    }

    @Then("the system not allow to enter invalid characters {string} {string}")
    public void the_system_not_allow_to_enter_invalid_characters(String amount, String date) {
        PayBillsPage payBillsPage = new PayBillsPage();

        payBillsPage.amountBox.sendKeys(amount);
        payBillsPage.dateBox.sendKeys(date);
        payBillsPage.payButton.click();

        Assert.assertFalse("verify the pay operation message is displayed", payBillsPage.payMessage.isDisplayed());


    }

}
