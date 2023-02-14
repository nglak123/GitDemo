package autoAssignments;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class basetest {
	static WebDriver driver=null;
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

}
