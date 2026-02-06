package com.internet.pages.widgets;

import com.internet.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SliderPage extends BasePage {
    public SliderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='sliderContainer']/input")
    WebElement rangeSilder;

    public SliderPage moveSlider() {
        actions.dragAndDropBy(rangeSilder, 60, 0).perform();
        return this;
    }

    @FindBy(xpath = "//span[@id='range']")
    WebElement sliderValue;

    public SliderPage verifySilder(String number) {
      Assertions.assertTrue(isContainsText(number, sliderValue));
        //Assertions.assertEquals(number, getValue(sliderValue, "value"));
        return this;
    }


}
