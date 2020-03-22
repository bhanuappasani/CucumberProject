package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.LoginPage;

public class Steps {
	
	public WebDriver driver;
	public LoginPage lp;

	@Given("User Launch Chrome Browser")
	public void user_Launch_Chrome_Browser() {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
		driver = new ChromeDriver();
		
		lp = new LoginPage(driver);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@When("User Open URL {string}")
	public void user_Open_URL(String url) {
		driver.get(url);

	}

	@When("User Enters Email as {string} and Password as {string}")
	public void user_Enters_Email_as_and_Password_as(String email, String pwd) {
		lp.setUserName(email);
		lp.setPassword(pwd);

	}

	@When("User Click Login")
	public void user_Click_Login() {
		lp.setLogin();

	}

	@Then("Page Title should be {string}")
	public void page_Title_should_be(String title) {
		if(driver.getPageSource().contains("Login was unsuccessful.")) {
			driver.close();
			Assert.assertTrue(false);
		}
		else {
			Assert.assertEquals(title, driver.getTitle());
		}

	}

	@When("User Click Logout")
	public void user_Click_Logout() {
		lp.setLogout();
	}

	@Then("User Close Browser")
	public void user_Close_Browser() {
		driver.quit();
	}
}
