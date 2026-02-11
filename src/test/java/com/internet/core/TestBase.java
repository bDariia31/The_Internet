package com.internet.core;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import utils.MyTestWatcher;

@ExtendWith(MyTestWatcher.class)
public class TestBase
{

    protected WebDriver driver;
    protected ApplicationManger app=new ApplicationManger
            (System.getProperty("browser","chrome"));


    @BeforeEach
    public void init()
    {
     driver= app.start();


    }


    @AfterEach
    public void tearDown()
    {
        app.stop();
    }


}
