package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;

//import org.junit.runner.RunWith;

import io.cucumber.testng.CucumberOptions;

//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
	    features = {".//Features/LoginFeature.feature",".//Features/Customers.feature"},
	//	features = ".//features/",
		glue= "StepDefination",
		dryRun= false,
		monochrome=true,
		tags="@Sanity",      //Scenario under @sanity tag will be executed
	//	plugin= {"pretty", "html:target/cucumber-reports/reports_html.html"}
	    plugin= {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		)

// plugin= {"pretty", "html:target/cucumber-reports/reports1.html"}
//plugin= {"pretty", "junit:target/cucumber-reports/reports_xml.xml"}
//plugin= {"pretty", "json:target/cucumber-reports/reports_json.json"}
public class Run extends AbstractTestNGCucumberTests {
// this class will be empty
}
