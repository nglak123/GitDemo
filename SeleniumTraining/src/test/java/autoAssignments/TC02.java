package autoAssignments;

import java.io.IOException;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

public class TC02 extends Login {
		public static void main(String[] args) throws IOException, InterruptedException {
		
		loginpage();
		clicklogin();
		
	WebElement homeTab=driver.findElement(By.xpath("//a[@title='Home Tab']"));
	waitForElement(40,homeTab);
	String act=getTextFrmElement(homeTab, "home page");
	String exp="HOME";
	validation(act,exp,2);

	}
}
