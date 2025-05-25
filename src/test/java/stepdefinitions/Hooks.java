package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.DriverManager;
import utils.ScreenshotUtil;

public class Hooks {

    // This method will be executed after each scenario runs (whether it passes or fails)
    @After
    public void tearDown(Scenario scenario) {

        // Get the current WebDriver instance (shared across your test)
        WebDriver driver = DriverManager.getDriver();

        // Check if the scenario failed
        if (scenario.isFailed()) {

            // Save the screenshot as a PNG file locally (for manual review)
            ScreenshotUtil.captureScreenshot(driver, scenario.getName());

            // Also attach the screenshot to the Cucumber report (for report visualization)
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Failure Screenshot");
        }

        // Close the browser after each scenario to clean up resources
        driver.quit();
    }
}
