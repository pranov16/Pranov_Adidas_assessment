package runner;


import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "C:/Users/RED MACHINE/Desktop/New folder/cucumberassessment/src/main/java/feature",
		glue={"stepdefinition"}
		
		)





public class exercise2runner {

}
