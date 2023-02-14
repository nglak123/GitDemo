package autoAssignments;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC33 extends Login {
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
		loginpage();
		clicklogin();
		Thread.sleep(5000);
		hometab();
		Thread.sleep(5000);
		homepage();
		validdata();
		

	}
	
	
	public static void hometab() throws InterruptedException {
		WebElement homeTab=driver.findElement(By.xpath("//a[normalize-space()='Home']"));
		homeTab.click();
	}
	public static void homepage() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.id("tryLexDialogX")).click();
		Thread.sleep(5000);
		WebElement flname=driver.findElement(By.xpath("//a[@href='/_ui/core/userprofile/UserProfilePage'][normalize-space()='laxmi New']"));
		flname.click();
		Thread.sleep(5000);
	}
	public static void validdata() {

		WebElement act=driver.findElement(By.xpath("(//span[@id='tailBreadcrumbNode'])[1]"));
		String actual=enterText(act, "profile name");
		System.out.println(actual);
		String exp="laxmi New ";
		validation(actual, exp, 33);

	}

}
