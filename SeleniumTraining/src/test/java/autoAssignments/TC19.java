package autoAssignments;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC19 extends TC15{
		public static void main(String[] args) throws InterruptedException, IOException {
		
			loginpage();
			clicklogin();
			Thread.sleep(5000);
			clickopportunity();
		Thread.sleep(5000);
		quaterlysummary();
			}
	
	public static void quaterlysummary() throws InterruptedException {
		
		Thread.sleep(5000);
		driver.findElement(By.id("tryLexDialogX")).click();
		Thread.sleep(5000);
		
		WebElement interval=driver.findElement(By.xpath("(//select[@id='quarter_q'])[1]"));
		dropdown(interval, "Next FQ");
		Thread.sleep(4000);
		
		WebElement runReport=driver.findElement(By.xpath("(//input[@title='Run Report'])[1]"));
		runReport.click();
		
		WebElement actual=driver.findElement(By.xpath("//h1[normalize-space()='Opportunity Report']"));
		String act=enterText(actual, "oppo report");
		System.out.println(act);
		String exp="Opportunity Report";

validation(act, exp, 19);
		
	}

}
