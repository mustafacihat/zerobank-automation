package com.zerobank.stepDefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_old.Ac;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class FindTransactionsStepDefs {

    @Then("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() {
        new AccountActivityPage().findTransactions.click();
    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String fromDate, String toDate) {
        new AccountActivityPage().fromDate.clear();
        new AccountActivityPage().toDate.clear();
        new AccountActivityPage().fromDate.sendKeys(fromDate);
        new AccountActivityPage().toDate.sendKeys(toDate);
    }

    @When("clicks search")
    public void clicks_search() {
        new AccountActivityPage().findButton.click();
        BrowserUtils.waitFor(2);
    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String fromDate, String toDate) {

        AccountActivityPage accountActivityPage = new AccountActivityPage();

        List<Integer> daysInteger = accountActivityPage.getDaysInteger();
        int fromDay = accountActivityPage.getFromDay(fromDate);
        int toDay = accountActivityPage.getToDay(toDate);

        boolean flag = true;
        for (int i = 0; i < daysInteger.size(); i++) {
            if (!(daysInteger.get(i) >= fromDay && daysInteger.get(i) <= toDay)) {
                flag = false;
                break;
            }
        }
        Assert.assertTrue("verify the dates", flag);

    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {
        AccountActivityPage accountActivityPage = new AccountActivityPage();

        List<Integer> daysInteger = accountActivityPage.getDaysInteger();

        boolean flag = false;
        if (daysInteger.size() > 1) {
            if (daysInteger.get(0) >= daysInteger.get(daysInteger.size() - 1)) {
                flag = true;
            }

        } else if (daysInteger.size() == 0) {
            flag = true;
        }

        Assert.assertTrue("verify the sorted recent order", flag);

    }

    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String excludedDate) {
        List<String> tableDates = BrowserUtils.getElementsText(new AccountActivityPage().tableDates);
        boolean flag = true;
        for (String tableDate : tableDates) {
            if (tableDate.equals(excludedDate)) {
                flag = false;
            }
        }
        Assert.assertTrue("verify the excluded date", flag);
    }

    @When("the user enters description {string}")
    public void the_user_enters_description(String description) {
        new AccountActivityPage().description.clear();
        new AccountActivityPage().description.sendKeys(description);
    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String description) {

        List<WebElement> tableDescriptions = new AccountActivityPage().tableDescriptions;
        List<String> descriptionsInTable = BrowserUtils.getElementsText(tableDescriptions);

        boolean flag = true;
        for (String s : descriptionsInTable) {
            if (!s.contains(description)) {
                flag = false;
                break;
            }

        }
        if (descriptionsInTable.size() == 0) {
            flag = false;
        }
        Assert.assertTrue("verify " + description + " containing", flag);
    }

    @Then("results table should not show descriptions containing {string}")
    public void results_table_should_not_show_descriptions_containing(String description) {

        List<WebElement> tableDescriptions = new AccountActivityPage().tableDescriptions;
        List<String> descriptionsInTable = BrowserUtils.getElementsText(tableDescriptions);

        boolean flag = false;
        for (String s : descriptionsInTable) {
            if (s.contains(description)) {
                flag = true;
                break;
            }
        }
        System.out.println(flag);
        Assert.assertFalse("verify " + description + " not containing", flag);
    }


    @Then("results table should show at least one result under Deposit")
    public void results_table_should_show_at_least_one_result_under_Deposit() {


        List<WebElement> tableDeposits = new AccountActivityPage().tableDeposits;
        int n = 0;
        for (WebElement tableDeposit : tableDeposits) {
            if (!tableDeposit.getText().isEmpty()) {
                n++;
            }

        }
        System.out.println(n);
        Assert.assertTrue("verify the deposit result", n > 0);
    }

    @Then("results table should show at least one result under Withdrawal")
    public void results_table_should_show_at_least_one_result_under_Withdrawal() {
        List<WebElement> tableWithdrawals = new AccountActivityPage().tableWithdrawal;
        int n = 0;
        for (WebElement tableWithdrawal : tableWithdrawals) {
            if (!tableWithdrawal.getText().isEmpty()) {
                n++;
            }

        }
        System.out.println(n);
        Assert.assertTrue("verify the deposit result", n > 0);
    }

    @When("user selects type {string}")
    public void user_selects_type(String type) {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        Select selectType = accountActivityPage.selectType();
        selectType.selectByVisibleText(type);
        accountActivityPage.findButton.click();
        BrowserUtils.waitFor(5);
    }

    @Then("results table should show no result under Withdrawal")
    public void results_table_should_show_no_result_under_Withdrawal() {
        List<WebElement> tableWithdrawals = new AccountActivityPage().tableWithdrawal;
        int n = 0;
        System.out.println(BrowserUtils.getElementsText(tableWithdrawals));
        for (WebElement tableWithdrawal : tableWithdrawals) {
            if (!tableWithdrawal.getText().isEmpty()) {
                n++;
            }

        }
        System.out.println(n);
        Assert.assertTrue("verify no result under withdrawal", n == 0);
    }

    @Then("results table should show no result under Deposit")
    public void results_table_should_show_no_result_under_Deposit() {
        List<WebElement> tableDeposits = new AccountActivityPage().tableDeposits;
        int n = 0;
        System.out.println(BrowserUtils.getElementsText(tableDeposits));
        for (WebElement tableDeposit : tableDeposits) {
            if (!tableDeposit.getText().isEmpty()) {
                n++;
            }

        }
        System.out.println(n);
        Assert.assertTrue("verify no result under deposit", n == 0);
    }
}
