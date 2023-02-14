package autoAssignments;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC27 extends TC25{

	public static void main(String[] args) throws InterruptedException, IOException {
		
		loginpage();
		clicklogin();
		Thread.sleep(5000);
		contacts();
		Thread.sleep(5000);
		contactsdrp();
		

	}
		public static void contactsdrp() throws InterruptedException {
	
		Thread.sleep(5000);
		driver.findElement(By.id("tryLexDialogX")).click();
		Thread.sleep(5000);
		
		WebElement drp=driver.findElement(By.xpath("//select[@id='hotlist_mode']"));
		dropdown(drp, "Recently Created");
		
	   System.out.println("Testcase27 is passed");

	}

}
