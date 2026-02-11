package com.internet.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import utils.MyListener;

import java.time.Duration;

public class ApplicationManger  {

    String browser;
    protected WebDriver driver;

    public ApplicationManger(String browser) {
        this.browser=browser;
    }

    public WebDriver start() {
        switch (browser)
        {
            case"chrome"->{
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();
            }
            case"safari"->{
                WebDriverManager.safaridriver().setup();
                driver=new SafariDriver();
            }

        }

        WebDriverListener listener=new MyListener(driver);
        driver=new EventFiringDecorator<>(listener).decorate(driver);


        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        return driver;
    }

    public void stop() {
        if(driver!=null)
        {
            driver.quit();
        }
    }


}
