package org.thetestingacademy.Factory;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class DriverFactory {

    public WebDriver initDriver(String browserName) {
        WebDriver driver;
        switch (browserName.trim().toLowerCase()) {
            case "chrome":
                ChromeOptions co = new ChromeOptions();
                co.addArguments("--start-maximized");
                co.addArguments("--incognito");
                co.setPageLoadStrategy(PageLoadStrategy.EAGER);
                driver = new ChromeDriver(co);
                break;
            case "safari":
                driver = new SafariDriver();
                break;

            default: {
                System.out.println("Invalid Browser");
                throw new RuntimeException("Invalid Browser");
            }
        }

        return driver;

    }
}
