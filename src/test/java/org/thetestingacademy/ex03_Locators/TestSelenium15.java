package org.thetestingacademy.ex03_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class TestSelenium15 {

    WebDriver driver;

    @FindBy(id="login-username")
    WebElement emailId;

    WebDriverWait wait;

    @BeforeTest
    public void setUp()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        PageFactory.initElements(driver, this);

        wait  = new WebDriverWait(driver, Duration.ofSeconds(2));
    }

    @Test
    public void  test_app_vwo_com()
    {

        driver.get("https://app.vwo.com/#/login");
        String originalTab = driver.getWindowHandle();

        driver.findElement(By.linkText("Start a free trial")).click();
       Set<String> windowList = driver.getWindowHandles();
        Iterator<String> itr = windowList.iterator();
        List<String> windows = new ArrayList<>();
       while(itr.hasNext()) {
           if(driver.switchTo().window(itr.next()).getTitle().contains("Free Trial"))
             break;
       }

        System.out.println(driver.getTitle());
       driver.switchTo().window(originalTab);
        System.out.println(driver.getTitle());


        Set<String> wList = driver.getWindowHandles();
        for(String w: wList)
        {
           String wTitle =  driver.switchTo().window(w).getTitle();
           if(wTitle.contains("Free trial"))
               break;
        }
        System.out.println(driver.getTitle());
        // wait.until(ExpectedConditions.visibilityOf(emailId)).sendKeys("abc@gmail.com");
        Assert.assertTrue(true);
    }

    @AfterTest
    public void tearDown()
    {
        driver.quit();
    }
}
