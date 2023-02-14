package autoAssignments;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC34 extends TC06{

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		loginpage();
		clicklogin();
		Thread.sleep(5000);
		hometab();
		Thread.sleep(5000);
		homepage();
		clickedit();
		Thread.sleep(5000);
		about();
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
		System.out.println("TC34 is passed");
	}
	

}
