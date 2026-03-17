package org.thetestingacademy.Screenshots;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.util.Properties;

public class TakeSceenshotHelper {

    private TakeSceenshotHelper() {

    }

    public static void captureScreenshot(WebDriver driver, String name) {
        try {
            String path = System.getProperty("user.dir") + "/Screenshots/" + name + "_img_" + System.currentTimeMillis() + ".png";

            //Create one file src by capture as output type FILE
            //create another dest file as empty having a filename of the path
            //copy image file to destincation file
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File outputTypeFile = screenshot.getScreenshotAs(OutputType.FILE);
            File fnm = new File(path);
            FileUtils.copyFile(outputTypeFile, fnm);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
