package autoAssignments;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC13 extends TC10 {
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
		loginpage();
		clicklogin();
		account();
		//acctName();
		merge();
		

	}
		public static void merge() throws InterruptedException {
		Thread.sleep(9000);	
		driver.findElement(By.id("tryLexDialogX")).click();
        WebElement mergeAcc=driver.findElement(By.xpath("//a[normalize-space()='Merge Accounts']"));
        mergeAcc.click();
        
        WebElement textbox=driver.findElement(By.xpath("//input[@id='srch']"));
        enterText(textbox, "vee", "accountName");
        Thread.sleep(4000);
        
        WebElement findAcc=driver.findElement(By.xpath("//div[@class='pbWizardBody']//input[2]"));
        findAcc.click();
        Thread.sleep(5000);
        		WebElement clickcheckbox=driver.findElement(By.id("cid0"));	
               checkBox(clickcheckbox, "checkbox");
                Thread.sleep(5000);
                WebElement clickcheckbox2=driver.findElement(By.id("cid1"));	
                checkBox(clickcheckbox2, "checkbox");
                 Thread.sleep(5000);
                
        WebElement nextbtn=driver.findElement(By.xpath("//div[@class='pbBottomButtons']//input[@title='Next']"));
        nextbtn.click();
        Thread.sleep(5000);
        
        WebElement mergebtn=driver.findElement(By.xpath("//div[@class='pbBottomButtons']//input[@title='Merge']"));
        mergebtn.click();
        Thread.sleep(5000);
Alert alert = driver.switchTo().alert();		
		
        String alertMessage= driver.switchTo().alert().getText();		
       		
        System.out.println(alertMessage);	
        Thread.sleep(5000);
        alert.accept();	
        String exp="These records will be merged into one record using the selected values. Merging can't be undone. Proceed with the record merge?";
		validation(alertMessage, exp, 13);
		}
       
	}
		