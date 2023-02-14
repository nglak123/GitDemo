package autoAssignments;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC35 extends Login {

	public static void main(String[] args) throws IOException, InterruptedException {
		loginpage();
		clicklogin();
		Thread.sleep(5000);
		alltabs();
		Thread.sleep(5000);
		custmytabs();
		clickReports();
		Thread.sleep(5000);
		clickMyProfile();
		Thread.sleep(5000);
		clicklogout();
		Thread.sleep(5000);
		loginpage();
		clicklogin();
		validdata();

	}
	public static void alltabs() {
		WebElement alltabs=driver.findElement(By.xpath("(//img[@title='All Tabs'])[1]"));
		alltabs.click();
	}
	public static void custmytabs() throws InterruptedException {
		WebElement custtabs=driver.findElement(By.xpath("//input[@title='Customize My Tabs']"));
		custtabs.click();
		Thread.sleep(5000);
	}
	public static void clickReports() throws InterruptedException {
		WebElement reports=driver.findElement(By.xpath("//option[@value='report']"));
		reports.click();
		Thread.sleep(5000);
		//img[@title='Remove']
		WebElement remove=driver.findElement(By.xpath("//img[@title='Remove']"));
		remove.click();
		Thread.sleep(5000);
		WebElement save=driver.findElement(By.xpath("//input[@title='Save']"));
		save.click();
	}
	public static void clickMyProfile() {
		WebElement profile=driver.findElement(By.xpath("//span[@id='userNavLabel']"));
		
		profile.click();
		
	}
	public static void validdata() {
	WebElement homeTab=driver.findElement(By.xpath("//a[@title='Home Tab']"));
	waitForElement(40,homeTab);
	String act=getTextFrmElement(homeTab, "home page");
	String exp="HOME";
	validation(act,exp,35);
	
	}
}
