package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class OrangeHRMSteps {
	
	WebDriver driver;

	@Given("Launch the chrome browser")
	public void launch_the_chrome_browser() {
		
		driver = new ChromeDriver();

	}

	@When("Open the OrangeHRM login page")
	public void open_the_OrangeHRM_login_page() {
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com");
	}

	@Then("Verify that logo is present on the login page")
	public void verify_that_logo_is_present_on_the_login_page() {
		boolean status = driver.findElement(By.xpath("//div[@id='divLogo']//img")).isDisplayed();
		Assert.assertEquals(true, status);
	}

	@Then("Close the browser")
	public void close_the_browser() {
		driver.close();
	}
}
