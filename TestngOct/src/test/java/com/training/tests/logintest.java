package com.training.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.base.basetest;
import com.training.pages.loginpage;
import com.training.utilities.CommonUtilities;
public class logintest extends basetest {
	static WebDriver driver;
	String url;
	CommonUtilities common=new CommonUtilities();
	String browser;
    loginpage login;
    String email;
	String password;
	@BeforeMethod
	public void beforeMethod() throws IOException {
		
		email = common.getproperty("email");
		password = common.getproperty("password");
		
		url = common.getproperty("url");
		browser = common.getproperty("browser");
		
		driver= getDriver(browser);
		driver.get(url);
		login=new loginpage(driver);
		
		
		
	}
	
	//@Test
//	public void validlogin02() {
//		
//		login.enterIntoEmail(email);
//		login.enterIntoPassword(password);
//		login.clickOnLogin();
//	}
	
//	@Test
//	public void rememberMe03()  {
//		login.enterIntoEmail(email);
//		login.enterIntoPassword(password);
//		login.clickRememberMe();
//		login.clickOnLogin();
//		login.usernamedropdown();
//		login.clicklogout();
//		}
//	@Test 
//	public void forgotPassword4A() {
//		login.clickForgotPwdLink();
//		login.enterEmail(email);
//		login.clickContinueButton();
//		}
	@Test
	public void invalidlogin4B() {
		login.enterInvalidEmail();
		login.enterInvalidPassword();
		login.clickOnLogin();
		login.validate();
		String act = null;
		String exp = null;
		login.compareText(act, exp);
		}
	@Test
	public void dropdown5() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		login.dropdown();
	}
	@AfterMethod
	public void teardown() {
		//takescreenshot(driver);
		//driver.close();
	}
}