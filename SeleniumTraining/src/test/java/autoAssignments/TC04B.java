package autoAssignments;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC04B extends TC01 {
	

	public static void main(String[] args) throws IOException{
		loginNegTC();
		WebElement password=driver.findElement(By.id("password"));
		waitForElement(20, password);
		password.sendKeys("1234");
		clicklogin();
		validate();

	}

		public static void validate() {
		//div[@id='error']
		WebElement err=driver.findElement(By.id("error"));
		String Experr = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		enterText(err, "errormsg");
		validation(Experr, Experr, 4);

		
	}

}
