package com.salesforce.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;  // Import FileUtils from Apache Commons IO
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.salesforce.base.TestBaseClass;

public class ScreenShotReader extends TestBaseClass {

    public ScreenShotReader() throws IOException {
        super();
    }

    // Method to capture and save the screenshot
    public void captureScreenshot(String fileName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;

        // Capture the screenshot as a File
        File srcFile = ts.getScreenshotAs(OutputType.FILE);

        // Define the destination path for the screenshot
        File destFile = new File("./ScreenShot_Folder/" + fileName);

        // Copy the captured screenshot to the destination path
        FileUtils.copyFile(srcFile, destFile);
    }
}
  