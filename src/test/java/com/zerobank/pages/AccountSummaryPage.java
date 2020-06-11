package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AccountSummaryPage extends BasePage {


   /* @FindBy(xpath = "//h2")
    public WebElement accountTypes;*/

    /*@FindBy(xpath = "(//table/thead)[3]//th")
    public WebElement creditAccountsColumns;*/

    @FindBy(xpath = "(//a[.='Savings'])[1]")
    public WebElement savings;

    public void clickLinks(String tab) {
        Driver.get().findElement(By.xpath("//a[.='" + tab + "']")).click();
    }

    public Boolean compareAccountTypes() {
        List<String> actualList = BrowserUtils.getElementsText(Driver.get().findElements(By.xpath("//h2")));
        System.out.println(actualList);
        List<String> expectedList = new ArrayList<>(Arrays.asList("Cash Accounts", "Investment Accounts", "Credit Accounts", "Loan Accounts"));
        System.out.println(expectedList);
        return expectedList.equals(actualList);
    }

    public List<String> creditAccountsColumns() {

        List<WebElement> elements = Driver.get().findElements(By.xpath("(//table/thead)[3]//th"));
        List<String> columns = new ArrayList<>();
        for (WebElement element : elements) {
            columns.add(element.getText());
        }

        return columns;
    }


}
