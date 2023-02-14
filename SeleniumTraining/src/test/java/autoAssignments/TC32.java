package autoAssignments;

import java.io.IOException;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;


public class TC32 extends TC25{
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
		loginpage();
		clicklogin();
		Thread.sleep(5000);
		contacts();
		Thread.sleep(5000);
		contactsSave();
			}
	
		public static void contactsSave() throws InterruptedException {
		
		Thread.sleep(5000);
		driver.findElement(By.id("tryLexDialogX")).click();
		Thread.sleep(5000);
		
		WebElement drp=driver.findElement(By.xpath("//select[@id='fcf']"));
		dropdown(drp, "My Contacts");
		
        Thread.sleep(5000);
		WebElement newBtn=driver.findElement(By.xpath("//input[@title='New']"));
		newBtn.click();
	    Thread.sleep(5000);
	    WebElement lname=driver.findElement(By.id("name_lastcon2"));
		lname.sendKeys("ind");
		Thread.sleep(5000);
		WebElement acct=driver.findElement(By.id("con4"));
		acct.sendKeys("vini");
		Thread.sleep(5000);
		WebElement saveNew=driver.findElement(By.xpath("//td[@id='topButtonRow']//input[@title='Save & New']"));
		saveNew.click();	
		
		WebElement act=driver.findElement(By.xpath("//h2[normalize-space()='New Contact']"));
		String actual=enterText(act, "Text");
		String exp="New Contact";
		validation(actual, exp, 32);
	}

}
