package com.internet.tests;

import com.internet.core.BasePage;
import com.internet.core.TestBase;
import com.internet.pages.HomePage;
import com.internet.pages.widgets.DragAndDropPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class DragAndDropTests extends TestBase {


    DragAndDropPage dragAndDrop;
    HomePage homePage;

    @BeforeEach
    public void preconditions()
    {
        dragAndDrop=new DragAndDropPage(driver);
        homePage=new HomePage(driver);

    }

    @Test
    public void dragMeTest()
    {
        homePage.getDragDrop();
        dragAndDrop.dragMe().verifyDropped("B");

    }


}
