package org.thetestingacademy;

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

    }
}
