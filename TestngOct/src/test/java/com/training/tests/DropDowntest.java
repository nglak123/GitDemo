package com.training.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.base.basetest;
import com.training.pages.DropDownpage;
import com.training.pages.loginpage;
import com.training.utilities.CommonUtilities;

public class DropDowntest extends basetest{
	static WebDriver driver;
	String url;
	CommonUtilities common=new CommonUtilities();
	String browser;
    loginpage login;
    String email;
	String password;
	DropDownpage dropDown;
	
	@BeforeMethod
	public void beforeMethod() throws IOException {
		email = common.getproperty("email");
		password = common.getproperty("password");
		
		url = common.getproperty("url");
		browser = common.getproperty("browser");
		
		driver= getDriver(browser);
		driver.get(url);
		login=new loginpage(driver);
		dropDown=new DropDownpage(driver);
				}
	//	@Test
//	public void clickDropDown05() {
//		login.enterIntoEmail(email);
//		login.enterIntoPassword(password);
//		login.clickOnLogin();
//	    login.usernamedropdown();
//	 	}
//	
//	@Test
//	public void mySettings07A() {
//		login.enterIntoEmail(email);
//		login.enterIntoPassword(password);
//		login.clickOnLogin();
//	    dropDown.usernamedropdown();
//		dropDown.clickMySettings();
//		dropDown.SelectPersonal();
//		
//		dropDown.clickDispaly();
//		dropDown.clickLink();
//		}
//	@Test
//		public void displayAndLayout07B() {
//		login.enterIntoEmail(email);
//		login.enterIntoPassword(password);
//		login.clickOnLogin();
//	    dropDown.usernamedropdown();
//		dropDown.clickMySettings();
//		dropDown.clickOnDisplay();
//		dropDown.clickTab();
//		dropDown.clickAllOptions();
//		dropDown.clickAllTabs();
//		dropDown.clickadd();
//		dropDown.clicksave();
//		
//	}
//	@Test
//	public void selectEmail07C() {
//		login.enterIntoEmail(email);
//		login.enterIntoPassword(password);
//		login.clickOnLogin();
//	    dropDown.usernamedropdown();
//		dropDown.clickMySettings();
//		dropDown.clickonSelectEmail();
//		dropDown.clickonEmailSettings();
//		dropDown.clickonenterEmail();
//		dropDown.clickonyesRadio();
//		dropDown.clickonSaveButton();
//		
//	}
	@Test
	public void selectCalender07D(){
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
	    dropDown.usernamedropdown();
		dropDown.clickMySettings();
		dropDown.clickonSelectCalender();
		dropDown.clickonSelectReminder();
		dropDown.clickonSaveReminderButton();
	}
	
}
