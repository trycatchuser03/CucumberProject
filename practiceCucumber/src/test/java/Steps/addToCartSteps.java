package Steps;

import org.openqa.selenium.By;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import hooks.driverInstance;

public class addToCartSteps extends driverInstance{

	@Given("enter {string} and {string}")
	public void enterAnd(String username, String password) {
		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);    
	}

	@Given("click on login")
	public void clickOnLogin() {
		driver.findElement(By.id("login-button")).click();
	}

	@Given("select the {string} and click on add to cart button")
	public void selectTheAndClickOnAddToCartButton(String product) {
	    driver.findElement(By.xpath("//*[contains(@id,'"+product+"')]")).click();
	    System.out.println(product+" added to cart");
	    
	}

	@Then("check whether cart is updated in swag application")
	public void checkWhetherCartIsUpdatedInSwagApplication() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String num = driver.findElement(By.xpath("//*[@class='shopping_cart_badge']")).getText();
		Assert.assertEquals(Integer.parseInt(num)>0, true);
	}

}
