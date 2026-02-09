package com.internet.pages.contextMenu;

import com.internet.core.BasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ContextMenuPage extends BasePage {


    public ContextMenuPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(id = "hot-spot")
    WebElement border;

    public ContextMenuPage clickOnBorder() {

        new Actions(driver)
                .contextClick(border)
                .perform();
        return this;
    }

    public ContextMenuPage clickOnAllertOk() {

       getWait(10);
        Alert alert=driver.switchTo().alert();
        alert.accept();
        return this;


    }

    public ContextMenuPage moveToDownAndEnter() {

        actions.keyDown(Keys.DOWN).keyUp(Keys.DOWN).perform();
        actions.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
        return this;
    }

    @FindBy(css = "div[class='example'] h3")
    WebElement homeTitle;

    public ContextMenuPage verifyHomePage() {

        driver.navigate().back();
        return this;
    }
}
