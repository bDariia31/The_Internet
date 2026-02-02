package com.theInternet.pages;

import com.theInternet.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage
{

    public HomePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//h1[@class='heading']")
    WebElement header;


}
