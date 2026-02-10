package com.internet.tests;

import com.internet.brokenImage.BrokenImagePage;
import com.internet.core.TestBase;
import com.internet.pages.HomePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class BrokenImagesTest extends TestBase
{
    HomePage homePage;
    BrokenImagePage brokenImage;
    @BeforeEach
    public void setUp()
    {
        homePage=new HomePage(driver);
        brokenImage=new BrokenImagePage(driver);

    }

    @Test
    public void brokenImageTest()
    {
        homePage.getBrokenImage();
        brokenImage.checkBrokenImage();

    }


}
