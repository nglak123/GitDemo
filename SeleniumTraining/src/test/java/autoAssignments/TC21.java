package autoAssignments;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC21 extends Login{
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
		loginpage();
		clicklogin();
		Thread.sleep(5000);
		leadstab();
		leadsdrp();

	}
	
public static void leadstab() throws InterruptedException {
	WebElement leads=driver.findElement(By.xpath("//a[normalize-space()='Leads']"));
	leads.click();
}

	public static void leadsdrp() throws InterruptedException {
	Thread.sleep(6000);
	driver.findElement(By.id("tryLexDialogX")).click();
	
	WebElement leadsdrp=driver.findElement(By.xpath("//select[@id='fcf']"));
    Select sel=new Select(leadsdrp);
    List<WebElement> drplist=sel.getOptions();
	Iterator<WebElement> it=drplist.iterator();
	while(it.hasNext()) {
	
	System.out.println(it.next().getText());
		
	}
	System.out.println("test case 21 is passed");
}
}

