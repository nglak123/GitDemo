package com.training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.training.base.basepage;

public class loginpage extends basepage{
	
	public loginpage(WebDriver driver) {
		super(driver);
	}

	@FindBy(name="username")
	WebElement email;
	@FindBy(id="password")
	WebElement password;
	@FindBy(id="Login")
	WebElement login;
	@FindBy(xpath="//label[@for='rememberUn']")
	WebElement remember;
	@FindBy(xpath="//a[text()='Logout']")
	WebElement logout;
	@FindBy(id="userNavLabel")
	WebElement dropdown;
	@FindBy(id="forgot_password_link")
	WebElement clickfpwd;
	@FindBy(id="continue")
	WebElement clickContinue;
	@FindBy(id="un")
	WebElement enterUserEmail;
	@FindBy(name="username")
	WebElement invalidUser;
	@FindBy(id="password")
	WebElement invalidPwd;
	@FindBy(id="error")
	WebElement errorMsg;
	
	
	public void enterIntoEmail(String stremail) {
		waitForElement(20,email);
		email.sendKeys(stremail);
	}
	
	public void enterIntoPassword(String strpassword) {
		password.sendKeys(strpassword);
	}
		public void clickOnLogin() {
		login.click();
	}
	public void clickRememberMe() {
		waitForElement(40,remember);
		remember.click();
	}
	public  void usernamedropdown() {
		waitForElement(40,dropdown);
		dropdown.click();
	}
	public void clicklogout() {
		waitForElement(20,logout);
		logout.click();
	}
	public void clickForgotPwdLink() {
		clickfpwd.click();
	}
	
	public void clickContinueButton() {
		waitForElement(20,clickContinue);
		clickContinue.click();
		
	}
	public void enterEmail(String stremail) {
		waitForElement(20,enterUserEmail);
		enterUserEmail.sendKeys(stremail);
	}
	public void enterInvalidEmail() {
		waitForElement(20,email);
		invalidUser.sendKeys("123");
	}
	public void enterInvalidPassword() {
		invalidPwd.sendKeys("22131");
	}
	public void validate() {
		
		String Experr = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		String Acterr= errorMsg.getText();
		//Asserstions . testNg 
		compareText(Acterr, Experr);

		
	}
	public void dropdown() {
		WebElement user=driver.findElement(By.id("userNavLabel"));
		user.click();
		WebElement drpdown=driver.findElement(By.xpath("//a[contains(text(),'My Settings')]"));
		String Act=drpdown.getText();
		String Exp="My Settings";
		compareText(Act,Exp);
		
	}

	public void compareText(String ActualValue, String ExpectedValue) {
						
			Assert.assertEquals(ActualValue, ExpectedValue);
			System.out.println("Test Case is passed");
		
	}
		
}
