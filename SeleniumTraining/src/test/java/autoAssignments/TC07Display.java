package autoAssignments;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC07Display extends TC07Calender {
	
	public static void main(String[] args) throws InterruptedException, IOException {

		loginpage();
		clicklogin();
        usernamedropdown();
	Thread.sleep(4000);
	mySettings();
		//selpersonal();
		displayandlayout();
		check();
			}

				public static void displayandlayout() throws InterruptedException {
				
				WebElement dis=driver.findElement(By.xpath("//span[@id='DisplayAndLayout_font']"));
				dis.click();
				
				WebElement tab=driver.findElement(By.id("CustomizeTabs_font"));
				tab.click();
				
				WebElement alloptions=driver.findElement(By.xpath("//select[@id='p4']"));
				dropdown(alloptions, "Salesforce Chatter");
                WebElement alltabs=driver.findElement(By.xpath("//select[@id='duel_select_0']"));
				dropdown(alltabs, "Reports");
				
				WebElement add=driver.findElement(By.xpath("//img[@title='Add']"));
				add.click();
				Thread.sleep(4000);
				WebElement save=driver.findElement(By.xpath("//input[@title='Save']"));
				save.click();
				
			}
			
			public static void check() throws InterruptedException  {
				WebElement content=driver.findElement(By.xpath("//span[@id='tsidLabel']"));
				content.click();
								
				WebElement selectcontent=driver.findElement(By.xpath("//a[@href='/home/home.jsp?tsid=02uDn000001CKcH']"));
				
				selectcontent.click();
				
				Thread.sleep(6000);
				WebElement reportstab=driver.findElement(By.xpath("//a[@title='Reports Tab']"));
				//reportstab.click();
				String actvalue=enterText(reportstab, "Reports");				
				String expvalue="Reports";
				validation(actvalue, expvalue, 7);
			}
			
			
}
