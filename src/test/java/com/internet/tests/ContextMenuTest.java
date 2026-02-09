package com.internet.tests;

import com.internet.pages.contextMenu.ContextMenuPage;
import com.internet.core.TestBase;
import com.internet.pages.HomePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContextMenuTest extends TestBase {

    ContextMenuPage contextMenu;
    HomePage homePage;


    @BeforeEach
    public void preconditions() {
        homePage = new HomePage(driver);
        contextMenu = new ContextMenuPage(driver);
    }


    @Test
    public void ContextMenuText() {
        homePage.getContextMenu();
        contextMenu.clickOnBorder().clickOnAllertOk()
                .moveToDownAndEnter()
                .verifyHomePage();
    }


}
