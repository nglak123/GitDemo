package autoAssignments;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC10  extends Login{
	
	public static void main(String[] args) throws IOException, InterruptedException  {
		
		loginpage();
		clicklogin();
		account();
		Thread.sleep(6000);	
		//driver.findElement(By.id("tryLexDialogX")).click();
		acctName();
		validdata();
		

	}
	
	public static void account() throws InterruptedException    {
		Thread.sleep(5000);
		WebElement accountTab=driver.findElement(By.xpath("//a[contains(text(),'Accounts')]"));
		accountTab.click();
		
	}
		public static void acctName() throws InterruptedException {
		WebElement clicknew=driver.findElement(By.xpath("//tbody/tr[1]/td[2]/input[1]"));
		clicknew.click();
		
		WebElement acctName=driver.findElement(By.xpath("(//input[@id='acc2'])[1]"));
		enterText(acctName, "vinivini", "accountname");
		Thread.sleep(5000);
		
		WebElement drpdown=driver.findElement(By.xpath("(//select[@id='acc6'])[1]"));
		dropdown(drpdown, "Technology Partner");
	
		Thread.sleep(5000);
		WebElement priority=driver.findElement(By.xpath("(//select[@id='00NDn000006wZB1'])[1]"));
		dropdown(priority, "High");
		
		driver.findElement(By.xpath("//td[@id='bottomButtonRow']//input[@title='Save']")).click();
				
			}
	public static void validdata() throws InterruptedException{
		WebElement actual=driver.findElement(By.xpath("//h2[normalize-space()='vinivini']"));
		String act=enterText(actual, "accountname");
		String exp="vinivini";
		validation(act, exp, 10);
	}

}
