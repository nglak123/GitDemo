package autoAssignments;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC07Email extends TC07Display {

	public static void main(String[] args) throws InterruptedException, IOException {
	
		loginpage();
		clicklogin();
        usernamedropdown();
	Thread.sleep(4000);

	mySettings();
	
	email();
		}

			public static void email() {
			
			WebElement selectEmail=driver.findElement(By.xpath("//span[@id='EmailSetup_font']"));
			selectEmail.click();
			
			WebElement selectEmailSettings=driver.findElement(By.xpath("//span[@id='EmailSettings_font']"));
			selectEmailSettings.click();
							
			WebElement enterEmail=driver.findElement(By.xpath("//input[@id='sender_email']"));
			enterText(enterEmail, "laxme31@gmail.com", "username");
			//input[@id='auto_bcc1']
			WebElement yesRadio=driver.findElement(By.xpath("//input[@id='auto_bcc1']"));
			radioBtn(yesRadio, "RadioBtn");
			//input[@name='save']
			
			WebElement clickSave=driver.findElement(By.xpath("//input[@name='save']"));
			clickSave.click();
			
		}
}
