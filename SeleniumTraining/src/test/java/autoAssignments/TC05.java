package autoAssignments;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC05 extends Login {
		public static void main(String[] args) throws IOException, InterruptedException {

		loginpage();
		clicklogin();
        usernamedropdown();
        System.out.println("Testcase 5 is passed");

	}

	public static void usernamedropdown() {
		WebElement user=driver.findElement(By.xpath("//span[@id='userNavLabel']"));
		waitForElement(40,user);
        user.click();
	
			
	}

	}
