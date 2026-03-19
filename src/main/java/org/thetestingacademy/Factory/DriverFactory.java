package org.thetestingacademy.Factory;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class DriverFactory {

    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

    public static WebDriver getTLDriver()
    {
        return tlDriver.get();
    }
    public WebDriver initDriver(String browserName) {
        WebDriver driver;
        switch (browserName.trim().toLowerCase()) {
            case "chrome":
                ChromeOptions co = new ChromeOptions();
                co.addArguments("--start-maximized");
                co.addArguments("--incognito");
                co.addArguments("--disable-blink-features=AutomationControlled");
            //    co.setPageLoadStrategy(PageLoadStrategy.EAGER);
                driver = new ChromeDriver(co);
                tlDriver.set(driver);
                break;
            case "safari":
                driver = new SafariDriver();
                tlDriver.set(driver);
                break;

            default: {
                System.out.println("Invalid Browser");
                throw new RuntimeException("Invalid Browser");
            }
        }

        return getTLDriver();

    }
}
