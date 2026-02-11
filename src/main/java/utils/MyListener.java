package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.util.Collection;
import java.util.Random;

public class MyListener implements WebDriverListener
{
    Logger logger= LoggerFactory.getLogger(MyListener.class);
    private final WebDriver driver;


    public MyListener(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public void afterPerform(WebDriver driver, Collection<Sequence> actions) {
        WebDriverListener.super.afterPerform(driver, actions);
    }

    @Override
    public void onError(Object target, Method method, Object[] args, InvocationTargetException e) {
     //   WebDriverListener.super.onError(target, method, args, e);
        logger.error("The test has a problem!!!!");
        logger.error("***************************");
        logger.error("Method -->{}",method.getName());
        logger.error("Target exeption --> ",e.getTargetException());
        logger.error("********************************");

        int i =new Random().nextInt(1000);
        String link="screenshots/screen_"+i+".png";
        logger.error("Screen with error --->"+link);

        File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            Files.copy(tmp.toPath(), new File(link).toPath());
        } catch (IOException ex) {
            logger.error("Failed to save screenshot",ex);
        }
    }


    @Override
    public void afterClick(WebElement element) {
       // WebDriverListener.super.afterClick(element);
        logger.info("We clicked on {}",element);
        logger.info("******************************");
    }

    @Override
    public void afterGet(WebDriver driver, String url) {
      // WebDriverListener.super.afterGet(driver, url);
        logger.info("We opened the site{}",url);
    }

    @Override
    public void afterSendKeys(WebElement element, CharSequence... keysToSend) {
        //WebDriverListener.super.afterSendKeys(element, keysToSend);
        logger.info("We enter {} to element {}",keysToSend,element);
        logger.info("******************************");
    }

    @Override
    public void afterGetText(WebElement element, String result) {
       // WebDriverListener.super.afterGetText(element, result);
        logger.info("{} contains{}",element,result);
        logger.info("******************************");
    }
}
