package com.internet.pages.widgets;

import com.internet.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DragAndDropPage extends BasePage {
    public DragAndDropPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "column-a")
    WebElement columnA;
    @FindBy(id = "column-b")
    WebElement columnB;





    public DragAndDropPage dragMe() {

        actions.dragAndDrop(columnA,columnB).perform();
        return this;
    }

    public DragAndDropPage verifyDropped(String text) {

        Assertions.assertTrue(shouldHaveText(columnA,text,5));
        return this;
    }


}
