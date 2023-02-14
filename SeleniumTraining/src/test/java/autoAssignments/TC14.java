package autoAssignments;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC14 extends Login{
	
	public static void main(String[] args) throws IOException, InterruptedException, AWTException {		
		loginpage();
		clicklogin();
		accReport();
		

	}
	
	public static void accReport() throws InterruptedException, AWTException {
		Thread.sleep(5000);
		WebElement accountTab=driver.findElement(By.xpath("//a[contains(text(),'Accounts')]"));
		accountTab.click();
		Thread.sleep(6000);	
		driver.findElement(By.id("tryLexDialogX")).click();
		Thread.sleep(6000);	
		
		WebElement activity=driver.findElement(By.xpath("//a[normalize-space()='Accounts with last activity > 30 days']"));
		activity.click();
		Thread.sleep(6000);
		
		WebElement fromdd=driver.findElement(By.xpath("(//img[@id='ext-gen152'])[1]"));
		fromdd.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//button[normalize-space()='Today'])[1]")).click();
		Thread.sleep(3000);
		WebElement test=driver.findElement(By.xpath("(//input[@id='ext-comp-1045'])[1]"));
		test.clear();
		Thread.sleep(3000);
		WebElement todd=driver.findElement(By.xpath("(//img[@id='ext-gen154'])[1]"));
		todd.click();
		Thread.sleep(6000);
		//driver.findElement(By.xpath("(//button[@id='ext-gen277'])[1]")).click();
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_SPACE);
		robot.keyRelease(KeyEvent.VK_SPACE);
		
		Thread.sleep(5000);
		WebElement save=driver.findElement(By.xpath("(//button[normalize-space()='Save'])[1]"));
		save.click();
		
		Thread.sleep(3000);
		//Alert alert=driver.switchTo().alert();
		WebElement Reportname=driver.findElement(By.xpath("(//input[@id='saveReportDlg_reportNameField'])[1]"));
		
		Actions act=new Actions(driver);
		act.moveToElement(Reportname).build().perform();
		Reportname.sendKeys("test report");
		
		WebElement unikreport=driver.findElement(By.xpath("//input[@id='saveReportDlg_DeveloperName']"));
		unikreport.sendKeys("uniquetest6");
		Thread.sleep(5000);
		WebElement saveandrun=driver.findElement(By.xpath("(//button[normalize-space()='Save and Run Report'])[1]"));
		saveandrun.click();
		//alert.dismiss();
		Thread.sleep(5000);
		WebElement act1=driver.findElement(By.xpath("//a[normalize-space()='Reports']"));
		String actual=act1.getText();
		String exp="Reports";
		validation(actual, exp, 14);
		
	}

}
