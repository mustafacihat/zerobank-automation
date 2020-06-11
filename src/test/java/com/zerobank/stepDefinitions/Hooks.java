package com.zerobank.stepDefinitions;

import com.zerobank.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before
    public void setUp() {

    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenShot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenShot, "image/png", "screenshot");
        }

        Driver.closeDriver();
    }

    @Before("@db")
    public void setupDb() {


    }

    @After("@db")
    public void closeDb() {


    }
}