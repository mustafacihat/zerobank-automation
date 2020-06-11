package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AccountActivityPage extends BasePage {

    @FindBy(id = "aa_accountId")
    public WebElement account;

    @FindBy(xpath = "//a[.='Find Transactions']")
    public WebElement findTransactions;

    @FindBy(id = "aa_description")
    public WebElement description;

    @FindBy(id = "aa_fromDate")
    public WebElement fromDate;

    @FindBy(id = "aa_toDate")
    public WebElement toDate;

    @FindBy(id = "aa_fromAmount")
    public WebElement fromAmount;

    @FindBy(id = "aa_toAmount")
    public WebElement toAmount;

    @FindBy(id = "aa_type")
    public WebElement typeDropDown;

    @FindBy(css = ".btn.btn-primary")
    public WebElement findButton;

    @FindBy(xpath = "(//table)[2]//tbody/tr/td[1]")
    public List<WebElement> tableDates;

    @FindBy(xpath = "(//table)[2]/tbody//td")
    public List<WebElement> tableElements;

    @FindBy(xpath = "(//table)[2]//tbody/tr/td[2]")
    public List<WebElement> tableDescriptions;

    @FindBy(css = "#filtered_transactions_for_account")
    public WebElement noResultMessage;

    @FindBy(xpath = "(//table)[2]/tbody//tr/td[3]")
    public List<WebElement> tableDeposits;

    @FindBy(xpath = "(//table)[2]/tbody//tr/td[4]")
    public List<WebElement> tableWithdrawal;



    public WebElement defaultOption() {
        Select select = new Select(account);
        return select.getFirstSelectedOption();
    }

    public List<String> accountDropDown() {
        Select select = new Select(account);
        List<WebElement> options = select.getOptions();
        List<String> allOptions = new ArrayList<>();
        for (WebElement option : options) {
            allOptions.add(option.getText());
        }
        System.out.println(allOptions);
        return allOptions;
    }

    public List<String> creditAccountsColumns() {

        List<WebElement> elements = Driver.get().findElements(By.xpath("//table/thead//th"));
        List<String> columns = new ArrayList<>();
        for (WebElement element : elements) {
            columns.add(element.getText());
        }

        return columns;
    }

    public List<Integer> getDaysInteger() {
        List<Integer> dayList = new ArrayList<>();
        for (WebElement tableDate : tableDates) {
            String date = tableDate.getText();
            String[] split = date.split("-");
            dayList.add(Integer.parseInt(split[2]));
        }

        return dayList;


    }

    public int getToDay(String to) {

        String[] split = to.split("-");

        int toDay = Integer.parseInt(split[2]);

        return toDay;


    }

    public int getFromDay(String from) {

        String[] split = from.split("-");

        int fromDay = Integer.parseInt(split[2]);

        return fromDay;


    }

    public Select selectType(){
        Select select = new Select(typeDropDown);
        return select;
    }


}




