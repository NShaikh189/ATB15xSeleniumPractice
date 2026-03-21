package org.thetestingacademy.google;

import org.openqa.selenium.interactions.Actions;
import org.testng.ITestNGListener;
import org.testng.annotations.Test;
import org.thetestingacademy.Factory.DriverFactory;
import org.thetestingacademy.Screenshots.TakeSceenshotHelper;
import org.thetestingacademy.Base.BaseTest;
import org.thetestingacademy.logger.Log;
import org.thetestingacademy.utils.PropertiesReader;

import java.io.IOException;

public class GoogleHomePageTest extends BaseTest implements ITestNGListener{


    @Test
    public void launchGooglePageTest() throws IOException {


        driver.get("https://google.com");

        String path = TakeSceenshotHelper.captureScreenshot(driver, "googleLandingPage");
        Actions action = new Actions(driver);
        Log.info("Google Page loaded successfully");
        Log.info("Screenshot available: "+path);

        PropertiesReader.readKey("username");
//        action.moveToElement(driver.findElement(By.id("abc"))).sendKeys(Keys.chord(Keys.CONTROL,Keys.ENTER)).build().perform();
    }
}
