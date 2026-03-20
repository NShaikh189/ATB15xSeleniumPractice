package org.thetestingacademy.Base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.thetestingacademy.Factory.DriverFactory;

import java.time.Duration;

public class BaseTest {

   public WebDriver driver;

    @BeforeMethod
    public void setup()
    {
        DriverFactory df = new DriverFactory();
        driver = df.initDriver("Chrome");
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(180));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }



   @AfterMethod
    public void tearDown()
    {
      //  driver.close();
        driver.quit();
    }
}
