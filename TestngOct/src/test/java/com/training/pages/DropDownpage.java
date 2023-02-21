package com.training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.training.base.basepage;

public class DropDownpage extends basepage {

	public DropDownpage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id="userNavLabel")
	WebElement user;
	
	@FindBy(xpath="//a[@title=\'My Settings\']")
	WebElement mySet;
	
	@FindBy(id="PersonalInfo_font")
	WebElement personal;
	
	@FindBy(id="LoginHistory_font")
	WebElement display;
	
	@FindBy(xpath="//a[@href='/servlet/servlet.LoginHistory?id=005Dn000000noaE']")
	WebElement link;
	
	@FindBy(xpath="//span[@id='DisplayAndLayout_font']")
	WebElement dis;
	@FindBy(id="CustomizeTabs_font")
	WebElement tab;
	@FindBy(id="p4")
	WebElement alloptions;
	@FindBy(xpath="//select[@id='duel_select_0']")
	WebElement alltabs;
	@FindBy(xpath="//img[@title='Add']")
	WebElement add;
	@FindBy(xpath="//input[@title='Save']")
	WebElement save;
	
	@FindBy(xpath="//span[@id='EmailSetup_font']")
	WebElement selectEmail;
	@FindBy(xpath="//span[@id='EmailSettings_font']")
	WebElement selectEmailSettings;
	@FindBy(xpath="//input[@id='sender_email']")
	WebElement enterEmail;
	@FindBy(xpath="//input[@id='auto_bcc1']")
	WebElement yesRadio;
	@FindBy(xpath="//input[@name='save']")
	WebElement clickSave;
	
	@FindBy(xpath="//span[@id='CalendarAndReminders_font']")
	WebElement selCal;
	@FindBy(xpath="//span[@id='Reminders_font']")
	WebElement selReminder;
	@FindBy(xpath="//input[@id='testbtn']")
	WebElement selReminderbutton;
	
	public void usernamedropdown() {
		waitForElement(20,user);	
    user.click();
}
	public void clickMySettings() {
		waitForElement(80,mySet);
		mySet.click();
	}
	public void SelectPersonal() {
		waitForElement(20,personal);
		personal.click();
	}
	public void clickDispaly() {
		waitForElement(20,display);
		display.click();
	}
	public void clickLink() {
		waitForElement(20,link);
		link.click();
	}
	public void clickOnDisplay() {
		waitForElement(20,dis);
		dis.click();
	}
	public void clickTab() {
		waitForElement(20,tab);
		tab.click();
	}
	public void clickAllOptions() {
		waitForElement(40,alloptions);
		Select option=new Select(alloptions);
		option.selectByVisibleText("Salesforce Chatter");
	}
	public void clickAllTabs() {
		waitForElement(80,alltabs);
		Select optiontab=new Select(alltabs);
		optiontab.selectByVisibleText("Reports");
	}
	public void clickadd() {
		waitForElement(20,add);
		add.click();
	}
	public void clicksave() {
		waitForElement(20,save);
		save.click();
	}
	
	public void clickonSelectEmail() {
		waitForElement(20,selectEmail);
		selectEmail.click();
	}
	
	public void clickonEmailSettings() {
		waitForElement(20,selectEmailSettings);
	
	selectEmailSettings.click();
	}
	
	public void clickonenterEmail() {
		waitForElement(20,enterEmail);
		enterEmail.clear();
		enterEmail.sendKeys("laxme31@gmail.com");
	}
	
	public void clickonyesRadio() {
		waitForElement(20,yesRadio);
		yesRadio.click();
	}
	public void clickonSaveButton() {
		waitForElement(20,clickSave);
		clickSave.click();
	}
	
	
	public void clickonSelectCalender() {
		waitForElement(40,selCal);
		selCal.click();	
	}
	public void clickonSelectReminder() {
		waitForElement(30,selReminder);
		selReminder.click();
	}
	public void clickonSaveReminderButton() {
		waitForElement(30,selReminderbutton);
		selReminderbutton.click();
	}
	
	
	
}
