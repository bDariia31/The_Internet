package com.internet.core;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected static WebDriver driver;
    public static JavascriptExecutor js;
    public static Actions actions;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        js = (JavascriptExecutor) driver;
        actions=new Actions(driver);
    }

    public void scrollWithJS(int x, int y) {
        js.executeScript("window.scrollBy(" + x + "," + y + ")");

    }


    public void clickWithJs(WebElement element, int x, int y) {
       scrollWithJS(x,y);
       click(element);
    }


    public static void click(WebElement element) {
        element.click();
    }

    public void typeWithJS(WebElement element,String text,int x,int y)
    {
        scrollWithJS(x,y);
        type(element,text);
    }

    public void type(WebElement element, String text) {
        if (text != null) {
            click(element);
            element.clear();
            element.sendKeys(text);

        }
    }


    public boolean shouldHaveText(WebElement element, String text, int time) {
        return getWait(time).until(ExpectedConditions.textToBePresentInElement(element,text));
    }

    public WebDriverWait getWait(int time) {
        return  new WebDriverWait(driver, Duration.ofSeconds(time));
    }




    public String getValue(WebElement element,String value)
    {
        return element.getDomAttribute(value);
    }

    protected boolean isContainsText(String number, WebElement element) {
        return element.getText().contains(number);
    }
}
