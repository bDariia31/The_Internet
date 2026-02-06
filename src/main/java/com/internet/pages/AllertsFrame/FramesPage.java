package com.internet.pages.AllertsFrame;

import com.internet.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FramesPage extends BasePage
{

    public FramesPage(WebDriver driver) {
        super(driver);
    }

    public FramesPage clickOnNestedFrames() {
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        return this;
    }




}
