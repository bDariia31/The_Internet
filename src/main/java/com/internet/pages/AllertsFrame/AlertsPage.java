package com.internet.pages.AllertsFrame;

import com.internet.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertsPage extends BasePage {
    public AlertsPage(WebDriver driver) {
        super(driver);
    }
@FindBy(css="button[onclick='jsAlert()']")
    WebElement JsAlert;

    public AlertsPage verifyAlertWithJsAlert()
    {
        clickWithJs(JsAlert,0,300);
        driver.switchTo().alert().accept();// система нажимает в alert "ok"
        return this;

    }

    @FindBy(css="button[onclick='jsConfirm()']")
    WebElement alertConfirm;

    public AlertsPage clickOnResult(String result)
    {
        click(alertConfirm);
        if(result!=null && result.equals("Ok"))
        {
            driver.switchTo().alert().accept();
        } else if (result!=null && result.equals("Cancel")) {
            driver.switchTo().alert().dismiss();
        }
        return this;
    }


    @FindBy(xpath="//p[@id='result']")
    WebElement confirmResult;
    public AlertsPage verifyAlertConfirm(String text)
    {

        Assertions.assertTrue(isContainsText(text, confirmResult));
        return this;

    }

    private boolean isContainsText(String text, WebElement element) {
        return element.getText().contains(text);
    }


    @FindBy(css="button[onclick='jsPrompt()']")
    WebElement promtButton;
    public AlertsPage clickOnPromtButton()
    {
        click(promtButton);
        return this;
    }


    public AlertsPage sendMessageToAllert(String message) {
        if(message!=null)
        {
            driver.switchTo().alert().sendKeys(message);
            driver.switchTo().alert().accept();
        }
        return this;
    }
    @FindBy(xpath = "//p[@id='result']")
    WebElement promptResult;

    public AlertsPage verifyMessage(String text) {
        Assertions.assertTrue(isContainsText(text,promptResult));
        return this;
    }
}
