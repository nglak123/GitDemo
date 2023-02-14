package autoAssignments;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC12 extends TC10{

	public static void main(String[] args) throws InterruptedException, IOException {
		
		loginpage();
		clicklogin();
		account();
		editview();
		

	}
	
	public static void editview() throws InterruptedException {
		Thread.sleep(6000);	
		driver.findElement(By.id("tryLexDialogX")).click();
		WebElement view=driver.findElement(By.xpath("//select[@id='fcf']"));
		dropdown(view, "vini view1");
		Thread.sleep(2000);	
		
		driver.findElement(By.xpath("//tbody/tr[1]/td[2]/div[2]/form[1]/div[1]/span[1]/span[1]/input[1]")).click();
		Thread.sleep(5000);
		WebElement edit=driver.findElement(By.xpath("(//a[contains(text(),'Edit')])[1]"));
		edit.click();
		Thread.sleep(5000);
		
		WebElement editviewname=driver.findElement(By.xpath("//input[@id='fname']"));
		enterText(editviewname, "viniviewnewname", "editviewname");
		Thread.sleep(5000);
		
		WebElement field=driver.findElement(By.xpath("(//select[@id='fcol1'])[1]"));
		dropdown(field, "Account Name");
		Thread.sleep(5000);
		
		WebElement operator=driver.findElement(By.xpath("(//select[@id='fop1'])[1]"));
		dropdown(operator, "contains");
		Thread.sleep(5000);
		
		WebElement value=driver.findElement(By.xpath("(//input[@id='fval1'])[1]"));
		value.sendKeys("a");
		Thread.sleep(5000);
		
		WebElement save=driver.findElement(By.xpath("(//input[@title='Save'])[2]"));
		save.click();
		System.out.println("Testcase 12 is passed");

	}

}
