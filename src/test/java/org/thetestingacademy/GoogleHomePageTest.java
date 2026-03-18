package org.thetestingacademy;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestNGListener;
import org.testng.annotations.Test;
import org.thetestingacademy.Screenshots.TakeSceenshotHelper;
import org.thetestingacademy.Utility.BaseTest;

public class GoogleHomePageTest extends BaseTest implements ITestNGListener{

    @Test
    public void launchGooglePageTest()
    {
        driver.get("https://google.com");

        TakeSceenshotHelper.captureScreenshot(driver, "googleLandingPage");
        Actions action = new Actions(driver);

//        action.moveToElement(driver.findElement(By.id("abc"))).sendKeys(Keys.chord(Keys.CONTROL,Keys.ENTER)).build().perform();
    }
}
