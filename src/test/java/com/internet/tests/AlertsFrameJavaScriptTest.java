package com.internet.tests;

import com.internet.core.TestBase;
import com.internet.pages.AllertsFrame.AlertsPage;
import com.internet.pages.AllertsFrame.FramesPage;
import com.internet.pages.AllertsFrame.MultipleWindowsPage;
import com.internet.pages.HomePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class AlertsFrameJavaScriptTest extends TestBase {
    HomePage homePage;
    AlertsPage alerts;
    MultipleWindowsPage multipleWindowsPage;
    FramesPage framePage;

    @BeforeEach
    public void preconditions() {
        homePage = new HomePage(driver);
        alerts = new AlertsPage(driver);
        multipleWindowsPage =new MultipleWindowsPage(driver);
        framePage =new FramesPage(driver);

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
        multipleWindowsPage.clickHere().switchToNewTab(1).verifyClickHierTitle("New Window");

    }

    @Test
    public void clickFrameLeftTest()
    {
        homePage.getFrames();
        framePage.clickOnNestedFrames();
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        String text = driver.findElement(By.tagName("body")).getText();
        Assertions.assertEquals(text,"LEFT");
    }

    @Test
    public void clickFrameMiddle()
    {
        homePage.getFrames();
        framePage.clickOnNestedFrames();
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");
        String text = driver.findElement(By.tagName("body")).getText();
        Assertions.assertEquals(text,"MIDDLE");


    }

    @Test
    public void clickFrameRight()
    {
        homePage.getFrames();
        framePage.clickOnNestedFrames();
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-right");
        String text = driver.findElement(By.tagName("body")).getText();
        Assertions.assertEquals(text,"RIGHT");
    }

    @Test
    public void clickFrameBottom()
    {

        homePage.getFrames();
        framePage.clickOnNestedFrames();
        driver.switchTo().defaultContent();
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-bottom");
        String text = driver.findElement(By.tagName("body")).getText();
        Assertions.assertEquals(text,"BOTTOM");
    }






}
