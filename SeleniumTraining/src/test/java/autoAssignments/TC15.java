package autoAssignments;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC15 extends Login{
	

	public static void main(String[] args) throws InterruptedException, IOException {
		
		loginpage();
		clicklogin();
		Thread.sleep(5000);
		clickopportunity();
		opportunity();
		

	}
	
	public static void clickopportunity() throws InterruptedException {
		WebElement oppo=driver.findElement(By.xpath("(//a[normalize-space()='Opportunities'])[1]"));
		oppo.click();
		
	}
	public static void opportunity() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.id("tryLexDialogX")).click();
		WebElement drp=driver.findElement(By.xpath("//select[@id='fcf']"));
		Select sel=new Select(drp);
		List<WebElement> drplist=sel.getOptions();
		Iterator<WebElement> it=drplist.iterator();
		while(it.hasNext()) {
		
		System.out.println(it.next().getText());
			
		}
		System.out.println("Test case 15 is passed");
		
	}
	}


