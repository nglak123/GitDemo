package autoAssignments;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC22 extends TC21 {


	public static void main(String[] args) throws InterruptedException, IOException {
		
		loginpage();
		clicklogin();
		Thread.sleep(5000);
		leadstab();
		leadsdrpdown();
		clickMyProfile();
		clicklogout();
		
		Thread.sleep(5000);
		clickGoBtn();
		
			}
	
public static void leadsdrpdown() throws InterruptedException {
	
	Thread.sleep(6000);
	driver.findElement(By.id("tryLexDialogX")).click();
	
	WebElement leadsdrp=driver.findElement(By.xpath("//select[@id='fcf']"));
    enterText(leadsdrp, "Today's Leads");
    Thread.sleep(9000);
    
    WebElement drp=driver.findElement(By.xpath("//select[@id='hotlist_mode']"));
    enterText(drp, "My Unread Leads");
    Thread.sleep(5000);
    
	}
public static void clickMyProfile() {
	WebElement clickprofile=driver.findElement(By.xpath("//span[@id='userNavLabel']"));

	clickprofile.click();

	
}

public static void clickGoBtn() throws InterruptedException, IOException {
	WebElement email=driver.findElement(By.name("username"));
	enterText(email,"octsel22@tekarch.com","usernameEle");
	Thread.sleep(5000);
	WebElement pwd=driver.findElement(By.id("password"));
	enterText(pwd,"Sagar1234","passwordElement");	
	clicklogin();
	Thread.sleep(5000);
	leadstab();
Thread.sleep(5000);
		WebElement gobtn=driver.findElement(By.xpath("//input[@title='Go!']"));

	gobtn.click();
	System.out.println("TC22 is passed");

}
}
