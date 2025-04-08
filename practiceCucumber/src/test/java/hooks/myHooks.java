package hooks;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.edge.EdgeDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class myHooks extends driverInstance {


	@Before
	public void beforeScenario(Scenario scenarios) {
		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\tharun.baskaran\\eclipse-workspace\\practiceCucumber\\drivers\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.get("https://www.saucedemo.com/");
		Options manage = driver.manage();
		manage.timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		manage.window().maximize();
		System.out.println("Before step: ");
		System.out.println(scenarios.getName());
		System.out.println(scenarios.getId());
		System.out.println(scenarios.getUri());
		System.out.println(scenarios.getClass());
		System.out.println(scenarios.getLines());
		System.out.println(scenarios.getSourceTagNames());
		System.out.println(scenarios.getStatus());
	}
	

	@After(order = 1)
	public void afterScenario(Scenario scenarios) {
		System.out.println("im executed ... ...");
		driver.quit();

	}
	@After("@screenshot")
	public void afterScenario1(Scenario scenarios) {
		boolean failed = scenarios.isFailed();
		System.out.println("is failed ? "+failed);
		if(failed) {
			byte[] screenshotAs = driver.getScreenshotAs(OutputType.BYTES);
			scenarios.embed(screenshotAs, "image/png");
		}
		System.out.println(scenarios.getStatus());
		
		System.out.println("Browser closed successfully");

		//		Type status = scenarios.getStatus();
		//		System.out.println("status is ? "+status);
		

	}
//	@BeforeStep
//	public void beforeStep(Scenario scenarios) {
//		byte[] screenshotAs = driver.getScreenshotAs(OutputType.BYTES);
//		scenarios.embed(screenshotAs, "image/png");
//	}
//	
//	@AfterStep
//	public void afterStep(Scenario scenarios) {
//		byte[] screenshotAs = driver.getScreenshotAs(OutputType.BYTES);
//		scenarios.embed(screenshotAs, "image/png");
//	}

}
