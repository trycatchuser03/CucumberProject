package testRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = {"src/test/java/features/addToCart.feature"}, 
		dryRun = !true,
		snippets = SnippetType.CAMELCASE,
		monochrome = true,
		glue = {"Steps","hooks"},
		plugin =  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		//		plugin = {"pretty","html:cucumberReports"},
		//				"junit:Reports/result.xml"
		//				,"json:Reports/result.json"}
		//tags = {"@prod"}

		)

public class Runner extends AbstractTestNGCucumberTests {
}
