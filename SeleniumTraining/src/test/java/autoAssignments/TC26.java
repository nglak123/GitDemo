package autoAssignments;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC26 extends TC25 {
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
		loginpage();
		clicklogin();
		Thread.sleep(5000);
		contacts();
		contactsnewview();
		

	}
	
	public static void contactsnewview() throws InterruptedException {

		Thread.sleep(6000);
		driver.findElement(By.id("tryLexDialogX")).click();
		Thread.sleep(5000);
		
		WebElement newView=driver.findElement(By.xpath("//a[normalize-space()='Create New View']"));
		newView.click();
		Thread.sleep(5000);
		//input[@id='fname']
		WebElement vName=driver.findElement(By.xpath("(//input[@id='fname'])[1]"));
		vName.sendKeys("myview");

		WebElement uniqueName=driver.findElement(By.xpath("//input[@id='devname']"));
		uniqueName.sendKeys("uniqueMyView3");

		WebElement save=driver.findElement(By.xpath("(//input[@title='Save'])[2]"));
		save.click();
		
		System.out.println("Testcase26 is passed");

	}
	}
