package com.zerobank.stepDefinitions;

import com.zerobank.pages.NewPayeePage;
import com.zerobank.pages.PurchaseForeignCurrencyPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


import java.util.List;

public class PurchaseForeignCurrencyStepDefs {

    @Given("the user accesses the Purchase foreign currency cash tab")
    public void the_user_accesses_the_Purchase_foreign_currency_cash_tab() {
        new PurchaseForeignCurrencyPage().purchaseForeignCurButton.click();
        BrowserUtils.waitFor(2);
    }

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> currencyTable) {
        List<WebElement> currencyList = new PurchaseForeignCurrencyPage().getCurrencyList();
        List<String> currencyListAsText = BrowserUtils.getElementsText(currencyList);
        int n = 0;
        for (int i = 0; i < currencyTable.size(); i++) {
            for (int j = 0; j < currencyListAsText.size(); j++) {
                if (currencyTable.get(i).equals(currencyListAsText.get(j))) {
                    n++;
                    break;
                }
            }
        }
        System.out.println("currencyTable = " + currencyTable);
        System.out.println("currencyListAsText = " + currencyListAsText);
        System.out.println("currencyTable.size() = " + currencyTable.size());
        System.out.println("n = " + n);
        Assert.assertTrue("verify currencies avaliable", currencyTable.size() == n);
    }

    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {
        PurchaseForeignCurrencyPage purchaseForeignCurrencyPage = new PurchaseForeignCurrencyPage();
        purchaseForeignCurrencyPage.calculateCost.click();


    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        PurchaseForeignCurrencyPage purchaseForeignCurrencyPage = new PurchaseForeignCurrencyPage();
        System.out.println("purchaseForeignCurrencyPage.getAlertMessage() = " + purchaseForeignCurrencyPage.getAlertMessage());
        Assert.assertEquals("Please, ensure that you have filled all the required fields with valid values.",purchaseForeignCurrencyPage.getAlertMessage());
    }

    @When("user tries to calculate cost without entering a value")
    public void user_tries_to_calculate_cost_without_entering_a_value() {
        Select selectElement = new PurchaseForeignCurrencyPage().getSelectElement();
        selectElement.selectByIndex(7);
        new PurchaseForeignCurrencyPage().calculateCost.click();

    }
}
