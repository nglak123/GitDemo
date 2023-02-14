package autoAssignments;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class TC03 extends Login {
	public static void main(String[] args) throws InterruptedException, IOException  {
		loginpage();
		rememberMe();
		clicklogin();
				usernamedropdown();
                clicklogout();
                Thread.sleep(6000);
            WebElement username=driver.findElement(By.cssSelector("#idcard-identity"));
            waitForElement(40,username);
            String act=enterText(username, "username");
            String exp="octsel22@tekarch.com";
            validation(act, exp, 3);
            


	}
	
	public static void usernamedropdown() throws InterruptedException {
		WebElement user=driver.findElement(By.xpath("//span[@id='userNavLabel']"));
		waitForElement(40,user);
        user.click();
        
			}
	

	public static void rememberMe() throws IOException, InterruptedException  {
		Thread.sleep(5000);
		WebElement remember1=driver.findElement(By.xpath("//label[normalize-space()='Remember me']"));
		waitForElement(40,remember1);
		checkBox(remember1, "Remember Me");
		//remember1.click();		
		
	}
	

}
