package autoAssignments;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC29 extends TC25{
	

	public static void main(String[] args) throws InterruptedException, IOException {
		
		loginpage();
		clicklogin();
		Thread.sleep(5000);
		contacts();
		Thread.sleep(5000);
		contactsRecent();
		

	}
	
	public static void contactsRecent() throws InterruptedException {
		
		Thread.sleep(5000);
		driver.findElement(By.id("tryLexDialogX")).click();
		Thread.sleep(5000);
		
		WebElement recent=driver.findElement(By.xpath("//a[contains(text(),'United Oil & Gas Corp.')]"));
		recent.click();
		Thread.sleep(5000);
		
		WebElement test=driver.findElement(By.xpath("//h2[normalize-space()='United Oil & Gas Corp.']"));
		String actual=enterText(test, "text");
		String exp="United Oil & Gas Corp.";     
		validation(actual, exp, 29);

	}

}
