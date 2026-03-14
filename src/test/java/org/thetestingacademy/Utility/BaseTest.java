package org.thetestingacademy.Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.thetestingacademy.Factory.DriverFactory;

import java.sql.Driver;
import java.time.Duration;

public class BaseTest {

    public WebDriver driver;

    @BeforeTest
    public void setup()
    {
        DriverFactory df = new DriverFactory();
        driver = df.initDriver("Chrome");
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
    }


    @AfterTest
    public void tearDown()
    {driver.quit();
    }
}
