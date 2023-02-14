package autoAssignments;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC04 extends Login{

	public static void main(String[] args) throws IOException, InterruptedException {
		
		loginpage();
		forgotpwd();
	username();
	}

	
		public static void forgotpwd() {
		//a[@id='forgot_password_link']
		
		WebElement fpwd=driver.findElement(By.id("forgot_password_link"));
		fpwd.click();
		
		
	}
	public static void username() {
		//input[@id='un']
		
		WebElement user=driver.findElement(By.id("un"));
		user.sendKeys("octsel22@tekarch.com");
		
		//input[@id='continue']
		
		
		WebElement cont=driver.findElement(By.id("continue"));
		cont.click();
		
		
		WebElement actual=driver.findElement(By.xpath("//p[contains(text(),'We’ve sent you an email with a link to finish rese')]"));
		String act=enterText(actual, "textmsg");
String exp="We’ve sent you an email with a link to finish resetting your password.";
		validation(act, exp, 4);
		
	}
	

}
