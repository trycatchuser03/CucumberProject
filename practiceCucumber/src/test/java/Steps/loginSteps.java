package Steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class loginSteps {


	WebDriver driver;

	@Given("user should open the maildrop home url")
	public void userShouldOpenTheMaildropHomeUrl() {
		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\tharun.baskaran\\eclipse-workspace\\sampleCode\\drivers\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.get("https://maildrop.cc/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
	}

	@Given("user should able to enter the {string}")
	public void userShouldAbleToEnterThe(String mailid) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys(mailid);
		String email = driver.findElement(By.xpath("(//input[@type='text'])[1]")).getAttribute("value");
		System.out.println("Entered email id as "+email);

	}

	@When("user clicks on view mailbox button")
	public void userClicksOnViewMailboxButton() {
		driver.findElement(By.xpath("//*[text()='View Mailbox']/parent::button")).click();
		System.out.println("clicked on view mailbox button");  
	}

	@Then("user should able to see the mailbox for the respective mail id")
	public void userShouldAbleToSeTheMailboxForTheRespectiveMailId() {
		try {
		WebElement ele =driver.findElement(By.xpath("//*[text()='Delete']"));	
		if(ele.isDisplayed()) {
			System.out.println("mail is present in mailbox");
		}
		}catch(Exception e) {
			System.out.println("mail is not present in mailbox");
		}
		driver.quit();

	}

}
