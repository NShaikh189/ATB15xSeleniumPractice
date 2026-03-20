package org.thetestingacademy.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WaitHelper {

    static final Duration DEFAULT_TIME_IN_SECONDS = Duration.ofSeconds(5);
    WebDriver driver;

    public WaitHelper(WebDriver driver)
    {
        this.driver = driver;
    }
    private WaitHelper()
    {}

    public  void waitJVM( Duration timeInSeconds) throws InterruptedException {
        Thread.sleep(timeInSeconds.toMillis());
    }
    public  void waitJVM( int timeInMillis) throws InterruptedException {
        Thread.sleep(timeInMillis);
    }
    public  boolean waitForPageLoad( Duration timeInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeInSeconds) ;
        return wait.until(d-> (JavascriptExecutor)d)
                .executeScript("return document.readyState")
                .equals("complete");
        //return Boolean.parseBoolean(wait.until(ExpectedConditions.jsReturnsValue("return document.readyState==='complete'")).toString());
    }
    public  WebElement waitForVisibilityOfElement(WebElement element, Duration timeInSeconds)
    {
        WebDriverWait  wait = new WebDriverWait(driver, timeInSeconds);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    public  WebElement waitForVisibilityOfElement( WebElement element)
    {
        WebDriverWait  wait = new WebDriverWait(driver, DEFAULT_TIME_IN_SECONDS);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    public  List<WebElement> waitForVisibilityOfAllElements(By locator, Duration timeInSeconds)
    {
        WebDriverWait  wait = new WebDriverWait(driver, timeInSeconds);
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }


    public  List<WebElement> waitForVisibilityOfAllElements( By locator)
    {
        WebDriverWait  wait = new WebDriverWait(driver, DEFAULT_TIME_IN_SECONDS);
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public  WebElement waitForVisibilityOfElementLocated(By locator, Duration timeInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForVisibilityOfElementLocated(By locator)
    {
        WebDriverWait wait = new WebDriverWait(driver,DEFAULT_TIME_IN_SECONDS);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public  boolean waitForElementToBeSelected(By locator, Duration timeInSeconds)
    {
        WebDriverWait  wait = new WebDriverWait(driver, timeInSeconds);
      return  wait.until(ExpectedConditions.elementToBeSelected(locator));

    }
    public  boolean waitForElementToBeSelected(By locator)
    {
        WebDriverWait  wait = new WebDriverWait(driver, DEFAULT_TIME_IN_SECONDS);
        return  wait.until(ExpectedConditions.elementToBeSelected(locator));

    }
    public  boolean waitForElementToBeSelected(WebElement element, Duration timeInSeconds)
    {
        WebDriverWait  wait = new WebDriverWait(driver, timeInSeconds);
        return  wait.until(ExpectedConditions.elementToBeSelected(element));

    }
    public  boolean waitForElementToBeSelected(WebElement element)
    {
        WebDriverWait  wait = new WebDriverWait(driver, DEFAULT_TIME_IN_SECONDS);
        return  wait.until(ExpectedConditions.elementToBeSelected(element));

    }
    public  WebElement waitForElementToBeClickable(By locator, Duration timeInSeconds)
    {
        WebDriverWait  wait = new WebDriverWait(driver, timeInSeconds);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public  WebElement waitForElementToBeClickable(WebElement element, Duration timeInSeconds)
    {
        WebDriverWait  wait = new WebDriverWait(driver, timeInSeconds);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public  WebElement waitForElementToBeClickable(By locator)
    {
        WebDriverWait  wait = new WebDriverWait(driver, DEFAULT_TIME_IN_SECONDS);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public  WebElement waitForElementToBeClickable(WebElement element)
    {
        WebDriverWait  wait = new WebDriverWait(driver, DEFAULT_TIME_IN_SECONDS);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public  Alert waitForAlertIsPresent(Duration timeInSeconds)
    {
        WebDriverWait  wait = new WebDriverWait(driver, timeInSeconds);
       return wait.until(ExpectedConditions.alertIsPresent());

    }
}
