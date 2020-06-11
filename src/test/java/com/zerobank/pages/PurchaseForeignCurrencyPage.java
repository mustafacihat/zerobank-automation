package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PurchaseForeignCurrencyPage extends BasePage {

    @FindBy(xpath = "//a[.='Purchase Foreign Currency']")
    public WebElement purchaseForeignCurButton;

    @FindBy(id = "pc_calculate_costs")
    public WebElement calculateCost;

    @FindBy(id = "pc_currency")
    public WebElement currencyDropDown;

    public List<WebElement> getCurrencyList(){
        Select select = new Select(currencyDropDown);
        return select.getOptions();


    } public String getAlertMessage(){
        Alert alert = Driver.get().switchTo().alert();
        String alertMessage = alert.getText();
        return alertMessage;
    }

    public Select getSelectElement(){
        Select select = new Select(currencyDropDown);
        return select;
    }
}
