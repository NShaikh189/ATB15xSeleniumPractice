package org.thetestingacademy.ex_05_webtables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.tracing.opentelemetry.SeleniumSpanExporter;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.List;

public class TestWebTables {
    WebDriver driver;
    @FindBy(id = "customers")
    WebElement table;


    @Test
    public void testWebTable()
    {
        driver = new ChromeDriver();
        driver.navigate().to("https://awesomeqa.com/webtable.html");
        PageFactory.initElements(driver,this);
        searchUser("Helen Bennett");
    }




    public void searchUser(String empName)
    {
       List<WebElement> tableRows =  table.findElements(By.xpath(".//tr"));
        String company="";
        String country="";
        boolean flag = false;
       for(int i=1; i<tableRows.size(); i++  )
       {
            WebElement clmData = tableRows.get(i).findElement(By.xpath(".//td[2]"));
            String tableContact = clmData.getText();
            if(tableContact.trim().equalsIgnoreCase(empName))
            {
            company = clmData.findElement(By.xpath("./preceding-sibling::td")).getText();
            country = clmData.findElement(By.xpath("./following-sibling::td")).getText();
            flag = true;
            break;
            }
       }

    if(flag)
        System.out.println("Record found: "+empName +","+company+", "+country);
    else
        System.out.println("No record found for "+empName);

        Assert.assertTrue(flag);
    }

    @AfterTest
    public void tearDown()
    {driver.quit();}
}
