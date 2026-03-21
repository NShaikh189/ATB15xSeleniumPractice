package org.thetestingacademy.Booking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.thetestingacademy.Factory.DriverFactory;
import org.thetestingacademy.Screenshots.TakeSceenshotHelper;
import org.thetestingacademy.Base.BaseTest;
import org.thetestingacademy.utils.WaitHelper;

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
        WaitHelper waitHelper = new WaitHelper(DriverFactory.getTLDriver());
        driver.get("https://www.booking.com");

        Actions action = new Actions(driver);

        try {
            waitHelper.waitForVisibilityOfElementLocated(dismissSignLocator, Duration.ofSeconds(10)).click();
            waitHelper.waitForVisibilityOfElementLocated(flightsLocator, Duration.ofSeconds(12)).click();
            waitHelper.waitForElementToBeClickable(
                    leavingFromLocator,
                    Duration.ofSeconds(10)).click();

            waitHelper.waitForElementToBeClickable(clearSearchDestinationLocator,Duration.ofSeconds(10)).click();

            WebElement searchBoardingCountry =  waitHelper.waitForVisibilityOfElementLocated(
                    flightsSearchBoxLocator,Duration.ofSeconds(10));

            searchBoardingCountry.sendKeys("PNQ");
            List<WebElement> searchLeavingCountryList = waitHelper.waitForVisibilityOfAllElements(searchCountryListLocator, Duration.ofSeconds(15));

            for (WebElement element : searchLeavingCountryList) {

                WebElement leavingCountryElement = element.findElement(By.xpath(".//span[2]/span"));
                String leavingCountryName = leavingCountryElement.getText();
                System.out.println(leavingCountryName);
                if (leavingCountryName.contains("Pune International Airport")) {
                    waitHelper.waitForVisibilityOfElement( leavingCountryElement, Duration.ofSeconds(2));
                    waitHelper.waitForElementToBeClickable(leavingCountryElement, Duration.ofSeconds(2)).click();
                    Thread.sleep(5000);
                    break;

                }
            }


            waitHelper.waitForElementToBeClickable(
                    goingToCountryLocator,
                    Duration.ofSeconds(10)).click();


            WebElement searchCountry =  waitHelper.waitForVisibilityOfElementLocated(
                    flightsSearchBoxLocator,Duration.ofSeconds(10));

            searchCountry.sendKeys("DEL");


    List<WebElement> searchCountryList = waitHelper.waitForVisibilityOfAllElements( searchCountryListLocator, Duration.ofSeconds(15));

            for (WebElement element : searchCountryList) {

                WebElement countryElement = element.findElement(By.xpath(".//span[2]/span"));
                String countryName = countryElement.getText();
                System.out.println(countryName);
                if (countryName.contains("Delhi International Airport")) {
                    waitHelper.waitForVisibilityOfElement( countryElement, Duration.ofSeconds(2));
                    waitHelper.waitForElementToBeClickable( countryElement, Duration.ofSeconds(2)).click();
                    Thread.sleep(5000);
                    break;

                }
            }

       //click on Explore or Search button
            waitHelper.waitForElementToBeClickable(
                    exploreButtonLocator,
                    Duration.ofSeconds(5)).click();

            waitHelper.waitJVM(Duration.ofSeconds(20));

            TakeSceenshotHelper.captureScreenshot(DriverFactory.getTLDriver(),"searchFlight.png");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}

