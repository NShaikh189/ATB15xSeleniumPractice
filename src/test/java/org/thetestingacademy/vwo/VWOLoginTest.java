package org.thetestingacademy.vwo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.thetestingacademy.Utility.BaseTest;
import org.thetestingacademy.Utility.CommonToAll;
import org.thetestingacademy.Utility.WaitHelper;

import java.time.Duration;

public class VWOLoginTest extends BaseTest {

    WebDriverWait wait;

    //By locators
    By loginID = By.cssSelector("#login-username");
    By password = By.cssSelector("#login-password");
    By signBtn = By.xpath("//button[@id = 'js-login-btn']");
    By errorMsgNotification = By.cssSelector("#js-notification-box-msg");

    WebElement loginIDElement;

    @Test
    public void doLogin() {

        driver.get("https://app.vwo.com/#/login");

        WaitHelper.waitForVisibilityOfElementLocated(driver, loginID, Duration.ofSeconds(2)).sendKeys("admin@admin.com");
        WaitHelper.waitForVisibilityOfElementLocated(driver, password, Duration.ofSeconds(2)).sendKeys("admin");
        WaitHelper.waitForVisibilityOfElementLocated(driver, signBtn, Duration.ofSeconds(2)).click();
        WaitHelper.waitForVisibilityOfElementLocated(driver, errorMsgNotification, Duration.ofSeconds(2));

        String errorMsg = CommonToAll.getElementByCssSelector(driver, errorMsgNotification).getText();
        Assert.assertEquals(errorMsg, "Your email, password, IP address or location did not match");
    }
}
