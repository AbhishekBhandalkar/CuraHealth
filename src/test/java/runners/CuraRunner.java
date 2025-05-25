package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		features = {
				
				"src/test/resources/features/appointment.feature",
				
		},
		glue = {"stepdefinitions"},
		
		plugin = {
				
				"pretty",
				"html:target/report.html",
				"json:target/report.json",
				"rerun:target/failed_scenarios.txt"
				
		},
		monochrome=true
		
		)

public class CuraRunner extends AbstractTestNGCucumberTests {
}
