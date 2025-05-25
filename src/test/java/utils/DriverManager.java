package utils;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	
	private static WebDriver driver; // shared across all drivers
	
	private  DriverManager() { } // prevents instantiation
	
	 public static WebDriver getDriver() {
	        if (driver == null) {
	            WebDriverManager.chromedriver().setup();

	            // Setup Chrome preferences BEFORE initializing ChromeDriver
	            Map<String, Object> prefs = new HashMap<>();
	            prefs.put("credentials_enable_service", false);
	            prefs.put("profile.password_manager_enabled", false);

	            ChromeOptions options = new ChromeOptions();
	            options.setExperimentalOption("prefs", prefs);

	            // Additional arguments to disable UI elements
	            options.addArguments("--disable-save-password-bubble");
	            options.addArguments("--incognito"); // Optional, cleaner session
	            options.addArguments("--disable-extensions"); // Optional, disables any Chrome extensions

	            driver = new ChromeDriver(options);
	        }

	        return driver;
	    }

	

}
