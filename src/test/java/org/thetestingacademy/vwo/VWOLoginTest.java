package org.thetestingacademy.vwo;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.thetestingacademy.Base.BaseTest;
import org.thetestingacademy.Factory.DriverFactory;
import org.thetestingacademy.utils.CommonToAll;
import org.thetestingacademy.utils.WaitHelper;

import java.time.Duration;

public class VWOLoginTest extends BaseTest {

    WebDriverWait wait;

    //By locators
    By loginID = By.cssSelector("#login-username");
    By password = By.cssSelector("#login-password");
    By signBtn = By.xpath("//button[@id = 'js-login-btn']");
    By errorMsgNotification = By.cssSelector("#js-notification-box-msg");

    WebElement loginIDElement;

    @Severity(SeverityLevel.NORMAL)
    @Test
    public void doLogin() {

        WaitHelper waitHelper = new WaitHelper(DriverFactory.getTLDriver());
        driver.get("https://app.vwo.com/#/login");

        waitHelper.waitForVisibilityOfElementLocated( loginID, Duration.ofSeconds(2)).sendKeys("admin@admin.com");
        waitHelper.waitForVisibilityOfElementLocated(password, Duration.ofSeconds(2)).sendKeys("admin");
        waitHelper.waitForVisibilityOfElementLocated(signBtn, Duration.ofSeconds(2)).click();
        waitHelper.waitForVisibilityOfElementLocated(errorMsgNotification, Duration.ofSeconds(2));

        String errorMsg = CommonToAll.getElementByCssSelector(driver, errorMsgNotification).getText();
        Assert.assertEquals(errorMsg, "Your email, password, IP address or location did not match");
    }
}
