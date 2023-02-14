package autoAssignments;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC09 extends TC05{
		public static void main(String[] args) throws InterruptedException, IOException {
	
			loginpage();
			clicklogin();

	usernamedropdown();
	Thread.sleep(4000);
	clicklogout();
	System.out.println("Successfully logout");
	System.out.println("TC9 is passed");
}
}
