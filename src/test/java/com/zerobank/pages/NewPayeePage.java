package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewPayeePage extends BasePage {

    @FindBy(xpath = "//a[.='Add New Payee']")
    public WebElement addNewPayeeButton;

    @FindBy(id = "np_new_payee_name")
    public WebElement payeeName;

    @FindBy(id = "np_new_payee_address")
    public WebElement payeeAddress;

    @FindBy(id = "np_new_payee_account")
    public WebElement payeeAccount;

    @FindBy(id = "np_new_payee_details")
    public WebElement payeeDetails;

    @FindBy(id = "add_new_payee")
    public WebElement addButton;

    @FindBy(id = "alert_content")
    public WebElement messagePayee;

    }


