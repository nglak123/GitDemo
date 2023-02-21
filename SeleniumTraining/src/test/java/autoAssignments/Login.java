package autoAssignments;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login extends basetest {


public static void main(String[] args) throws IOException, InterruptedException,AWTException {
	loginpage();
	clicklogin();
	
}
public static void loginpage() throws IOException,InterruptedException { 
	
	String curdir=System.getProperty("user.dir");
	FileInputStream fis=new FileInputStream(new File(curdir+"/src/test/resources/testData.properties"));
	Properties ob=new Properties();
	ob.load(fis);
	String url=ob.getProperty("url");
	String username=ob.getProperty("login.valid.userid");
    String password=ob.getProperty("login.valid.password");
	
	GetDriverInstance("chrome");
		gotoUrl(url);
		
		Thread.sleep(5000);
		WebElement email=driver.findElement(By.name("username"));
		enterText(email,username,"usernameEle");
		Thread.sleep(5000);
		WebElement pwd=driver.findElement(By.id("password"));
		enterText(pwd,password,"passwordEle");		
		

	}
public static void clicklogin() {
	WebElement login=driver.findElement(By.id("Login"));
	login.click();
	System.out.println("login successfully");
	
}

}
