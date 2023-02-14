package autoAssignments;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC08 extends TC05{
	

	public static void main(String[] args) throws InterruptedException, IOException {
	
		loginpage();
		clicklogin();

	Thread.sleep(4000);
	usernamedropdown();
	devconsole();	
	}

		
		public static void devconsole() {
			WebElement clickdevconsole=driver.findElement(By.xpath("//a[@class='debugLogLink menuButtonMenuLink']"));
			clickdevconsole.click();
			driver.quit();
			System.out.println("TestCase 8 is passed");
		}
	
	//class="debugLogLink menuButtonMenuLink"

}
