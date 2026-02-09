package com.internet.fileUploader;

import com.internet.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FileUploaderPage extends BasePage {
    public FileUploaderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="file-upload")
    WebElement  uploadPicture;

    public FileUploaderPage selectFile(String path) {

      uploadPicture.sendKeys(path);
        return this;
    }

    @FindBy( id="file-submit")
    WebElement uploadButton;
    public FileUploaderPage clickOnbuttonUpload() {
        click(uploadButton);
        return this;
    }

    @FindBy( id="uploaded-files")
    WebElement textFile;
    public FileUploaderPage verifyFile(String file) {

        Assertions.assertTrue(shouldHaveText(textFile,file,10));
        return this;
    }
}
