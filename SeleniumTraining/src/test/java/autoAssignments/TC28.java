package autoAssignments;

import java.io.IOException;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

public class TC28 extends TC25 {
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
		loginpage();
		clicklogin();
		Thread.sleep(5000);
		contacts();
		Thread.sleep(5000);
		mycontacts();
			}
		public static void mycontacts() throws InterruptedException {
		
		Thread.sleep(5000);
		driver.findElement(By.id("tryLexDialogX")).click();
		Thread.sleep(5000);
		
		WebElement drp=driver.findElement(By.xpath("//select[@id='fcf']"));
		dropdown(drp, "My Contacts");
		
	   System.out.println("Testcase28 is passed");

	}

}
