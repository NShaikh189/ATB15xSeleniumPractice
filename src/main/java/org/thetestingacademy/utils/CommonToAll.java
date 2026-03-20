package org.thetestingacademy.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.thetestingacademy.Factory.DriverFactory;

import java.time.Duration;

public class CommonToAll {
    public static WaitHelper waitHelper = new WaitHelper(DriverFactory.getTLDriver());

    public static WebElement getElementByXpath(WebDriver driver, By path)
    {

        waitHelper.waitForVisibilityOfElement( driver.findElement(path), Duration.ofSeconds(2));
        return driver.findElement(path);
    }


    public static WebElement getElementByCssSelector(WebDriver driver, By path)
    {
        waitHelper.waitForVisibilityOfElement( driver.findElement(path), Duration.ofSeconds(2));
        return driver.findElement(path);
    }
}
