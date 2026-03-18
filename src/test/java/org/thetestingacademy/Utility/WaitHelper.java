package org.thetestingacademy.Utility;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WaitHelper {

    static final Duration DEFAULT_TIME_IN_SECONDS = Duration.ofSeconds(5);
    private WaitHelper()
    {}

    public static void waitJVM(WebDriver driver, Duration timeInSeconds) throws InterruptedException {
        Thread.sleep(timeInSeconds.toMillis());
    }
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
    public static WebElement waitForVisibilityOfElement(WebDriver driver, WebElement element)
    {
        WebDriverWait  wait = new WebDriverWait(driver, DEFAULT_TIME_IN_SECONDS);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static List<WebElement> waitForVisibilityOfAllElements(WebDriver driver, By locator, Duration timeInSeconds)
    {
        WebDriverWait  wait = new WebDriverWait(driver, timeInSeconds);
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }


    public static List<WebElement> waitForVisibilityOfAllElements(WebDriver driver, By locator)
    {
        WebDriverWait  wait = new WebDriverWait(driver, DEFAULT_TIME_IN_SECONDS);
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public static WebElement waitForVisibilityOfElementLocated(WebDriver driver, By locator, Duration timeInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForVisibilityOfElementLocated(WebDriver driver, By locator)
    {
        WebDriverWait wait = new WebDriverWait(driver,DEFAULT_TIME_IN_SECONDS);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static boolean waitForElementToBeSelected(WebDriver driver, By locator, Duration timeInSeconds)
    {
        WebDriverWait  wait = new WebDriverWait(driver, timeInSeconds);
      return  wait.until(ExpectedConditions.elementToBeSelected(locator));

    }
    public static boolean waitForElementToBeSelected(WebDriver driver, By locator)
    {
        WebDriverWait  wait = new WebDriverWait(driver, DEFAULT_TIME_IN_SECONDS);
        return  wait.until(ExpectedConditions.elementToBeSelected(locator));

    }
    public static boolean waitForElementToBeSelected(WebDriver driver, WebElement element, Duration timeInSeconds)
    {
        WebDriverWait  wait = new WebDriverWait(driver, timeInSeconds);
        return  wait.until(ExpectedConditions.elementToBeSelected(element));

    }
    public static boolean waitForElementToBeSelected(WebDriver driver, WebElement element)
    {
        WebDriverWait  wait = new WebDriverWait(driver, DEFAULT_TIME_IN_SECONDS);
        return  wait.until(ExpectedConditions.elementToBeSelected(element));

    }
    public static WebElement waitForElementToBeClickable(WebDriver driver, By locator, Duration timeInSeconds)
    {
        WebDriverWait  wait = new WebDriverWait(driver, timeInSeconds);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static WebElement waitForElementToBeClickable(WebDriver driver, WebElement element, Duration timeInSeconds)
    {
        WebDriverWait  wait = new WebDriverWait(driver, timeInSeconds);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public static WebElement waitForElementToBeClickable(WebDriver driver, By locator)
    {
        WebDriverWait  wait = new WebDriverWait(driver, DEFAULT_TIME_IN_SECONDS);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static WebElement waitForElementToBeClickable(WebDriver driver, WebElement element)
    {
        WebDriverWait  wait = new WebDriverWait(driver, DEFAULT_TIME_IN_SECONDS);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public static Alert waitForAlertIsPresent(WebDriver driver, Duration timeInSeconds)
    {
        WebDriverWait  wait = new WebDriverWait(driver, timeInSeconds);
       return wait.until(ExpectedConditions.alertIsPresent());

    }
}
