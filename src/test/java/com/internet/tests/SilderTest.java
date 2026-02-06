package com.internet.tests;

import com.internet.core.TestBase;
import com.internet.pages.HomePage;
import com.internet.pages.widgets.SliderPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SilderTest extends TestBase
{
    HomePage homePage;
    SliderPage sliderPage;
    @BeforeEach
    public void preconditions()
    {
        homePage=new HomePage(driver);
        sliderPage =new SliderPage(driver);
    }

    @Test
    public void horizontalSliderTest()
    {
        homePage.getSilder();
        new SliderPage(driver).moveSlider()
                .verifySilder("5");


    }


}
