package autoAssignments;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC24 extends TC21{
	

	public static void main(String[] args) throws InterruptedException, IOException {
		
		loginpage();
		clicklogin();
		Thread.sleep(5000);
		leadstab();
		Thread.sleep(5000);
		leadlastname();
		

	}
	
		public static void leadlastname() throws InterruptedException {
		
		Thread.sleep(5000);
		driver.findElement(By.id("tryLexDialogX")).click();
		
		WebElement newBtn=driver.findElement(By.xpath("//input[@title='New']"));
		newBtn.click();
		
		Thread.sleep(5000);
		WebElement Firstname=driver.findElement(By.xpath("(//input[@id='name_firstlea2'])[1]"));
		enterText(Firstname, "laxmi", "firstname");
		
		WebElement lastname=driver.findElement(By.xpath("(//input[@id='name_lastlea2'])[1]"));
		enterText(lastname, "ABCD", "lastname");
		
		WebElement company=driver.findElement(By.xpath("(//input[@id='lea3'])[1]"));
		enterText(company, "ABCD", "company name");
		
		Thread.sleep(5000);

		WebElement leadstatus=driver.findElement(By.xpath("(//select[@id='lea13'])[1]"));
		dropdown(leadstatus, "Working - Contacted");
		
		Thread.sleep(5000);

		WebElement save=driver.findElement(By.xpath("//td[@id='bottomButtonRow']//input[@title='Save']"));
		save.click();
		
		Thread.sleep(5000);
		
		
		WebElement leaddetail=driver.findElement(By.xpath("//h2[normalize-space()='Lead Detail']\r\n"
				+ ""));
		String actual=enterText(leaddetail, "leaddetail");
		String exp="Lead Detail";
		validation(actual, exp, 24);
	
	}

}
