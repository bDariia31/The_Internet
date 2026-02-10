package com.internet.brokenImage;

import com.internet.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

public class BrokenImagePage extends BasePage
{


    public BrokenImagePage(WebDriver driver) {
        super(driver);
    }

//    @FindBy(css="a")
//    List<WebElement> allLinks;
//
//    public BrokenImagePage getAllLink()
//    {
//
//        System.out.println("Total links on the page="+allLinks.size());
//        String url="";
//        Iterator<WebElement> iterator=allLinks.iterator();
//        while (iterator.hasNext())
//        {
//            url=iterator.next().getText();
//            System.out.println(url);
//            System.out.println("*********************************");
//
//        }
//        return this;
//    }
//




    @FindBy(css="img")
    List<WebElement> images;

    public BrokenImagePage checkBrokenImage() {
        System.out.println("Total images on the page"+ images.size());
        for(int i=0;i<images.size();i++) {
            WebElement image = images.get(i);
            String imageUrl = image.getAttribute("scr");
            verifyLinks(imageUrl);

            try {
                boolean imageDisplay = (Boolean) js.executeScript
                        ("return (typeof arguments[0].naturalWidth!=undefined && arguments[0].naturalWidth>0);", image);
                if(imageDisplay)
                {
                    softly.assertThat(imageDisplay);

                }else
                {
                    softly.fail("BROKEN image -->"+imageUrl);
                }
            } catch (Exception e) {
                softly.fail("ERROR occurred");
            }


        }
        softly.assertAll();
        return this;
    }



}
