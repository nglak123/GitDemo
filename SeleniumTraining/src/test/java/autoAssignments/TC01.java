package autoAssignments;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC01 extends Login{
		public static void main(String[] args) throws IOException {
		loginNegTC();
		clicklogin();
		validdata();
			}
	public static void loginNegTC() throws IOException {
		String curdir=System.getProperty("user.dir");
		FileInputStream fis=new FileInputStream(new File(curdir+"/src/test/resources/testData.properties"));
		Properties ob=new Properties();
		ob.load(fis);
		String url=ob.getProperty("url");
		String username=ob.getProperty("login.valid.userid");
	    //String password=ob.getProperty("login.invalid.password");
		
		GetDriverInstance("chrome");
			gotoUrl(url);
			
			WebElement email=driver.findElement(By.name("username"));
			enterText(email,username,"usernameEle");
			waitForElement(40,email);
			WebElement pwd=driver.findElement(By.id("password"));
			pwd.clear();		
			waitForElement(40,pwd);
			
		}
	public static void validdata() {
		WebElement errormsg=driver.findElement(By.xpath("//div[@id='error']"));
		waitForElement(40,errormsg);
		String act=enterText(errormsg,"ErrorMessage");
		String exp="Please enter your password.";
		validation(act, exp, 1);
		
	}
	

	

}
