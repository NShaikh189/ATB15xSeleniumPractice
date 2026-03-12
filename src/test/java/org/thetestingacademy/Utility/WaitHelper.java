package org.thetestingacademy.Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitHelper {
    public static WebDriverWait wait;

    private WaitHelper()
    {}
    public static WebElement waitForVisibilityOfElement(WebDriver driver, WebElement element, Duration timeInSeconds)
    {
        wait = new WebDriverWait(driver, timeInSeconds);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForVisibilityOfElementLocated(WebDriver driver, By locator, Duration timeInSeconds)
    {
        wait = new WebDriverWait(driver, timeInSeconds);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static boolean waitForElementToBeSelected(WebDriver driver, By locator, Duration timeInSeconds)
    {
        wait = new WebDriverWait(driver, timeInSeconds);
        WebElement element = waitForVisibilityOfElementLocated(driver,locator,timeInSeconds);
      return  wait.until(ExpectedConditions.elementToBeSelected(element));

    }
    public static WebElement waitForElementToBeClickable(WebDriver driver, By locator, Duration timeInSeconds)
    {
        wait = new WebDriverWait(driver, timeInSeconds);
        WebElement element = waitForVisibilityOfElementLocated(driver,locator,timeInSeconds);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public static void waitForAlertIsPresent(WebDriver driver, Duration timeInSeconds)
    {
        wait = new WebDriverWait(driver, timeInSeconds);
        wait.until(ExpectedConditions.alertIsPresent());

    }
}
