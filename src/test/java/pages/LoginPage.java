package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utils.DriverManager;

public class LoginPage {

	WebDriver driver = DriverManager.getDriver();
	WebDriverWait wait;

	// locators

	By makeApptBtn = By.id("btn-make-appointment");
	By usernameField = By.name("username");
	By pwdField = By.name("password");
	By loginButton = By.id("btn-login");
	By facility = By.id("combo_facility");
	By healthProg1 = By.xpath("//input[@value=\"Medicaid\"]");
	By dateField = By.name("visit_date");
	By commentField = By.id("txt_comment");
	By bookAppt = By.id("btn-book-appointment");
	By aptConfirm = By.xpath("//h2[text()='Appointment Confirmation']");

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	}

	// methods

	public void clickAppointmentbtn() {

		WebElement apptBtnElement = driver.findElement(makeApptBtn);
		apptBtnElement.click();

	}

	public void loginMethod() {

		WebElement userElement = driver.findElement(usernameField);
		userElement.sendKeys("John Doe");

		WebElement passwordElement = driver.findElement(pwdField);
		passwordElement.sendKeys("ThisIsNotAPassword");

		WebElement loginElement = driver.findElement(loginButton);
		loginElement.click();
	}

	public void dropdownMethod() {

		WebElement drpDown = driver.findElement(facility);

		Select drp = new Select(drpDown);

		drp.selectByVisibleText("Hongkong CURA Healthcare Center");

	}

	public void healthProg() {

		WebElement healthProgElement = driver.findElement(healthProg1);
		healthProgElement.click();

	}

	public void dateMethod() {

		WebElement dateElement = driver.findElement(dateField);
		dateElement.sendKeys("30/05/2025");

	}

	public void commentMethod() {

		WebElement commentElement = driver.findElement(commentField);
		commentElement.sendKeys("First appointment");

	}

	public void bookMethod() {

		WebElement bookBtnElement = driver.findElement(bookAppt);
		bookBtnElement.click();

	}

	public void ConfirmMethod() {

		WebElement header = driver.findElement(aptConfirm);
		String headerText = header.getText();

		Assert.assertEquals(headerText, "Appointment Confirmatio", "Header text does not match expected!");

	}

}
