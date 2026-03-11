package org.thetestingacademy.Factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {

    public WebDriver initDriver(String browserName) {
        WebDriver driver;
        switch (browserName.trim().toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
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
