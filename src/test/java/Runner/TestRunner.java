package Runner;

import org.junit.runner.RunWith;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import Utilities.ConfigReader;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.junit.Cucumber;




@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/Feature",
		glue={"classpath:stepDefinition"},
	    plugin = {
					      "pretty",
					      "html:reports/tests/cucumber/html",
					      "timeline:reports/tests/cucumber/timeline",
					      "junit:reports/tests/cucumber/junit/cucumber.xml",
					      "testng:reports/tests/cucumber/testng/cucumber.xml",
					      "json:reports/tests/cucumber/json/cucumber.json"
					    }
		//dryRun=true
		)

public class TestRunner extends AbstractTestNGCucumberTests {
	
	@DataProvider(parallel = true)
	public Object[][] scenarios()
	{
		return super.scenarios();
	}
	
	@BeforeTest
	@Parameters({"browsers"})
	public void  defineBrowser(String browser)
	{
		ConfigReader.setBrowserType(browser);
	}
	    
}
