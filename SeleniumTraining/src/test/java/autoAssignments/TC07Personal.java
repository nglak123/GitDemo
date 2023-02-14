package autoAssignments;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC07Personal extends TC07Display{
	
	public static void main(String[] args) throws InterruptedException, IOException {
	
		loginpage();
		clicklogin();
        usernamedropdown();
	Thread.sleep(4000);

	mySettings();

	selpersonal();
	
		}

		public static void selpersonal() {
		WebElement personal=driver.findElement(By.id("PersonalInfo_font"));
		personal.click();
		//span[@id='LoginHistory_font']
		WebElement display=driver.findElement(By.id("LoginHistory_font"));
		display.click();
		//a[@href='/servlet/servlet.LoginHistory?id=005Dn000000noaE']
		
		WebElement clicklink=driver.findElement(By.xpath("//a[@href='/servlet/servlet.LoginHistory?id=005Dn000000noaE']"));
		clicklink.click();
	}

}
