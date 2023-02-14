package autoAssignments;

import java.io.IOException;

import org.openqa.selenium.By;


import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;


public class TC06 extends TC05 {
	
	public static void main(String[] args) throws InterruptedException, IOException {

		loginpage();
		clicklogin();

		usernamedropdown();
		
		clickMyProfile();
		Thread.sleep(7000);
		clickedit();
		Thread.sleep(5000);
		about();
		//postlink();
		//clickfile();
		uploadphoto();

			}

				public static void clickMyProfile() {
				WebElement profile=driver.findElement(By.xpath("//a[text()='My Profile']"));

				profile.click();
				
			}
			public static void clickedit() throws InterruptedException {
				
				WebElement edit=driver.findElement(By.xpath("//a[@class='contactInfoLaunch editLink']//img[@title='Edit Profile']"));
				Thread.sleep(5000);
				edit.click();
				
			}
	public static void about() throws InterruptedException {
				//a[contains(text(),'About')]
				Thread.sleep(5000);
				WebElement iframe = driver.findElement(By.id("contactInfoContentId"));
				driver.switchTo().frame(iframe);
				Thread.sleep(5000);
			Actions act=new Actions(driver);
				
			WebElement abt=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/a[1]"));
		
			act.moveToElement(abt).click().build().perform();
			
			WebElement lname=driver.findElement(By.xpath("//input[@id='lastName']"));
			lname.click();
			lname.clear();
			lname.sendKeys("New");
			WebElement saveall=driver.findElement(By.xpath("//input[@value='Save All']"));
			saveall.click();
			Thread.sleep(5000);
			}
	public static void postlink() throws InterruptedException {
			WebElement post=driver.findElement(By.xpath("//span[normalize-space()='Post']"));
			post.click();
			Thread.sleep(5000);
			WebElement postframe=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/iframe[1]"));
			driver.switchTo().frame(postframe);
			
			Actions act1=new Actions(driver);
			WebElement pp=driver.findElement(By.xpath("/html[1]/body[1]"));
			act1.moveToElement(pp).click().build().perform();
			pp.sendKeys("testing post link");
			driver.switchTo().defaultContent();		
			WebElement share=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/span[1]/input[1]"));
			
			share.click();
			
			}
	public static void clickfile() throws InterruptedException {
		WebElement clikfile=driver.findElement(By.xpath("//span[normalize-space()='File']"));
		clikfile.click();
		WebElement uploadfile=driver.findElement(By.xpath("//a[@id='chatterUploadFileAction']"));
		uploadfile.click();
		Thread.sleep(5000);
		WebElement choosefile=driver.findElement(By.xpath("//input[@id='chatterFile']"));
		//choosefile.click();
		Thread.sleep(5000);
		choosefile.sendKeys("C:\\New folder\\rose.jpg");
		WebElement upload=driver.findElement(By.xpath("//input[@id='publishersharebutton']"));
		upload.click();
			}
	private static void uploadphoto() throws InterruptedException {
		Actions action=new Actions(driver);
		WebElement addphoto=driver.findElement(By.xpath("//span[@class='profileImage chatter-avatarFull chatter-avatar']//img[@title='laxmi New']"));
		action.moveToElement(addphoto).click().build().perform();
		Thread.sleep(5000);
		WebElement update=driver.findElement(By.xpath("//a[@id='uploadLink']"));
		update.click();
		WebElement iframe=driver.findElement(By.xpath("//iframe[@id='uploadPhotoContentId']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(5000);
		WebElement choosefile=driver.findElement(By.xpath("//input[@id='j_id0:uploadFileForm:uploadInputFile']"));
		choosefile.sendKeys("C:\\New folder\\rose.jpg");
		Thread.sleep(9000);
		WebElement save=driver.findElement(By.id("j_id0:uploadFileForm:uploadBtn"));
		save.click();
		Thread.sleep(5000);
		WebElement finalSave=driver.findElement(By.xpath("/html[1]/body[1]/span[1]/form[1]/div[2]/input[1]"));
		finalSave.click();
		System.out.println("photo uploaded successfully");
		System.out.println("TestCase6 is passed");
		
	}
			}


