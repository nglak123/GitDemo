package autoAssignments;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC16 extends TC15{
	

	public static void main(String[] args) throws InterruptedException, IOException {
		
		loginpage();
		clicklogin();
		Thread.sleep(5000);
		clickopportunity();
		Thread.sleep(5000);
		opportunitynew();
		

	}
	
	
	
	public static void opportunitynew() throws InterruptedException {
		
		Thread.sleep(5000);
		driver.findElement(By.id("tryLexDialogX")).click();
		WebElement newbtn=driver.findElement(By.xpath("//input[@title='New']"));
		newbtn.click();
		Thread.sleep(5000);
		WebElement opponame=driver.findElement(By.xpath("(//input[@id='opp3'])[1]"));
		enterText(opponame, "oppo", "opponame");
		
		Thread.sleep(2000);
		WebElement closedate=driver.findElement(By.xpath("(//input[@id='opp9'])[1]"));
		closedate.click();
		Thread.sleep(2000);
		
		WebElement seldate=driver.findElement(By.xpath("//a[normalize-space()='Today']"));
		seldate.click();
		
		WebElement stage=driver.findElement(By.xpath("(//select[@id='opp11'])[1]"));
		dropdown(stage, "Closed Won");
		
		Thread.sleep(2000);
		
		WebElement save=driver.findElement(By.xpath("(//input[@title='Save'])[2]"));
		save.click();
	    Thread.sleep(4000);
	    
		WebElement actual=driver.findElement(By.xpath("(//h2[normalize-space()='oppo'])[1]"));
		String act=enterText(actual, "element");
		System.out.println(act);
		String exp="oppo";
		validation(act, exp, 16);
		
		
	}

}
