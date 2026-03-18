package org.thetestingacademy.herokuapp;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.thetestingacademy.Utility.BaseTest;
import org.thetestingacademy.Utility.WaitHelper;

import java.time.Duration;
import java.util.Set;

public class herokuappWindowsHandling extends BaseTest {

    By clickHereLocator = By.linkText("Click Here");

    @Test
    public void windowHandlingTest()
    {
        try {
            driver.get("https://the-internet.herokuapp.com/windows");
            String parent_window_id = driver.getWindowHandle();
            WaitHelper.waitForVisibilityOfElementLocated(driver, clickHereLocator).click();

            Set<String> windowList = driver.getWindowHandles();
            for (String window : windowList) {
                System.out.println(window);
                driver.switchTo().window(window);

                String pageTitle = driver.getTitle();
                System.out.println(pageTitle);
                WaitHelper.waitJVM(driver, Duration.ofSeconds(5));

            }
            driver.switchTo().window(parent_window_id);

            System.out.println(driver.getTitle());
            WaitHelper.waitJVM(driver, Duration.ofSeconds(5));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
