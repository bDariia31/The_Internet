package com.internet.pages;

import com.internet.core.BasePage;
import com.internet.pages.AllertsFrame.AlertsPage;
import com.internet.pages.AllertsFrame.MultipleWindows;
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

   @FindBy(css="a[href=\"/javascript_alerts\"]")
   WebElement javaScriptAllert;


    public AlertsPage getJavaScriptAlerts()
    {
        click(javaScriptAllert);
        return new AlertsPage(driver);
    }

    @FindBy(css="a[href='/windows']")
    static WebElement multipleWindows;


    public MultipleWindows getMultipleWindows() {
        click(multipleWindows);
        return new MultipleWindows(driver);
    }
}
