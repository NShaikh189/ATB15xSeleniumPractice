package org.thetestingacademy.Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class CommonToAll {


    public static WebElement getElementByXpath(WebDriver driver, By path)
    {
        WaitHelper.waitForVisibilityOfElement(driver, driver.findElement(path), Duration.ofSeconds(2));
        return driver.findElement(path);
    }


    public static WebElement getElementByCssSelector(WebDriver driver, By path)
    {
        WaitHelper.waitForVisibilityOfElement(driver, driver.findElement(path), Duration.ofSeconds(2));
        return driver.findElement(path);
    }
}
