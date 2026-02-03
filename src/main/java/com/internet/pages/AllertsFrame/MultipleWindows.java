package com.internet.pages.AllertsFrame;

import com.internet.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class MultipleWindows extends BasePage
{
    public MultipleWindows(WebDriver driver) {
        super(driver);
    }


    @FindBy(css=" a[href='/windows/new']")
    WebElement clickHereLink;


    public  MultipleWindows clickHere() {
        click(clickHereLink);
        return this;
    }

    public MultipleWindows switchToNewTab(int index) {
        List<String> tabs=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));
        return this;
    }
    @FindBy(css = "div[class='example'] h3")
    WebElement sampleHeading;

    public MultipleWindows verifyClickHierTitle(String title) {
        Assertions.assertTrue(shouldHaveText(sampleHeading,title,5));
        return  this;
    }

}
