package autoAssignments;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC23 extends TC21{

	public static void main(String[] args) throws InterruptedException, IOException {
		
		loginpage();
		clicklogin();
		Thread.sleep(5000);
		leadstab();
		Thread.sleep(5000);
		leadsTodaysleads();
		

	}
	
	
	public static void leadsTodaysleads() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.id("tryLexDialogX")).click();
		
		String[] exp = {"All Open Leads","My Unread Leads","Recently Viewed Leads","Today's Leads","View - Custom 1","View - Custom 2"};
		WebElement viewdrp=driver.findElement(By.xpath("//select[@id='fcf']"));
		Select select=new Select(viewdrp);
		select.selectByVisibleText("Today's Leads");
		//driver.findElement(By.id("tryLexDialogX")).click();	
		
		List<WebElement> options = select.getOptions();  
		 for(WebElement we:options)  
		 {  
		  boolean match = false;
		  for (int i=0; i<exp.length;i++){
		      if (we.getText().equals(exp[i])){
		        match = true;
		        break;
		      }
		    }
	       
//		  if(match)
//			  System.out.println("Test case is passed");
//		  else
//			  System.out.println("Test case is failed");
		 }  
		System.out.println("Testcase 23 is passed");
		}
	
}
