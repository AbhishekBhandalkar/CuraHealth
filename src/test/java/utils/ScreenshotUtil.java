package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ScreenshotUtil {

    // This method captures a screenshot and saves it to the /screenshots directory
    public static void captureScreenshot(WebDriver driver, String testName) {

        // Take screenshot and store it as a temporary file
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Create a destination file with the test name and timestamp
        File destFile = new File("screenshots/" + testName + "_" + System.currentTimeMillis() + ".png");

        // Make sure the "screenshots" directory exists (create if it doesn't)
        destFile.getParentFile().mkdirs();

        try {
            // Copy the screenshot file from source to destination
            Files.copy(srcFile.toPath(), destFile.toPath());

            // Print the full path of the saved screenshot to console (optional)
            System.out.println("Screenshot saved: " + destFile.getAbsolutePath());

        } catch (IOException e) {
            // Print any errors that occur during the file copy process
            e.printStackTrace();
        }
    }
}
