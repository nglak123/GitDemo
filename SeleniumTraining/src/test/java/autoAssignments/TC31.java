package autoAssignments;

import java.io.IOException;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

public class TC31 extends TC25{
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
		loginpage();
		clicklogin();
		Thread.sleep(5000);
		contacts();
		Thread.sleep(5000);
		contactshome();
		
	}
	
		public static void contactshome() throws InterruptedException {
		
		Thread.sleep(5000);
		driver.findElement(By.id("tryLexDialogX")).click();
		Thread.sleep(5000);
		
		WebElement clickview=driver.findElement(By.xpath("//a[normalize-space()='Create New View']"));
		clickview.click();
		Thread.sleep(5000);
		WebElement viewname=driver.findElement(By.xpath("//input[@id='fname']"));
		viewname.sendKeys("ABCD");
		WebElement uniqueviewname=driver.findElement(By.xpath("//input[@id='devname']"));
		uniqueviewname.sendKeys("EFGH");	
		Thread.sleep(5000);
		WebElement cancel=driver.findElement(By.xpath("(//input[@title='Cancel'])[1]"));
		cancel.click();
		Thread.sleep(5000);

		WebElement contactsHome=driver.findElement(By.xpath("//h2[normalize-space()='Home']"));
		
		String actual=enterText(contactsHome, "contact");
		String exp="HOME";
		validation(actual, exp, 31);
	}

}
