package org.thetestingacademy.Booking;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.thetestingacademy.Utility.BaseTest;
import org.thetestingacademy.Utility.WaitHelper;

import java.time.Duration;

public class BookingFlight extends BaseTest {

    By dismissSignLocator = By.xpath("//div[@aria-modal] //button //*[name()='svg']");

    @Test
    public void bookFlightTest() {
        driver.get("https://www.booking.com");

   try {
            WaitHelper.waitForVisibilityOfElementLocated(driver,dismissSignLocator, Duration.ofSeconds(10)).click();
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    }

