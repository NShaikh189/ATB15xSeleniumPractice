package org.thetestingacademy.Utility;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitHelper {


    private WaitHelper()
    {}
    public static boolean waitForPageLoad(WebDriver driver, Duration timeInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeInSeconds) ;
        return wait.until(d-> (JavascriptExecutor)d)
                .executeScript("return document.readyState")
                .equals("complete");
        //return Boolean.parseBoolean(wait.until(ExpectedConditions.jsReturnsValue("return document.readyState==='complete'")).toString());
    }
    public static WebElement waitForVisibilityOfElement(WebDriver driver, WebElement element, Duration timeInSeconds)
    {
        WebDriverWait  wait = new WebDriverWait(driver, timeInSeconds);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForVisibilityOfElementLocated(WebDriver driver, By locator, Duration timeInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static boolean waitForElementToBeSelected(WebDriver driver, By locator, Duration timeInSeconds)
    {
        WebDriverWait  wait = new WebDriverWait(driver, timeInSeconds);
      return  wait.until(ExpectedConditions.elementToBeSelected(locator));

    }
    public static WebElement waitForElementToBeClickable(WebDriver driver, By locator, Duration timeInSeconds)
    {
        WebDriverWait  wait = new WebDriverWait(driver, timeInSeconds);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public static Alert waitForAlertIsPresent(WebDriver driver, Duration timeInSeconds)
    {
        WebDriverWait  wait = new WebDriverWait(driver, timeInSeconds);
       return wait.until(ExpectedConditions.alertIsPresent());

    }
}
