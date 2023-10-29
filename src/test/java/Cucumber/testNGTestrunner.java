package Cucumber;

import org.testng.Assert;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



@CucumberOptions(features="src\\test\\java\\cucumber",glue = "Autolearndemo.stepDefination",
monochrome = true, tags = "@Regression", plugin = {"html:target/cucumber.html"})


public class testNGTestrunner extends AbstractTestNGCucumberTests {
	
	Assert.assertEquals("Incorrect email or password",landingPage.getErrorMessage());
	
	 

}
