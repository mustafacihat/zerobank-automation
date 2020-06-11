package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    public LoginPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "input#user_login")
    public WebElement usernameBox;

    @FindBy(css = "input#user_password")
    public WebElement passwordBox;

    @FindBy(css="div.alert.alert-error")
    public WebElement errorMessage;

    @FindBy(xpath = "(//a[@class='dropdown-toggle'])[2]")
    public WebElement usernameButton;

    @FindBy(css = "#logout_link")
    public WebElement logoutButton;

    @FindBy(css = "button#signin_button")
    public WebElement signinButton;

    public void login(String username, String password) {
        usernameBox.sendKeys(username);
        passwordBox.sendKeys(password + Keys.ENTER);
    }

    public void logout(){
        usernameButton.click();
        //WebDriverWait wait = new WebDriverWait(Driver.get(),10);
        //wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
        logoutButton.click();
        signinButton.click();
    }


}
