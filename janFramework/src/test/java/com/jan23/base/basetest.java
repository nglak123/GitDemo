package com.jan23.base;


import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


import com.jan23.utility.ExtentReportsUtility;
import com.jan23.utility.PropertiesUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class basetest {
	protected static WebDriver driver=null;
	protected static WebDriverWait wait=null;
	protected static Logger logger=null;
	protected static ExtentReportsUtility extentreport=null;
	
	
	@BeforeTest
	
	public void setUpBeforeTest() {
		System.out.println("inside @BeforeTest method");
		logger=LogManager.getLogger(basetest.class.getName());
		extentreport=new ExtentReportsUtility();
		extentreport.startExtentReport();
	}
	
	@AfterTest
	public void teatdownAfterTest() {
		extentreport.endReport();
	}
	
	@BeforeMethod
	@Parameters("browsername")
	public void setUpBeforeTestMethod(@Optional("chrome") String browserName,Method method) throws InterruptedException {
		extentreport.startSingleTestReport("testcase");
		logger.info("started testscript name"+method.getName());
		PropertiesUtility propertiesUtility=new PropertiesUtility();
		propertiesUtility.loadFile("applicationDataProperties");
		String url=propertiesUtility.getPropertyValue("url");
		GetDriverInstance(browserName);
		goToUrl(url);
		
		
	}
	

	@AfterMethod
	public void teardownAfterTestMethod() {
		driver.close();
	}
	
	public void goToUrl(String url) {
		logger.info("going to the url= "+url);
		driver.get(url);
	}
	public void closeBrowser() {
		logger.info("closing the browser");
		driver.close();
	}
	public String getPageTitle() {
		return driver.getTitle();
	}
	public void refreshPage() {
		driver.navigate().refresh();
	}
	

	public static void enterText(WebElement element,String text,String name) {
		if(element.isDisplayed()) {
		element.clear();
			element.sendKeys(text);
	}
	else {
		System.out.println(name+"web element is not displayed");
	}
	driver.getTitle();
	}
	
	
	public static String enterText(WebElement element,String text) {
		if(element.isDisplayed()) {
		return element.getText();
			
	}
		else {
			System.out.println(text+" is not displayed");
			return null;
		}
	}
	
		
	public static void checkBox(WebElement element,String name) {
		if(!element.isSelected())
		{
			element.click();
		}
		else {
			element.click();
			element.click();
		}
	}
	
	public static void radioBtn(WebElement element,String name) {
					element.click();
	
	}
	
	public static void dropdown(WebElement element,String name) {
		if(element.isDisplayed()) {
			Select sel=new Select(element);
			sel.selectByVisibleText(name);
		}
		else {
			System.out.println(name+"web element is not displayed");
		}
	}
	
	
public static void GetDriverInstance(String browserName) {
	switch(browserName) {
	case "firefox":WebDriverManager.firefoxdriver().setup();
	driver=new FirefoxDriver();
	driver.manage().window().maximize();
	break;
	
	case "chrome":WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	break;
	default:System.out.println("Enter proper browser name");
		}
}

public static void gotoUrl(String url) {
	
	driver.get(url);
}
	public static String getTextFrmElement(WebElement element,String name) {
		
		return element.getText();
		
	}


public static void clicklogin()  {
		WebElement login=driver.findElement(By.id("Login"));
		login.click();
		
	}
public static void validation(String actual,String Expected,int num) {
	if(actual.equalsIgnoreCase(Expected))
		System.out.println("Testcase "+num+" is passed");
	else
		System.out.println("Testcase "+num+" is failed");
}

public static void waitForElement(int time, WebElement element) {
	WebDriverWait wait = new WebDriverWait(driver,time);
	wait.until(ExpectedConditions.visibilityOf(element));
	
}
public static void clicklogout() {
	WebElement logout=driver.findElement(By.xpath("//a[text()='Logout']"));
	logout.click();
	
}
public static String getScreenshotOfThePage(WebDriver driver) {
	String date=new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
	String curDir=System.getProperty("user.dir");
	TakesScreenshot screenshot=(TakesScreenshot)driver;
	File imgFile=screenshot.getScreenshotAs(OutputType.FILE);
	File destFile=new File(curDir+"/screenshots/"+date+".png");
	try {
		FileHandler.copy(imgFile, destFile);
	}catch(IOException e) {
		e.printStackTrace();
	}
return destFile.getAbsolutePath();
	}



}


