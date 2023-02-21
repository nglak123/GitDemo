package autoAssignments;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC18 extends TC15{
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
		loginpage();
		clicklogin();
		Thread.sleep(5000);
		clickopportunity();
		Thread.sleep(5000);
		oppostucklink();
		}
	
	
	public static void oppostucklink() throws InterruptedException {
		
		Thread.sleep(5000);
		driver.findElement(By.id("tryLexDialogX")).click();
		Thread.sleep(3000);
		WebElement oppostucklink=driver.findElement(By.xpath("//a[normalize-space()='Stuck Opportunities']"));
		oppostucklink.click();
		Thread.sleep(4000);
		WebElement actual=driver.findElement(By.xpath("//h1[normalize-space()='Stuck Opportunities']"));
		String act=actual.getText();
		enterText(actual, "stuck opportunities");
		System.out.println(act);
		String exp="Stuck Opportunities";
		validation(act, exp, 18);
		}
}
