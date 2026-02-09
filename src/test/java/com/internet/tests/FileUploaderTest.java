package com.internet.tests;

import com.internet.core.TestBase;
import com.internet.fileUploader.FileUploaderPage;
import com.internet.pages.HomePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FileUploaderTest extends TestBase {

    HomePage homePage;
    FileUploaderPage fileUploader;

    @BeforeEach
   public void setUp()
    {
        homePage=new HomePage(driver);
        fileUploader=new FileUploaderPage(driver);

    }

    @Test
    public void fileUploader()
    {
        homePage.getFileUploader();
        fileUploader.selectFile("/Users/dasabojko/Documents/1.jpeg")
             .clickOnbuttonUpload()
                .verifyFile("1.jpeg");


    }




}
