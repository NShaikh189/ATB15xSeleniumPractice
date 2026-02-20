package org.thetestingacademy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium002 {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://sdet.live");
        driver.quit();
       // driver.close();
    }
}
