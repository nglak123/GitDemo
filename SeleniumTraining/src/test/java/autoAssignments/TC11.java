package autoAssignments;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC11 extends TC10{
	
	public static void main(String[] args) throws IOException, InterruptedException  {
		loginpage();
		clicklogin();
		account();
		accountView();
		
	}
		public static void accountView() throws InterruptedException    {
		
		WebElement viewpath=driver.findElement(By.xpath("//a[normalize-space()='Create New View']"));
		viewpath.click();
		WebElement viewname=driver.findElement(By.xpath("//input[@id='fname']"));
		enterText(viewname, "vini view1", "viewname");
		WebElement uniqueview=driver.findElement(By.xpath("//input[@id='devname']"));
		enterText(uniqueview, "uniquevini11", "uniqueview");
		WebElement save=driver.findElement(By.xpath("(//input[@title='Save'])[2]"));
		save.click();
		System.out.println("Testcase11 is passed");
		
	}

}
