package org.thetestingacademy.Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitHelper {
    public static WebDriverWait wait;

    public static void WaitHelper(WebDriver driver, Duration time)
    {
        wait = new WebDriverWait(driver, time);
    }

    public static void waitForVisibilityOfElement(WebDriver driver, WebElement element, Duration timeInSeconds)
    {
        wait = new WebDriverWait(driver, timeInSeconds);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForElementToBeSelected(WebDriver driver, WebElement element, Duration timeInSeconds)
    {
        wait = new WebDriverWait(driver, timeInSeconds);
        wait.until(ExpectedConditions.elementToBeSelected(element));

    }
    public static void waitForElementToBeClickable(WebDriver driver, WebElement element, Duration timeInSeconds)
    {
        wait = new WebDriverWait(driver, timeInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public static void waitForAlertIsPresent(WebDriver driver, Duration timeInSeconds)
    {
        wait = new WebDriverWait(driver, timeInSeconds);
        wait.until(ExpectedConditions.alertIsPresent());

    }
}
