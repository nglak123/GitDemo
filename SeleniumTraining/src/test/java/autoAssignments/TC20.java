package autoAssignments;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC20 extends Login{
	

	public static void main(String[] args) throws InterruptedException, IOException {
		
		loginpage();
		clicklogin();
		Thread.sleep(5000);
		leadstab();
		validdata();

	}
	
	public static void leadstab() throws InterruptedException {
		WebElement leads=driver.findElement(By.xpath("//a[normalize-space()='Leads']"));
		leads.click();
		Thread.sleep(5000);
		driver.findElement(By.id("tryLexDialogX")).click();
	}
	public static void validdata() {
	
		WebElement actual=driver.findElement(By.xpath("//h1[@class='pageType']"));
		String act=enterText(actual, "leads");
		System.out.println(act);
		String exp="Leads";
		validation(act, exp, 20);

	}

}
