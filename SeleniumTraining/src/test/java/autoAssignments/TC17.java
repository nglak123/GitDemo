package autoAssignments;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC17 extends TC15{

	public static void main(String[] args) throws InterruptedException, IOException {
		
		loginpage();
		clicklogin();
		Thread.sleep(5000);
		clickopportunity();
		Thread.sleep(5000);
		opportunitylink();
			}
	
		public static void opportunitylink() throws InterruptedException {

		Thread.sleep(5000);
		driver.findElement(By.id("tryLexDialogX")).click();
		Thread.sleep(3000);
		WebElement link=driver.findElement(By.xpath("//a[normalize-space()='Opportunity Pipeline']"));
		link.click();
		
		Thread.sleep(4000);
		WebElement actual=driver.findElement(By.xpath("//h1[normalize-space()='Opportunity Pipeline']"));
		String act=enterText(actual, "actualmsg");
		
		String exp="Opportunity Pipeline";
		validation(act, exp, 17);
	}

}
