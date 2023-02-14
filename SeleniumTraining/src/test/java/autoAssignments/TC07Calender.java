package autoAssignments;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC07Calender extends TC05 {

	public static void main(String[] args) throws InterruptedException, IOException {
	
		loginpage();
		clicklogin();
        usernamedropdown();
	Thread.sleep(4000);
	mySettings();
	calender();
	
		}

			public static void mySettings() {
			
			WebElement mySet=driver.findElement(By.xpath("//a[@title='My Settings']"));
			mySet.click();
			
		}
		public static void calender() {
			WebElement selCal=driver.findElement(By.xpath("//span[@id='CalendarAndReminders_font']"));
			selCal.click();
			
			WebElement selReminder=driver.findElement(By.xpath("//span[@id='Reminders_font']"));
			selReminder.click();
			
		
			WebElement selReminderbutton=driver.findElement(By.xpath("//input[@id='testbtn']"));
			selReminderbutton.click();
			System.out.println("Testcase7 is completed");
			
		}

}
