package steps;

import org.openqa.selenium.WebDriver;

import com.training.base.basetest;
import com.training.pages.loginpage;
import com.training.tests.logintest;
import com.training.utilities.CommonUtilities;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.training.utilities.CommonUtilities;
import java.io.IOException;


public class StepsForLogin extends logintest {
	static WebDriver driver;
	String url;
	CommonUtilities common=new CommonUtilities();
	String browser;
    loginpage login;
    String email;
	String password;
	
	@Before
	public void setup() throws IOException{
	email = common.getproperty("email");
	password = common.getproperty("password");
	
	url = common.getproperty("url");
	browser = common.getproperty("browser");
	}
	@Given("User Launch the saleforce application")
	public void user_launch_the_saleforce_application() {
		

		driver= getDriver(browser);
		driver.get(url);
		login=new loginpage(driver);

	}
	@When("user enter username")
	public void user_enter_username() {
        login.enterIntoEmail(email);

	}
	@When("user enter password")
	public void user_enter_password() {
		login.enterIntoPassword(password);
	}
	@Then("Click on login button")
	public void click_on_login_button() {
		login.clickOnLogin();
	}
	
	@When("Click Remember me")
	public void click_remember_me() {
		login.clickRememberMe();
	}

	@Then("Click username dropdown")
	public void click_username_dropdown() throws InterruptedException {
		Thread.sleep(5000);
		login.usernamedropdown();
	}

	@Then("Click logout")
	public void click_logout() {
		login.clicklogout();
	}
	@When("Click on forgot password link")
	public void click_on_forgot_password_link() {
		login.clickForgotPwdLink();
	}

	@When("user enter email")
	public void user_enter_email() {
		login.enterEmail(email); 
	}

	@Then("Click on continue button")
	public void click_on_continue_button() {
		login.clickContinueButton();
	}

	@When("Enter invalid email")
	public void enter_invalid_email() {
		login.enterInvalidEmail();
	}

	@When("Enter invalid password")
	public void enter_invalid_password() {
		login.enterInvalidPassword();
	}

	@Then("validate")
	public void validate() {
System.out.println("Testcase is passed");
}
	
	@After
	public void teardown() {
		//takescreenshot(driver);
		driver.close();
	} 
	}
	
	

