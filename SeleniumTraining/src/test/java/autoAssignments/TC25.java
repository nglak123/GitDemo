package autoAssignments;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC25 extends Login {
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
		loginpage();
		clicklogin();
		Thread.sleep(5000);
		contacts();
		contactsnew();

	}
	
	
	public static void contacts() throws InterruptedException {
		WebElement contactTab=driver.findElement(By.xpath("//a[normalize-space()='Contacts']"));
		contactTab.click();}
	
	public static void contactsnew() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.id("tryLexDialogX")).click();
		
		WebElement newBtn=driver.findElement(By.xpath("//input[@title='New']"));
		newBtn.click();
		
		Thread.sleep(5000);
				
		WebElement lastname=driver.findElement(By.xpath("(//input[@id='name_lastcon2'])[1]"));
		lastname.sendKeys("dev");
		
		WebElement company=driver.findElement(By.xpath("(//input[@id='con4'])[1]"));
		company.click();
		
		Thread.sleep(5000);
				
		WebElement savebtn=driver.findElement(By.xpath("//td[@id='bottomButtonRow']//input[@title='Save']\r\n"
				+ ""));
		savebtn.click();
		Thread.sleep(5000);
		WebElement actual=driver.findElement(By.xpath("//h2[normalize-space()='dev']"));
		String act=enterText(actual, "text");
		String exp="dev";
		validation(act, exp, 25);
		}
}
