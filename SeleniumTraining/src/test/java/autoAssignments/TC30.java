package autoAssignments;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC30 extends TC25{
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
		loginpage();
		clicklogin();
		Thread.sleep(5000);
		contacts();
		Thread.sleep(5000);
		contactsview();
		}
	
	public static void contactsview() throws InterruptedException {
		
		Thread.sleep(5000);
		driver.findElement(By.id("tryLexDialogX")).click();
		Thread.sleep(5000);
		
		WebElement clickview=driver.findElement(By.xpath("//a[normalize-space()='Create New View']"));
		clickview.click();
		Thread.sleep(5000);
		
		WebElement uniqueviewname=driver.findElement(By.xpath("//input[@id='devname']"));
		uniqueviewname.sendKeys("EFGH");	
		Thread.sleep(5000);
		WebElement save=driver.findElement(By.xpath("//body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[2]/form[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/input[1]"));
		save.click();
		Thread.sleep(5000);

		WebElement err=driver.findElement(By.xpath("(//div[@class='errorMsg'])[1]"));
		String actual=enterText(err, "errormsg");
		System.out.println(actual);
		String exp="Error: You must enter a value";
		validation(actual, exp, 30);
		
	}
}
