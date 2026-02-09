package com.internet.pages;

import com.internet.core.BasePage;
import com.internet.fileUploader.FileUploaderPage;
import com.internet.pages.AllertsFrame.AlertsPage;
import com.internet.pages.AllertsFrame.FramesPage;
import com.internet.pages.AllertsFrame.MultipleWindowsPage;
import com.internet.pages.contextMenu.ContextMenuPage;
import com.internet.pages.widgets.DragAndDropPage;
import com.internet.pages.widgets.DropdownPage;
import com.internet.pages.widgets.SliderPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {


    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[@class='heading']")
    WebElement header;

    @FindBy(css = "a[href=\"/javascript_alerts\"]")
    WebElement javaScriptAllert;


    public AlertsPage getJavaScriptAlerts() {
        click(javaScriptAllert);
        return new AlertsPage(driver);
    }

    @FindBy(css = "a[href='/windows']")
    static WebElement multipleWindows;


    public MultipleWindowsPage getMultipleWindows() {
        click(multipleWindows);
        return new MultipleWindowsPage(driver);
    }

    @FindBy(css = "a[href='/dropdown']")
    WebElement dropdown;

    public DropdownPage getDropdownList() {
        clickWithJs(dropdown, 0, 300);
        return new DropdownPage(driver);
    }

    @FindBy(css = "a[href='/dropdown']")
    WebElement framesPage;


    public FramesPage getFrames() {

        clickWithJs(framesPage, 0, 300);
        return new FramesPage(driver);

    }

    @FindBy(css = "a[href=\"/horizontal_slider\"]")
    WebElement horizontalSlider;

    public SliderPage getSilder() {

        clickWithJs(horizontalSlider, 0, 300);
        return new SliderPage(driver);
    }

    @FindBy(css = "a[href=\"/drag_and_drop\"]")
    WebElement dragAndDrop;

    public DragAndDropPage getDragDrop() {
        clickWithJs(dragAndDrop, 0, 300);
        return new DragAndDropPage(driver);
    }


    @FindBy(css = "a[href=\"/context_menu\"]")
    WebElement contextMenu;

    public ContextMenuPage getContextMenu() {
        clickWithJs(contextMenu, 0, 300);
        return new ContextMenuPage(driver);
    }

    @FindBy(css = "a[href='/upload']")
    WebElement fileUpload;

    public FileUploaderPage getFileUploader() {

        clickWithJs(fileUpload, 0, 400);

        return new FileUploaderPage(driver);
    }
}
