package org.thetestingacademy.Booking;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;
import org.thetestingacademy.Screenshots.TakeSceenshotHelper;
import org.thetestingacademy.Utility.BaseTest;
import org.thetestingacademy.Utility.CommonToAll;
import org.thetestingacademy.Utility.WaitHelper;

import java.time.Duration;
import java.util.List;

public class BookingFlight extends BaseTest {

    By dismissSignLocator = By.xpath("//div[@aria-modal] //button //*[name()='svg']");
    By flightsLocator = By.id("flights");
    By leavingFromLocator = By.xpath("//button[@data-ui-name='input_location_from_segment_0']");
    By clearSearchDestinationLocator = By.xpath("//div[@aria-label='Departure airport or city'] //*[name()='svg']");
    By flightsSearchBoxLocator = By.xpath("//input[@aria-controls='flights-searchbox_suggestions']");
    By searchCountryListLocator = By.cssSelector("#flights-searchbox_suggestions li");
    By goingToCountryLocator = By.xpath("//button[@data-ui-name='input_location_to_segment_0'] //span[text()='Going to']");
    By exploreButtonLocator = By.xpath("//button[@data-ui-name='button_search_submit']");
    @Test
    public void bookFlightTest() {
        driver.get("https://www.booking.com");

        Actions action = new Actions(driver);

        try {
            WaitHelper.waitForVisibilityOfElementLocated(driver, dismissSignLocator, Duration.ofSeconds(10)).click();
            WaitHelper.waitForVisibilityOfElementLocated(driver, flightsLocator, Duration.ofSeconds(12)).click();
            WaitHelper.waitForElementToBeClickable(driver,
                    leavingFromLocator,
                    Duration.ofSeconds(10)).click();

            WaitHelper.waitForElementToBeClickable(driver,clearSearchDestinationLocator,Duration.ofSeconds(10)).click();

            WebElement searchBoardingCountry =  WaitHelper.waitForVisibilityOfElementLocated(driver,
                    flightsSearchBoxLocator,Duration.ofSeconds(10));

            searchBoardingCountry.sendKeys("PNQ");
            List<WebElement> searchLeavingCountryList = WaitHelper.waitForVisibilityOfAllElements(driver, searchCountryListLocator, Duration.ofSeconds(15));

            for (WebElement element : searchLeavingCountryList) {

                WebElement leavingCountryElement = element.findElement(By.xpath(".//span[2]/span"));
                String leavingCountryName = leavingCountryElement.getText();
                System.out.println(leavingCountryName);
                if (leavingCountryName.contains("Pune International Airport")) {
                    WaitHelper.waitForVisibilityOfElement(driver, leavingCountryElement, Duration.ofSeconds(2));
                    WaitHelper.waitForElementToBeClickable(driver, leavingCountryElement, Duration.ofSeconds(2)).click();
                    Thread.sleep(5000);
                    break;

                }
            }


            WaitHelper.waitForElementToBeClickable(driver,
                    goingToCountryLocator,
                    Duration.ofSeconds(10)).click();


            WebElement searchCountry =  WaitHelper.waitForVisibilityOfElementLocated(driver,
                    flightsSearchBoxLocator,Duration.ofSeconds(10));

            searchCountry.sendKeys("DEL");


    List<WebElement> searchCountryList = WaitHelper.waitForVisibilityOfAllElements(driver, searchCountryListLocator, Duration.ofSeconds(15));

            for (WebElement element : searchCountryList) {

                WebElement countryElement = element.findElement(By.xpath(".//span[2]/span"));
                String countryName = countryElement.getText();
                System.out.println(countryName);
                if (countryName.contains("Delhi International Airport")) {
                    WaitHelper.waitForVisibilityOfElement(driver, countryElement, Duration.ofSeconds(2));
                    WaitHelper.waitForElementToBeClickable(driver, countryElement, Duration.ofSeconds(2)).click();
                    Thread.sleep(5000);
                    break;

                }
            }

       //click on Explore or Search button
            WaitHelper.waitForElementToBeClickable(driver,
                    exploreButtonLocator,
                    Duration.ofSeconds(5)).click();

            WaitHelper.waitJVM(driver,Duration.ofSeconds(20));

            TakeSceenshotHelper.captureScreenshot(driver,"searchFlight.png");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}

