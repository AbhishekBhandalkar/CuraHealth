package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utils.DriverManager;

public class CuraStepdefinition {

	private WebDriver driver;
	LoginPage lp;

	public CuraStepdefinition() {

		this.driver  = DriverManager.getDriver(); 
		this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // ✅ Add implicit wait
		this.driver.manage().window().maximize();
		this.lp = new LoginPage(driver);

	}

	@Given("User is on the Make appointment page")
	public void User_is_on_the_Make_appointment_page() {

		driver.get("https://katalon-demo-cura.herokuapp.com/#appointment");

	}

	@And("Taps on make appointment button")
	public void tap_appt_step() {
		
		lp.clickAppointmentbtn();
	}
	
	@And("Enters login and password and taps on Login button")
	public void login_step() {
		lp.loginMethod();

	}

	@And("Selects healthcare facility")
	public void healthcare_fac() {
		lp.dropdownMethod();

	}

	@And("Selects healthcare program")
	public void health_prog() {

		lp.healthProg();

	}

	@And("Enters date")
	public void date_step() {

		lp.dateMethod();
	}

	@And("Adds comment")
	public void comment_step() {
		lp.commentMethod();

	}

	@When("User taps on book appointment button")
	public void book_step() {
		lp.bookMethod();

	}
	
	@Then("Appointment confirmation page appears")
	public void confirmation_step() {
		lp.ConfirmMethod();
		
		
	}
}
