package com.internet.tests;

import com.internet.core.TestBase;
import com.internet.pages.AllertsFrame.AlertsPage;
import com.internet.pages.AllertsFrame.MultipleWindows;
import com.internet.pages.HomePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AlertsFrameJavaScriptTest extends TestBase {
    HomePage homePage;
    AlertsPage alerts;
    MultipleWindows multipleWindows;

    @BeforeEach
    public void preconditions() {
        homePage = new HomePage(driver);
        alerts = new AlertsPage(driver);
        multipleWindows=new MultipleWindows(driver);

    }


    @Test
    public void clickForJSAlert() {
        homePage.getJavaScriptAlerts();
        alerts.verifyAlertWithJsAlert();

    }

    @Test
    public void clickForJsConfirm() {
        homePage.getJavaScriptAlerts();
        alerts.clickOnResult("Cancel").verifyAlertConfirm("Cancel");

    }


    @Test
    public void clickForJsPrompt()//sendMessageToAlert
    {
        homePage.getJavaScriptAlerts();
        alerts.clickOnPromtButton().sendMessageToAllert("Hello word").verifyMessage("Hello word");

    }

    @Test
    public void newTabTest() {
     homePage.getMultipleWindows();
        multipleWindows.clickHere().switchToNewTab(1).verifyClickHierTitle("New Window");


    }


}
