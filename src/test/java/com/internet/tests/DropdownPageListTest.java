package com.internet.tests;

import com.internet.core.TestBase;
import com.internet.pages.HomePage;
import com.internet.pages.widgets.DropdownPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DropdownPageListTest extends TestBase {


    HomePage homePage;
    DropdownPage dropdownPage;

    @BeforeEach
    public void preconditions() {
        homePage = new HomePage(driver);
        dropdownPage =new DropdownPage(driver);


    }
    @Test
    public void DropdownList() //выбор элемента в выпадающем списке
    {
        homePage.getDropdownList();
        dropdownPage.selectOptions("Option 1").verifyOption();
    }


}
