package com.jan23.tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.jan23.base.basetest;
import com.jan23.utility.PropertiesUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login extends basetest {
@Test(priority=2)

public static void loginpage() throws IOException,InterruptedException { 
	
	logger.info("inside login method");
	extentreport.logTestInfo("inside salesforce method");
	PropertiesUtility propertiesUtility =new PropertiesUtility();
	propertiesUtility.loadFile("applicationDataProperties");
	String username=propertiesUtility.getPropertyValue("login.valid.userid");
   String password=propertiesUtility.getPropertyValue("login.valid.password");
			
		Thread.sleep(5000);
		WebElement email=driver.findElement(By.name("username"));
		enterText(email,username,"usernameEle");
		Thread.sleep(5000);
		WebElement pwd=driver.findElement(By.id("password"));
		enterText(pwd,password,"passwordEle");		
		clicklogin();
		extentreport.logTestInfo("method ended");
		logger.info("login is successful");
		logger.info("TC2 is passed");
		getScreenshotOfThePage(driver);

		extentreport.logTestInfo("TC2 is passed");

	}
@Test(priority=1)
public static void loginNegTC() throws IOException, InterruptedException {
logger.info("inside login method");
extentreport.logTestInfo("inside salesforce method");
PropertiesUtility propertiesUtility =new PropertiesUtility();
propertiesUtility.loadFile("applicationDataProperties");
String username=propertiesUtility.getPropertyValue("login.valid.userid");
//String password=propertiesUtility.getPropertyValue("login.valid.password");
		
	Thread.sleep(5000);
	WebElement email=driver.findElement(By.name("username"));
	enterText(email,username,"usernameEle");
	Thread.sleep(5000);
	clicklogin();
	WebElement errormsg=driver.findElement(By.xpath("//div[@id='error']"));
	waitForElement(40,errormsg);
	String act=enterText(errormsg,"ErrorMessage");
	String exp="Please enter your password.";
	//Assert.assertEquals(act, exp);
	validation(act, exp, 1);
	logger.info("TC1 is passed");
	getScreenshotOfThePage(driver);
	extentreport.logTestInfo("TC1 is passed");

	}
@Test(priority=3)
public static void rememberMe() throws IOException, InterruptedException  {
	logger.info("inside login method");
	extentreport.logTestInfo("inside salesforce method");
	PropertiesUtility propertiesUtility =new PropertiesUtility();
	propertiesUtility.loadFile("applicationDataProperties");
	String username=propertiesUtility.getPropertyValue("login.valid.userid");
   String password=propertiesUtility.getPropertyValue("login.valid.password");
			
		Thread.sleep(5000);
		WebElement email=driver.findElement(By.name("username"));
		enterText(email,username,"usernameEle");
		Thread.sleep(5000);
		WebElement pwd=driver.findElement(By.id("password"));
		enterText(pwd,password,"passwordEle");		
		Thread.sleep(5000);
		WebElement remember1=driver.findElement(By.xpath("//label[normalize-space()='Remember me']"));
		waitForElement(40,remember1);
		checkBox(remember1, "Remember Me");
		clicklogin();
		Thread.sleep(7000);
		WebElement user=driver.findElement(By.xpath("//span[@id='userNavLabel']"));
		waitForElement(40,user);
        user.click();
        clicklogout();
        Thread.sleep(6000);
    WebElement username1=driver.findElement(By.cssSelector("#idcard-identity"));
    waitForElement(40,username1);
    String act=enterText(username1, "username");
    String exp="octsel22@tekarch.com";
    validation(act, exp, 3);
    getScreenshotOfThePage(driver);
	extentreport.logTestInfo("TC3 is passed");

}
@Test(priority=4)
public static void forgotpwd() {
	//a[@id='forgot_password_link']
	
	WebElement fpwd=driver.findElement(By.id("forgot_password_link"));
	fpwd.click();
	WebElement user=driver.findElement(By.id("un"));
	user.sendKeys("octsel22@tekarch.com");
	
	WebElement cont=driver.findElement(By.id("continue"));
	cont.click();
		
	WebElement actual=driver.findElement(By.xpath("//p[contains(text(),'We’ve sent you an email with a link to finish rese')]"));
	String act=enterText(actual, "textmsg");
String exp="We’ve sent you an email with a link to finish resetting your password.";
	validation(act, exp, 4);
	getScreenshotOfThePage(driver);
	extentreport.logTestInfo("TC4 is passed");

}
@Test(priority=5)
public static void usernamedropdown() throws InterruptedException {
	logger.info("inside login method");
	extentreport.logTestInfo("inside salesforce method");
	PropertiesUtility propertiesUtility =new PropertiesUtility();
	propertiesUtility.loadFile("applicationDataProperties");
	String username=propertiesUtility.getPropertyValue("login.valid.userid");
   String password=propertiesUtility.getPropertyValue("login.valid.password");
			
		Thread.sleep(5000);
		WebElement email=driver.findElement(By.name("username"));
		enterText(email,username,"usernameEle");
		Thread.sleep(5000);
		WebElement pwd=driver.findElement(By.id("password"));
		enterText(pwd,password,"passwordEle");		
		clicklogin();
		extentreport.logTestInfo("method ended");
		logger.info("login is successful");
	WebElement user=driver.findElement(By.xpath("//span[@id='userNavLabel']"));
	waitForElement(40,user);
    user.click();
    logger.info("TC5 is passed");
    getScreenshotOfThePage(driver);
	extentreport.logTestInfo("TC5 is passed");

	
}
@Test(priority=6)
public static void clickMyProfile() throws InterruptedException {
	logger.info("inside login method");
	extentreport.logTestInfo("inside salesforce method");
	PropertiesUtility propertiesUtility =new PropertiesUtility();
	propertiesUtility.loadFile("applicationDataProperties");
	String username=propertiesUtility.getPropertyValue("login.valid.userid");
   String password=propertiesUtility.getPropertyValue("login.valid.password");
			
		Thread.sleep(5000);
		WebElement email=driver.findElement(By.name("username"));
		enterText(email,username,"usernameEle");
		Thread.sleep(5000);
		WebElement pwd=driver.findElement(By.id("password"));
		enterText(pwd,password,"passwordEle");		
		clicklogin();
		extentreport.logTestInfo("method ended");
		logger.info("login is successful");
	WebElement user=driver.findElement(By.xpath("//span[@id='userNavLabel']"));
	waitForElement(40,user);
    user.click();
    Thread.sleep(5000);
    WebElement profile=driver.findElement(By.xpath("//a[text()='My Profile']"));

	profile.click();

    Thread.sleep(7000);
    WebElement edit=driver.findElement(By.xpath("//a[@class='contactInfoLaunch editLink']//img[@title='Edit Profile']"));
	Thread.sleep(5000);
	edit.click();
	
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
logger.info("TC6 is passed");
getScreenshotOfThePage(driver);
extentreport.logTestInfo("TC6 is passed");

}
@Test(priority=7)
public static void selpersonal() throws InterruptedException {
	logger.info("inside login method");
	extentreport.logTestInfo("inside salesforce method");
	PropertiesUtility propertiesUtility =new PropertiesUtility();
	propertiesUtility.loadFile("applicationDataProperties");
	String username=propertiesUtility.getPropertyValue("login.valid.userid");
   String password=propertiesUtility.getPropertyValue("login.valid.password");
			
		Thread.sleep(5000);
		WebElement email=driver.findElement(By.name("username"));
		enterText(email,username,"usernameEle");
		Thread.sleep(5000);
		WebElement pwd=driver.findElement(By.id("password"));
		enterText(pwd,password,"passwordEle");		
		clicklogin();
		extentreport.logTestInfo("method ended");
		logger.info("login is successful");
	WebElement user=driver.findElement(By.xpath("//span[@id='userNavLabel']"));
	waitForElement(40,user);
    user.click();
    Thread.sleep(5000);
    WebElement mySet=driver.findElement(By.xpath("//a[@title='My Settings']"));
	mySet.click();
	WebElement personal=driver.findElement(By.id("PersonalInfo_font"));
	personal.click();
	//span[@id='LoginHistory_font']
	WebElement display=driver.findElement(By.id("LoginHistory_font"));
	display.click();
	//a[@href='/servlet/servlet.LoginHistory?id=005Dn000000noaE']
	
	WebElement clicklink=driver.findElement(By.xpath("//a[@href='/servlet/servlet.LoginHistory?id=005Dn000000noaE']"));
	clicklink.click();
	logger.info("TC7 is passed");
	getScreenshotOfThePage(driver);
	extentreport.logTestInfo("TC7 is passed");

}
@Test(priority=8)

public static void devconsole() throws InterruptedException {
	logger.info("inside login method");
	extentreport.logTestInfo("inside salesforce method");
	PropertiesUtility propertiesUtility =new PropertiesUtility();
	propertiesUtility.loadFile("applicationDataProperties");
	String username=propertiesUtility.getPropertyValue("login.valid.userid");
   String password=propertiesUtility.getPropertyValue("login.valid.password");
			
		Thread.sleep(5000);
		WebElement email=driver.findElement(By.name("username"));
		enterText(email,username,"usernameEle");
		Thread.sleep(5000);
		WebElement pwd=driver.findElement(By.id("password"));
		enterText(pwd,password,"passwordEle");		
		clicklogin();
		extentreport.logTestInfo("method ended");
		logger.info("login is successful");

	
	Thread.sleep(5000);
	WebElement user=driver.findElement(By.xpath("//span[@id='userNavLabel']"));
	waitForElement(40,user);
    user.click();
    WebElement clickdevconsole=driver.findElement(By.xpath("//a[@class='debugLogLink menuButtonMenuLink']"));
	clickdevconsole.click();
	
	logger.info("TestCase 8 is passed");
	getScreenshotOfThePage(driver);
	extentreport.logTestInfo("TC8 is passed");

	
}
@Test(priority=9)
public static void chklogout() throws InterruptedException {
	logger.info("inside login method");
	extentreport.logTestInfo("inside salesforce method");
	PropertiesUtility propertiesUtility =new PropertiesUtility();
	propertiesUtility.loadFile("applicationDataProperties");
	String username=propertiesUtility.getPropertyValue("login.valid.userid");
   String password=propertiesUtility.getPropertyValue("login.valid.password");
			
		Thread.sleep(5000);
		WebElement email=driver.findElement(By.name("username"));
		enterText(email,username,"usernameEle");
		Thread.sleep(5000);
		WebElement pwd=driver.findElement(By.id("password"));
		enterText(pwd,password,"passwordEle");		
		clicklogin();
		extentreport.logTestInfo("method ended");
		logger.info("login is successful");

	Thread.sleep(5000);
	WebElement user=driver.findElement(By.xpath("//span[@id='userNavLabel']"));
	waitForElement(40,user);
    user.click();
    clicklogout();
	logger.info("Successfully logout");
	logger.info("TC9 is passed");
	getScreenshotOfThePage(driver);
	extentreport.logTestInfo("TC9 is passed");

}
@Test(priority=10)
public static void acctName() throws InterruptedException {
	logger.info("inside login method");
	extentreport.logTestInfo("inside salesforce method");
	PropertiesUtility propertiesUtility =new PropertiesUtility();
	propertiesUtility.loadFile("applicationDataProperties");
	String username=propertiesUtility.getPropertyValue("login.valid.userid");
   String password=propertiesUtility.getPropertyValue("login.valid.password");
			
		Thread.sleep(5000);
		WebElement email=driver.findElement(By.name("username"));
		enterText(email,username,"usernameEle");
		Thread.sleep(5000);
		WebElement pwd=driver.findElement(By.id("password"));
		enterText(pwd,password,"passwordEle");		
		clicklogin();
		extentreport.logTestInfo("method ended");
		logger.info("login is successful");


	Thread.sleep(5000);
	WebElement accountTab=driver.findElement(By.xpath("//a[contains(text(),'Accounts')]"));
	accountTab.click();
	Thread.sleep(7000);
	driver.findElement(By.id("tryLexDialogX")).click();
	Thread.sleep(7000);
	WebElement clicknew=driver.findElement(By.xpath("//tbody/tr[1]/td[2]/input[1]"));
	clicknew.click();
	
	WebElement acctName=driver.findElement(By.xpath("(//input[@id='acc2'])[1]"));
	enterText(acctName, "vinivini", "accountname");
	Thread.sleep(5000);
	
	WebElement drpdown=driver.findElement(By.xpath("(//select[@id='acc6'])[1]"));
	dropdown(drpdown, "Technology Partner");

	Thread.sleep(5000);
	WebElement priority=driver.findElement(By.xpath("(//select[@id='00NDn000006wZB1'])[1]"));
	dropdown(priority, "High");
	
	driver.findElement(By.xpath("//td[@id='bottomButtonRow']//input[@title='Save']")).click();
	WebElement actual=driver.findElement(By.xpath("//h2[normalize-space()='vinivini']"));
	String act=enterText(actual, "accountname");
	String exp="vinivini";
	validation(act, exp, 10);
	getScreenshotOfThePage(driver);
	extentreport.logTestInfo("TC10 is passed");

}
@Test(priority=11)
public static void accountView() throws InterruptedException    {
	logger.info("inside login method");
	extentreport.logTestInfo("inside salesforce method");
	PropertiesUtility propertiesUtility =new PropertiesUtility();
	propertiesUtility.loadFile("applicationDataProperties");
	String username=propertiesUtility.getPropertyValue("login.valid.userid");
   String password=propertiesUtility.getPropertyValue("login.valid.password");
			
		Thread.sleep(5000);
		WebElement email=driver.findElement(By.name("username"));
		enterText(email,username,"usernameEle");
		Thread.sleep(5000);
		WebElement pwd=driver.findElement(By.id("password"));
		enterText(pwd,password,"passwordEle");		
		clicklogin();
		extentreport.logTestInfo("method ended");
		logger.info("login is successful");

Thread.sleep(5000);
WebElement accountTab=driver.findElement(By.xpath("//a[contains(text(),'Accounts')]"));
accountTab.click();
Thread.sleep(11000);
driver.findElement(By.id("tryLexDialogX")).click();
Thread.sleep(7000);
WebElement viewpath=driver.findElement(By.xpath("//a[normalize-space()='Create New View']"));
viewpath.click();
WebElement viewname=driver.findElement(By.xpath("//input[@id='fname']"));
enterText(viewname, "vini view1", "viewname");
WebElement uniqueview=driver.findElement(By.xpath("//input[@id='devname']"));
enterText(uniqueview, "uniquevini18", "uniqueview");
WebElement save=driver.findElement(By.xpath("(//input[@title='Save'])[2]"));
save.click();
System.out.println("Testcase11 is passed");
getScreenshotOfThePage(driver);
extentreport.logTestInfo("TC11 is passed");

}

@Test(priority=12)
public static void editview() throws InterruptedException {
	logger.info("inside login method");
	extentreport.logTestInfo("inside salesforce method");
	PropertiesUtility propertiesUtility =new PropertiesUtility();
	propertiesUtility.loadFile("applicationDataProperties");
	String username=propertiesUtility.getPropertyValue("login.valid.userid");
   String password=propertiesUtility.getPropertyValue("login.valid.password");
			
		Thread.sleep(5000);
		WebElement email=driver.findElement(By.name("username"));
		enterText(email,username,"usernameEle");
		Thread.sleep(5000);
		WebElement pwd=driver.findElement(By.id("password"));
		enterText(pwd,password,"passwordEle");		
		clicklogin();
		extentreport.logTestInfo("method ended");
		logger.info("login is successful");

	Thread.sleep(5000);
	WebElement accountTab=driver.findElement(By.xpath("//a[contains(text(),'Accounts')]"));
	accountTab.click();
	Thread.sleep(10000);	
	driver.findElement(By.id("tryLexDialogX")).click();
	WebElement view=driver.findElement(By.xpath("//select[@id='fcf']"));
	dropdown(view, "vee77");
	Thread.sleep(9000);	
	
	driver.findElement(By.xpath("//tbody/tr[1]/td[2]/div[2]/form[1]/div[1]/span[1]/span[1]/input[1]")).click();
	Thread.sleep(5000);
	WebElement edit=driver.findElement(By.xpath("(//a[contains(text(),'Edit')])[1]"));
	edit.click();
	Thread.sleep(5000);
	
	WebElement editviewname=driver.findElement(By.xpath("//input[@id='fname']"));
	enterText(editviewname, "vee88", "editviewname");
	Thread.sleep(5000);
	
	WebElement field=driver.findElement(By.xpath("(//select[@id='fcol1'])[1]"));
	dropdown(field, "Account Name");
	Thread.sleep(5000);
	
	WebElement operator=driver.findElement(By.xpath("(//select[@id='fop1'])[1]"));
	dropdown(operator, "contains");
	Thread.sleep(5000);
	
	WebElement value=driver.findElement(By.xpath("(//input[@id='fval1'])[1]"));
	value.sendKeys("a");
	Thread.sleep(5000);
	
	WebElement save=driver.findElement(By.xpath("(//input[@title='Save'])[2]"));
	save.click();
	System.out.println("Testcase 12 is passed");

	getScreenshotOfThePage(driver);
	extentreport.logTestInfo("TC12 is passed");

}
@Test(priority=13)
public static void merge() throws InterruptedException {
	logger.info("inside login method");
	extentreport.logTestInfo("inside salesforce method");
	PropertiesUtility propertiesUtility =new PropertiesUtility();
	propertiesUtility.loadFile("applicationDataProperties");
	String username=propertiesUtility.getPropertyValue("login.valid.userid");
   String password=propertiesUtility.getPropertyValue("login.valid.password");
			
		Thread.sleep(5000);
		WebElement email=driver.findElement(By.name("username"));
		enterText(email,username,"usernameEle");
		Thread.sleep(5000);
		WebElement pwd=driver.findElement(By.id("password"));
		enterText(pwd,password,"passwordEle");		
		clicklogin();
		extentreport.logTestInfo("method ended");
		logger.info("login is successful");

	Thread.sleep(5000);
	WebElement accountTab=driver.findElement(By.xpath("//a[contains(text(),'Accounts')]"));
	accountTab.click();
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
	getScreenshotOfThePage(driver);
	extentreport.logTestInfo("TC13 is passed");

}
@Test(priority=14)
public static void accReport() throws InterruptedException, AWTException {
	logger.info("inside login method");
	extentreport.logTestInfo("inside salesforce method");
	PropertiesUtility propertiesUtility =new PropertiesUtility();
	propertiesUtility.loadFile("applicationDataProperties");
	String username=propertiesUtility.getPropertyValue("login.valid.userid");
   String password=propertiesUtility.getPropertyValue("login.valid.password");
			
		Thread.sleep(5000);
		WebElement email=driver.findElement(By.name("username"));
		enterText(email,username,"usernameEle");
		Thread.sleep(5000);
		WebElement pwd=driver.findElement(By.id("password"));
		enterText(pwd,password,"passwordEle");		
		clicklogin();
		extentreport.logTestInfo("method ended");
		logger.info("login is successful");

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
	unikreport.sendKeys("uniquetest99");
	Thread.sleep(5000);
	WebElement saveandrun=driver.findElement(By.xpath("(//button[normalize-space()='Save and Run Report'])[1]"));
	saveandrun.click();
	//alert.dismiss();
	Thread.sleep(8000);
//	WebElement act1=driver.findElement(By.xpath("//a[normalize-space()='Reports']"));
//	String actual=act1.getText();
//	String exp="Reports";
//	validation(actual, exp, 14);
	logger.info("TC 14 is passed");
	getScreenshotOfThePage(driver);
	extentreport.logTestInfo("TC14 is passed");

}
@Test(priority=15)
public static void opportunity() throws InterruptedException {
	logger.info("inside login method");
	extentreport.logTestInfo("inside salesforce method");
	PropertiesUtility propertiesUtility =new PropertiesUtility();
	propertiesUtility.loadFile("applicationDataProperties");
	String username=propertiesUtility.getPropertyValue("login.valid.userid");
   String password=propertiesUtility.getPropertyValue("login.valid.password");
			
		Thread.sleep(5000);
		WebElement email=driver.findElement(By.name("username"));
		enterText(email,username,"usernameEle");
		Thread.sleep(5000);
		WebElement pwd=driver.findElement(By.id("password"));
		enterText(pwd,password,"passwordEle");		
		clicklogin();
		extentreport.logTestInfo("method ended");
		logger.info("login is successful");

	Thread.sleep(5000);
	WebElement oppo=driver.findElement(By.xpath("(//a[normalize-space()='Opportunities'])[1]"));
	oppo.click();
	
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
	extentreport.logTestInfo("TC15 is passed");
	getScreenshotOfThePage(driver);
	}

@Test(priority=16)
public static void opportunitynew() throws InterruptedException {
	logger.info("inside login method");
	extentreport.logTestInfo("inside salesforce method");
	PropertiesUtility propertiesUtility =new PropertiesUtility();
	propertiesUtility.loadFile("applicationDataProperties");
	String username=propertiesUtility.getPropertyValue("login.valid.userid");
   String password=propertiesUtility.getPropertyValue("login.valid.password");
			
		Thread.sleep(5000);
		WebElement email=driver.findElement(By.name("username"));
		enterText(email,username,"usernameEle");
		Thread.sleep(5000);
		WebElement pwd=driver.findElement(By.id("password"));
		enterText(pwd,password,"passwordEle");		
		clicklogin();
		extentreport.logTestInfo("method ended");
		logger.info("login is successful");

	Thread.sleep(5000);
	WebElement oppo=driver.findElement(By.xpath("(//a[normalize-space()='Opportunities'])[1]"));
	oppo.click();
	
	Thread.sleep(9000);
	driver.findElement(By.id("tryLexDialogX")).click();
	WebElement newbtn=driver.findElement(By.xpath("//input[@title='New']"));
	newbtn.click();
	Thread.sleep(5000);
	WebElement opponame=driver.findElement(By.xpath("(//input[@id='opp3'])[1]"));
	enterText(opponame, "oppo", "opponame");
	
	Thread.sleep(2000);
	WebElement closedate=driver.findElement(By.xpath("(//input[@id='opp9'])[1]"));
	closedate.click();
	Thread.sleep(2000);
	
	WebElement seldate=driver.findElement(By.xpath("//a[normalize-space()='Today']"));
	seldate.click();
	
	WebElement stage=driver.findElement(By.xpath("(//select[@id='opp11'])[1]"));
	dropdown(stage, "Closed Won");
	
	Thread.sleep(2000);
	
	WebElement save=driver.findElement(By.xpath("(//input[@title='Save'])[2]"));
	save.click();
    Thread.sleep(4000);
    
	WebElement actual=driver.findElement(By.xpath("(//h2[normalize-space()='oppo'])[1]"));
	String act=enterText(actual, "element");
	System.out.println(act);
	String exp="oppo";
	validation(act, exp, 16);
	extentreport.logTestInfo("TC16 is passed");
}
@Test(priority=17)
public static void opportunitylink() throws InterruptedException {
	logger.info("inside login method");
	extentreport.logTestInfo("inside salesforce method");
	PropertiesUtility propertiesUtility =new PropertiesUtility();
	propertiesUtility.loadFile("applicationDataProperties");
	String username=propertiesUtility.getPropertyValue("login.valid.userid");
   String password=propertiesUtility.getPropertyValue("login.valid.password");
			
		Thread.sleep(5000);
		WebElement email=driver.findElement(By.name("username"));
		enterText(email,username,"usernameEle");
		Thread.sleep(5000);
		WebElement pwd=driver.findElement(By.id("password"));
		enterText(pwd,password,"passwordEle");		
		clicklogin();
		extentreport.logTestInfo("method ended");
		logger.info("login is successful");

	Thread.sleep(5000);
	WebElement oppo=driver.findElement(By.xpath("(//a[normalize-space()='Opportunities'])[1]"));
	oppo.click();

	Thread.sleep(5000);
	driver.findElement(By.id("tryLexDialogX")).click();
	Thread.sleep(3000);
	WebElement link=driver.findElement(By.xpath("//a[normalize-space()='Opportunity Pipeline']"));
	link.click();
	
	Thread.sleep(4000);
	WebElement actual=driver.findElement(By.xpath("//h1[normalize-space()='Opportunity Pipeline']"));
	String act=enterText(actual, "actualmsg");
	
	String exp="Opportunity Pipeline";
	validation(act, exp, 17);
	extentreport.logTestInfo("TC17 is passed");

}
@Test(priority=18)
public static void oppostucklink() throws InterruptedException {
	logger.info("inside login method");
	extentreport.logTestInfo("inside salesforce method");
	PropertiesUtility propertiesUtility =new PropertiesUtility();
	propertiesUtility.loadFile("applicationDataProperties");
	String username=propertiesUtility.getPropertyValue("login.valid.userid");
   String password=propertiesUtility.getPropertyValue("login.valid.password");
			
		Thread.sleep(5000);
		WebElement email=driver.findElement(By.name("username"));
		enterText(email,username,"usernameEle");
		Thread.sleep(5000);
		WebElement pwd=driver.findElement(By.id("password"));
		enterText(pwd,password,"passwordEle");		
		clicklogin();
		extentreport.logTestInfo("method ended");
		logger.info("login is successful");

	Thread.sleep(5000);
	WebElement oppo=driver.findElement(By.xpath("(//a[normalize-space()='Opportunities'])[1]"));
	oppo.click();
	Thread.sleep(11000);
	driver.findElement(By.id("tryLexDialogX")).click();
	Thread.sleep(3000);
	WebElement oppostucklink=driver.findElement(By.xpath("//a[normalize-space()='Stuck Opportunities']"));
	oppostucklink.click();
	Thread.sleep(4000);
	WebElement actual=driver.findElement(By.xpath("//h1[normalize-space()='Stuck Opportunities']"));
	String act=actual.getText();
	enterText(actual, "stuck opportunities");
	System.out.println(act);
	String exp="Stuck Opportunities";
	validation(act, exp, 18);
	extentreport.logTestInfo("TC18 is passed");

	}

@Test(priority=19)
public static void quaterlysummary() throws InterruptedException {
	logger.info("inside login method");
	extentreport.logTestInfo("inside salesforce method");
	PropertiesUtility propertiesUtility =new PropertiesUtility();
	propertiesUtility.loadFile("applicationDataProperties");
	String username=propertiesUtility.getPropertyValue("login.valid.userid");
   String password=propertiesUtility.getPropertyValue("login.valid.password");
			
		Thread.sleep(5000);
		WebElement email=driver.findElement(By.name("username"));
		enterText(email,username,"usernameEle");
		Thread.sleep(5000);
		WebElement pwd=driver.findElement(By.id("password"));
		enterText(pwd,password,"passwordEle");		
		clicklogin();
		extentreport.logTestInfo("method ended");
		logger.info("login is successful");

	Thread.sleep(5000);
	WebElement oppo=driver.findElement(By.xpath("(//a[normalize-space()='Opportunities'])[1]"));
	oppo.click();

	Thread.sleep(9000);
	driver.findElement(By.id("tryLexDialogX")).click();
	Thread.sleep(5000);
	
	WebElement interval=driver.findElement(By.xpath("(//select[@id='quarter_q'])[1]"));
	dropdown(interval, "Next FQ");
	Thread.sleep(4000);
	
	WebElement runReport=driver.findElement(By.xpath("(//input[@title='Run Report'])[1]"));
	runReport.click();
	
	WebElement actual=driver.findElement(By.xpath("//h1[normalize-space()='Opportunity Report']"));
	String act=enterText(actual, "oppo report");
	System.out.println(act);
	String exp="Opportunity Report";

validation(act, exp, 19);
extentreport.logTestInfo("TC 19 is passed");

	
}
@Test(priority=20)

public static void leadstab() throws InterruptedException {
	logger.info("inside login method");
	extentreport.logTestInfo("inside salesforce method");
	PropertiesUtility propertiesUtility =new PropertiesUtility();
	propertiesUtility.loadFile("applicationDataProperties");
	String username=propertiesUtility.getPropertyValue("login.valid.userid");
   String password=propertiesUtility.getPropertyValue("login.valid.password");
			
		Thread.sleep(5000);
		WebElement email=driver.findElement(By.name("username"));
		enterText(email,username,"usernameEle");
		Thread.sleep(5000);
		WebElement pwd=driver.findElement(By.id("password"));
		enterText(pwd,password,"passwordEle");		
		clicklogin();
		extentreport.logTestInfo("method ended");
		logger.info("login is successful");

	WebElement leads=driver.findElement(By.xpath("//a[normalize-space()='Leads']"));
	leads.click();
	Thread.sleep(5000);
	driver.findElement(By.id("tryLexDialogX")).click();
	
	WebElement actual=driver.findElement(By.xpath("//h1[@class='pageType']"));
	String act=enterText(actual, "leads");
	System.out.println(act);
	String exp="Leads";
	validation(act, exp, 20);
	extentreport.logTestInfo("TC20 is passed");

}
@Test(priority=21)
public static void leadsdrp() throws InterruptedException {
	logger.info("inside login method");
	extentreport.logTestInfo("inside salesforce method");
	PropertiesUtility propertiesUtility =new PropertiesUtility();
	propertiesUtility.loadFile("applicationDataProperties");
	String username=propertiesUtility.getPropertyValue("login.valid.userid");
   String password=propertiesUtility.getPropertyValue("login.valid.password");
			
		Thread.sleep(5000);
		WebElement email=driver.findElement(By.name("username"));
		enterText(email,username,"usernameEle");
		Thread.sleep(5000);
		WebElement pwd=driver.findElement(By.id("password"));
		enterText(pwd,password,"passwordEle");		
		clicklogin();
		extentreport.logTestInfo("method ended");
		logger.info("login is successful");

	WebElement leads=driver.findElement(By.xpath("//a[normalize-space()='Leads']"));
	leads.click();
	Thread.sleep(6000);
	driver.findElement(By.id("tryLexDialogX")).click();
	
	WebElement leadsdrp=driver.findElement(By.xpath("//select[@id='fcf']"));
    Select sel=new Select(leadsdrp);
    List<WebElement> drplist=sel.getOptions();
	Iterator<WebElement> it=drplist.iterator();
	while(it.hasNext()) {
	
	System.out.println(it.next().getText());
		
	}
	System.out.println("test case 21 is passed");
	extentreport.logTestInfo("TC21 is passed");

}
@Test(priority=22)
public static void clickGoBtn() throws InterruptedException, IOException {
	logger.info("inside login method");
	extentreport.logTestInfo("inside salesforce method");
	PropertiesUtility propertiesUtility =new PropertiesUtility();
	propertiesUtility.loadFile("applicationDataProperties");
	String username=propertiesUtility.getPropertyValue("login.valid.userid");
   String password=propertiesUtility.getPropertyValue("login.valid.password");
			
		Thread.sleep(5000);
		WebElement email=driver.findElement(By.name("username"));
		enterText(email,username,"usernameEle");
		Thread.sleep(5000);
		WebElement pwd=driver.findElement(By.id("password"));
		enterText(pwd,password,"passwordEle");		
		clicklogin();
		extentreport.logTestInfo("method ended");
		logger.info("login is successful");

	WebElement leads=driver.findElement(By.xpath("//a[normalize-space()='Leads']"));
	leads.click();
	//leads drp
	Thread.sleep(6000);
	driver.findElement(By.id("tryLexDialogX")).click();
	
	WebElement leadsdrp=driver.findElement(By.xpath("//select[@id='fcf']"));
    enterText(leadsdrp, "Today's Leads");
    Thread.sleep(5000);
    
    WebElement drp=driver.findElement(By.xpath("//select[@id='hotlist_mode']"));
    enterText(drp, "My Unread Leads");
    Thread.sleep(5000);
    //clk profile
    WebElement clickprofile=driver.findElement(By.xpath("//span[@id='userNavLabel']"));

	clickprofile.click();
	clicklogout();
	Thread.sleep(8000);
	//go btn
	WebElement email1=driver.findElement(By.name("username"));
	enterText(email1,"octsel22@tekarch.com","usernameEle");
	Thread.sleep(5000);
	WebElement pwd1=driver.findElement(By.id("password"));
	enterText(pwd1,"Sagar1234","passwordElement");	
	clicklogin();
	Thread.sleep(5000);
	WebElement leads1=driver.findElement(By.xpath("//a[normalize-space()='Leads']"));
	leads1.click();
Thread.sleep(5000);
		WebElement gobtn=driver.findElement(By.xpath("//input[@title='Go!']"));

	gobtn.click();
	System.out.println("TC22 is passed");
	extentreport.logTestInfo("TC22 is passed");

}
@Test(priority=23)
public static void leadsTodaysleads() throws InterruptedException {
	logger.info("inside login method");
	extentreport.logTestInfo("inside salesforce method");
	PropertiesUtility propertiesUtility =new PropertiesUtility();
	propertiesUtility.loadFile("applicationDataProperties");
	String username=propertiesUtility.getPropertyValue("login.valid.userid");
   String password=propertiesUtility.getPropertyValue("login.valid.password");
			
		Thread.sleep(5000);
		WebElement email=driver.findElement(By.name("username"));
		enterText(email,username,"usernameEle");
		Thread.sleep(5000);
		WebElement pwd=driver.findElement(By.id("password"));
		enterText(pwd,password,"passwordEle");		
		clicklogin();
		extentreport.logTestInfo("method ended");
		logger.info("login is successful");

	WebElement leads=driver.findElement(By.xpath("//a[normalize-space()='Leads']"));
	leads.click();

	Thread.sleep(9000);
	driver.findElement(By.id("tryLexDialogX")).click();
	Thread.sleep(9000);
	String[] exp = {"All Open Leads","My Unread Leads","Recently Viewed Leads","Today's Leads","View - Custom 1","View - Custom 2"};
	WebElement viewdrp=driver.findElement(By.xpath("//select[@id='fcf']"));
	Select select=new Select(viewdrp);
	select.selectByVisibleText("Today's Leads");
	//driver.findElement(By.id("tryLexDialogX")).click();	
	
	List<WebElement> options = select.getOptions();  
	 for(WebElement we:options)  
	 {  
	  boolean match = false;
	  for (int i=0; i<exp.length;i++){
	      if (we.getText().equals(exp[i])){
	        match = true;
	        break;
	      }
	    }
       
	 }  
	System.out.println("Testcase 23 is passed");
	extentreport.logTestInfo("TC23 is passed");

	}

@Test(priority=24)
public static void leadlastname() throws InterruptedException {
	logger.info("inside login method");
	extentreport.logTestInfo("inside salesforce method");
	PropertiesUtility propertiesUtility =new PropertiesUtility();
	propertiesUtility.loadFile("applicationDataProperties");
	String username=propertiesUtility.getPropertyValue("login.valid.userid");
   String password=propertiesUtility.getPropertyValue("login.valid.password");
			
		Thread.sleep(5000);
		WebElement email=driver.findElement(By.name("username"));
		enterText(email,username,"usernameEle");
		Thread.sleep(5000);
		WebElement pwd=driver.findElement(By.id("password"));
		enterText(pwd,password,"passwordEle");		
		clicklogin();
		extentreport.logTestInfo("method ended");
		logger.info("login is successful");

	WebElement leads=driver.findElement(By.xpath("//a[normalize-space()='Leads']"));
	leads.click();
	
	Thread.sleep(9000);
	driver.findElement(By.id("tryLexDialogX")).click();
	
	WebElement newBtn=driver.findElement(By.xpath("//input[@title='New']"));
	newBtn.click();
	
	Thread.sleep(5000);
	WebElement Firstname=driver.findElement(By.xpath("(//input[@id='name_firstlea2'])[1]"));
	enterText(Firstname, "laxmi", "firstname");
	
	WebElement lastname=driver.findElement(By.xpath("(//input[@id='name_lastlea2'])[1]"));
	enterText(lastname, "ABCD", "lastname");
	
	WebElement company=driver.findElement(By.xpath("(//input[@id='lea3'])[1]"));
	enterText(company, "ABCD", "company name");
	
	Thread.sleep(5000);

	WebElement leadstatus=driver.findElement(By.xpath("(//select[@id='lea13'])[1]"));
	dropdown(leadstatus, "Working - Contacted");
	
	Thread.sleep(5000);

	WebElement save=driver.findElement(By.xpath("//td[@id='bottomButtonRow']//input[@title='Save']"));
	save.click();
	
	Thread.sleep(5000);
	
	
	WebElement leaddetail=driver.findElement(By.xpath("//h2[normalize-space()='Lead Detail']\r\n"
			+ ""));
	String actual=enterText(leaddetail, "leaddetail");
	String exp="Lead Detail";
	validation(actual, exp, 24);
	extentreport.logTestInfo("TC24 is passed");

}
@Test(priority=25)
public static void contactsnew() throws InterruptedException {
	logger.info("inside login method");
	extentreport.logTestInfo("inside salesforce method");
	PropertiesUtility propertiesUtility =new PropertiesUtility();
	propertiesUtility.loadFile("applicationDataProperties");
	String username=propertiesUtility.getPropertyValue("login.valid.userid");
   String password=propertiesUtility.getPropertyValue("login.valid.password");
			
		Thread.sleep(5000);
		WebElement email=driver.findElement(By.name("username"));
		enterText(email,username,"usernameEle");
		Thread.sleep(5000);
		WebElement pwd=driver.findElement(By.id("password"));
		enterText(pwd,password,"passwordEle");		
		clicklogin();
		extentreport.logTestInfo("method ended");
		logger.info("login is successful");

	//contacts tab
	WebElement contactTab=driver.findElement(By.xpath("//a[normalize-space()='Contacts']"));
	contactTab.click();
	
	Thread.sleep(11000);
	driver.findElement(By.id("tryLexDialogX")).click();
	
	WebElement newBtn=driver.findElement(By.xpath("//input[@title='New']"));
	newBtn.click();
	
	Thread.sleep(5000);
			
	WebElement lastname=driver.findElement(By.xpath("(//input[@id='name_lastcon2'])[1]"));
	lastname.sendKeys("dev");
	
	WebElement company=driver.findElement(By.xpath("(//input[@id='con4'])[1]"));
	company.click();
	
	Thread.sleep(5000);
			
	WebElement savebtn=driver.findElement(By.xpath("//td[@id='bottomButtonRow']//input[@title='Save']\r\n"
			+ ""));
	savebtn.click();
	Thread.sleep(5000);
	WebElement actual=driver.findElement(By.xpath("//h2[normalize-space()='dev']"));
	String act=enterText(actual, "text");
	String exp="dev";
	validation(act, exp, 25);
	extentreport.logTestInfo("TC 25 is passed");

	}

@Test(priority=26)
public static void contactsnewview() throws InterruptedException {
	logger.info("inside login method");
	extentreport.logTestInfo("inside salesforce method");
	PropertiesUtility propertiesUtility =new PropertiesUtility();
	propertiesUtility.loadFile("applicationDataProperties");
	String username=propertiesUtility.getPropertyValue("login.valid.userid");
   String password=propertiesUtility.getPropertyValue("login.valid.password");
			
		Thread.sleep(5000);
		WebElement email=driver.findElement(By.name("username"));
		enterText(email,username,"usernameEle");
		Thread.sleep(5000);
		WebElement pwd=driver.findElement(By.id("password"));
		enterText(pwd,password,"passwordEle");		
		clicklogin();
		extentreport.logTestInfo("method ended");
		logger.info("login is successful");

	//contacts tab
		WebElement contactTab=driver.findElement(By.xpath("//a[normalize-space()='Contacts']"));
		contactTab.click();

	Thread.sleep(9000);
	driver.findElement(By.id("tryLexDialogX")).click();
	Thread.sleep(5000);
	
	WebElement newView=driver.findElement(By.xpath("//a[normalize-space()='Create New View']"));
	newView.click();
	Thread.sleep(5000);
	//input[@id='fname']
	WebElement vName=driver.findElement(By.xpath("(//input[@id='fname'])[1]"));
	vName.sendKeys("myview");

	WebElement uniqueName=driver.findElement(By.xpath("//input[@id='devname']"));
	uniqueName.sendKeys("uniqueMyView4");

	WebElement save=driver.findElement(By.xpath("(//input[@title='Save'])[2]"));
	save.click();
	
	System.out.println("Testcase26 is passed");
	extentreport.logTestInfo("TC 26 is passed");

}
@Test(priority=27)
public static void contactsdrp() throws InterruptedException {
	logger.info("inside login method");
	extentreport.logTestInfo("inside salesforce method");
	PropertiesUtility propertiesUtility =new PropertiesUtility();
	propertiesUtility.loadFile("applicationDataProperties");
	String username=propertiesUtility.getPropertyValue("login.valid.userid");
   String password=propertiesUtility.getPropertyValue("login.valid.password");
			
		Thread.sleep(5000);
		WebElement email=driver.findElement(By.name("username"));
		enterText(email,username,"usernameEle");
		Thread.sleep(5000);
		WebElement pwd=driver.findElement(By.id("password"));
		enterText(pwd,password,"passwordEle");		
		clicklogin();
		extentreport.logTestInfo("method ended");
		logger.info("login is successful");

	//contacts tab
			WebElement contactTab=driver.findElement(By.xpath("//a[normalize-space()='Contacts']"));
			contactTab.click();

		Thread.sleep(6000);
	driver.findElement(By.id("tryLexDialogX")).click();
	Thread.sleep(5000);
	
	WebElement drp=driver.findElement(By.xpath("//select[@id='hotlist_mode']"));
	dropdown(drp, "Recently Created");
	
   System.out.println("Testcase27 is passed");
	extentreport.logTestInfo("TC 27 is passed");


}
@Test(priority=28)
public static void mycontacts() throws InterruptedException {
	logger.info("inside login method");
	extentreport.logTestInfo("inside salesforce method");
	PropertiesUtility propertiesUtility =new PropertiesUtility();
	propertiesUtility.loadFile("applicationDataProperties");
	String username=propertiesUtility.getPropertyValue("login.valid.userid");
   String password=propertiesUtility.getPropertyValue("login.valid.password");
			
		Thread.sleep(5000);
		WebElement email=driver.findElement(By.name("username"));
		enterText(email,username,"usernameEle");
		Thread.sleep(5000);
		WebElement pwd=driver.findElement(By.id("password"));
		enterText(pwd,password,"passwordEle");		
		clicklogin();
		extentreport.logTestInfo("method ended");
		logger.info("login is successful");

	//contacts tab
	WebElement contactTab=driver.findElement(By.xpath("//a[normalize-space()='Contacts']"));
	contactTab.click();
Thread.sleep(11000);
	driver.findElement(By.id("tryLexDialogX")).click();
	Thread.sleep(5000);
	
	WebElement drp=driver.findElement(By.xpath("//select[@id='fcf']"));
	dropdown(drp, "My Contacts");
	
   System.out.println("Testcase28 is passed");
	extentreport.logTestInfo("TC 28 is passed");

}
@Test(priority=29)
public static void contactsRecent() throws InterruptedException {
	logger.info("inside login method");
	extentreport.logTestInfo("inside salesforce method");
	PropertiesUtility propertiesUtility =new PropertiesUtility();
	propertiesUtility.loadFile("applicationDataProperties");
	String username=propertiesUtility.getPropertyValue("login.valid.userid");
   String password=propertiesUtility.getPropertyValue("login.valid.password");
			
		Thread.sleep(5000);
		WebElement email=driver.findElement(By.name("username"));
		enterText(email,username,"usernameEle");
		Thread.sleep(5000);
		WebElement pwd=driver.findElement(By.id("password"));
		enterText(pwd,password,"passwordEle");		
		clicklogin();
		extentreport.logTestInfo("method ended");
		logger.info("login is successful");

	//contacts tab
		WebElement contactTab=driver.findElement(By.xpath("//a[normalize-space()='Contacts']"));
		contactTab.click();
	Thread.sleep(6000);
	driver.findElement(By.id("tryLexDialogX")).click();
	Thread.sleep(11000);
	driver.findElement(By.xpath("//a[normalize-space()='Show 25 items']")).click();
	Thread.sleep(6000);
	WebElement recent=driver.findElement(By.xpath("//a[contains(text(),'United Oil & Gas Corp.')]"));
	recent.click();
	Thread.sleep(5000);
	
	WebElement test=driver.findElement(By.xpath("//h2[normalize-space()='United Oil & Gas Corp.']"));
	String actual=enterText(test, "text");
	String exp="United Oil & Gas Corp.";     
	validation(actual, exp, 29);
	extentreport.logTestInfo("TC 29 is passed");

}
@Test(priority=30)
public static void contactsview() throws InterruptedException {
	logger.info("inside login method");
	extentreport.logTestInfo("inside salesforce method");
	PropertiesUtility propertiesUtility =new PropertiesUtility();
	propertiesUtility.loadFile("applicationDataProperties");
	String username=propertiesUtility.getPropertyValue("login.valid.userid");
   String password=propertiesUtility.getPropertyValue("login.valid.password");
			
		Thread.sleep(5000);
		WebElement email=driver.findElement(By.name("username"));
		enterText(email,username,"usernameEle");
		Thread.sleep(5000);
		WebElement pwd=driver.findElement(By.id("password"));
		enterText(pwd,password,"passwordEle");		
		clicklogin();
		extentreport.logTestInfo("method ended");
		logger.info("login is successful");

	//contacts tab
			WebElement contactTab=driver.findElement(By.xpath("//a[normalize-space()='Contacts']"));
			contactTab.click();
	
	Thread.sleep(7000);
	driver.findElement(By.id("tryLexDialogX")).click();
	Thread.sleep(5000);
	
	WebElement clickview=driver.findElement(By.xpath("//a[normalize-space()='Create New View']"));
	clickview.click();
	Thread.sleep(5000);
	
	WebElement uniqueviewname=driver.findElement(By.xpath("//input[@id='devname']"));
	uniqueviewname.sendKeys("EFGH");	
	Thread.sleep(5000);
	WebElement save=driver.findElement(By.xpath("//body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[2]/form[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/input[1]"));
	save.click();
	Thread.sleep(5000);

	WebElement err=driver.findElement(By.xpath("(//div[@class='errorMsg'])[1]"));
	String actual=enterText(err, "errormsg");
	System.out.println(actual);
	String exp="Error: You must enter a value";
	validation(actual, exp, 30);
	extentreport.logTestInfo("TC 30 is passed");

}
@Test(priority=31)
public static void contactshome() throws InterruptedException {
	logger.info("inside login method");
	extentreport.logTestInfo("inside salesforce method");
	PropertiesUtility propertiesUtility =new PropertiesUtility();
	propertiesUtility.loadFile("applicationDataProperties");
	String username=propertiesUtility.getPropertyValue("login.valid.userid");
   String password=propertiesUtility.getPropertyValue("login.valid.password");
			
		Thread.sleep(5000);
		WebElement email=driver.findElement(By.name("username"));
		enterText(email,username,"usernameEle");
		Thread.sleep(5000);
		WebElement pwd=driver.findElement(By.id("password"));
		enterText(pwd,password,"passwordEle");		
		clicklogin();
		extentreport.logTestInfo("method ended");
		logger.info("login is successful");

	//contacts tab
	WebElement contactTab=driver.findElement(By.xpath("//a[normalize-space()='Contacts']"));
	contactTab.click();	
Thread.sleep(7000);
driver.findElement(By.id("tryLexDialogX")).click();
Thread.sleep(5000);

WebElement clickview=driver.findElement(By.xpath("//a[normalize-space()='Create New View']"));
clickview.click();
Thread.sleep(5000);
WebElement viewname=driver.findElement(By.xpath("//input[@id='fname']"));
viewname.sendKeys("ABCD");
WebElement uniqueviewname=driver.findElement(By.xpath("//input[@id='devname']"));
uniqueviewname.sendKeys("EFGH");	
Thread.sleep(5000);
WebElement cancel=driver.findElement(By.xpath("(//input[@title='Cancel'])[1]"));
cancel.click();
Thread.sleep(5000);

WebElement contactsHome=driver.findElement(By.xpath("//h2[normalize-space()='Home']"));

String actual=enterText(contactsHome, "contact");
String exp="HOME";
validation(actual, exp, 31);
extentreport.logTestInfo("TC 31 is passed");

}
@Test(priority=32)
public static void contactsSave() throws InterruptedException {
	logger.info("inside login method");
	extentreport.logTestInfo("inside salesforce method");
	PropertiesUtility propertiesUtility =new PropertiesUtility();
	propertiesUtility.loadFile("applicationDataProperties");
	String username=propertiesUtility.getPropertyValue("login.valid.userid");
   String password=propertiesUtility.getPropertyValue("login.valid.password");
			
		Thread.sleep(5000);
		WebElement email=driver.findElement(By.name("username"));
		enterText(email,username,"usernameEle");
		Thread.sleep(5000);
		WebElement pwd=driver.findElement(By.id("password"));
		enterText(pwd,password,"passwordEle");		
		clicklogin();
		extentreport.logTestInfo("method ended");
		logger.info("login is successful");

	//contacts tab
		WebElement contactTab=driver.findElement(By.xpath("//a[normalize-space()='Contacts']"));
		contactTab.click();	
	Thread.sleep(11000);
	driver.findElement(By.id("tryLexDialogX")).click();
	Thread.sleep(5000);
	
	WebElement drp=driver.findElement(By.xpath("//select[@id='fcf']"));
	dropdown(drp, "My Contacts");
	
    Thread.sleep(5000);
	WebElement newBtn=driver.findElement(By.xpath("//input[@title='New']"));
	newBtn.click();
    Thread.sleep(5000);
    WebElement lname=driver.findElement(By.id("name_lastcon2"));
	lname.sendKeys("ind");
	Thread.sleep(5000);
	WebElement acct=driver.findElement(By.id("con4"));
	acct.sendKeys("vini");
	Thread.sleep(5000);
	WebElement saveNew=driver.findElement(By.xpath("//td[@id='topButtonRow']//input[@title='Save & New']"));
	saveNew.click();	
	
	WebElement act=driver.findElement(By.xpath("//h2[normalize-space()='New Contact']"));
	String actual=enterText(act, "Text");
	String exp="New Contact";
	validation(actual, exp, 32);
	extentreport.logTestInfo("TC 32 is passed");

}
@Test(priority=33)
public static void homepage() throws InterruptedException {
	logger.info("inside login method");
	extentreport.logTestInfo("inside salesforce method");
	PropertiesUtility propertiesUtility =new PropertiesUtility();
	propertiesUtility.loadFile("applicationDataProperties");
	String username=propertiesUtility.getPropertyValue("login.valid.userid");
   String password=propertiesUtility.getPropertyValue("login.valid.password");
			
		Thread.sleep(5000);
		WebElement email=driver.findElement(By.name("username"));
		enterText(email,username,"usernameEle");
		Thread.sleep(5000);
		WebElement pwd=driver.findElement(By.id("password"));
		enterText(pwd,password,"passwordEle");		
		clicklogin();
		extentreport.logTestInfo("method ended");
		logger.info("login is successful");

	//home tab
	WebElement homeTab=driver.findElement(By.xpath("//a[normalize-space()='Home']"));
	homeTab.click();
	
	Thread.sleep(9000);
	driver.findElement(By.id("tryLexDialogX")).click();
	Thread.sleep(5000);
	WebElement flname=driver.findElement(By.xpath("//a[@href='/_ui/core/userprofile/UserProfilePage'][normalize-space()='laxmi New']"));
	flname.click();
	Thread.sleep(5000);
	
	WebElement act=driver.findElement(By.xpath("(//span[@id='tailBreadcrumbNode'])[1]"));
	String actual=enterText(act, "profile name");
	System.out.println(actual);
	String exp="laxmi New ";
	validation(actual, exp, 33);
	extentreport.logTestInfo("TC 33 is passed");

}
@Test(priority=34)
public static void random() throws InterruptedException {
	logger.info("inside login method");
	extentreport.logTestInfo("inside salesforce method");
	PropertiesUtility propertiesUtility =new PropertiesUtility();
	propertiesUtility.loadFile("applicationDataProperties");
	String username=propertiesUtility.getPropertyValue("login.valid.userid");
   String password=propertiesUtility.getPropertyValue("login.valid.password");
			
		Thread.sleep(5000);
		WebElement email=driver.findElement(By.name("username"));
		enterText(email,username,"usernameEle");
		Thread.sleep(5000);
		WebElement pwd=driver.findElement(By.id("password"));
		enterText(pwd,password,"passwordEle");		
		clicklogin();
		extentreport.logTestInfo("method ended");
		logger.info("login is successful");

	WebElement homeTab=driver.findElement(By.xpath("//a[normalize-space()='Home']"));
	homeTab.click();

	Thread.sleep(9000);
	driver.findElement(By.id("tryLexDialogX")).click();
	Thread.sleep(5000);
	WebElement flname=driver.findElement(By.xpath("//a[@href='/_ui/core/userprofile/UserProfilePage'][normalize-space()='laxmi New']"));
	flname.click();
	Thread.sleep(5000);
	
	WebElement edit=driver.findElement(By.xpath("//a[@class='contactInfoLaunch editLink']//img[@title='Edit Profile']"));
	Thread.sleep(5000);
	edit.click();
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
System.out.println("TC34 is passed");
extentreport.logTestInfo("TC 34 is passed");

}
@Test(priority=35)
public static void custmytabs() throws InterruptedException {
	logger.info("inside login method");
	extentreport.logTestInfo("inside salesforce method");
	PropertiesUtility propertiesUtility =new PropertiesUtility();
	propertiesUtility.loadFile("applicationDataProperties");
	String username=propertiesUtility.getPropertyValue("login.valid.userid");
   String password=propertiesUtility.getPropertyValue("login.valid.password");
			
		Thread.sleep(5000);
		WebElement email=driver.findElement(By.name("username"));
		enterText(email,username,"usernameEle");
		Thread.sleep(5000);
		WebElement pwd=driver.findElement(By.id("password"));
		enterText(pwd,password,"passwordEle");		
		clicklogin();
		extentreport.logTestInfo("method ended");
		logger.info("login is successful");

	WebElement alltabs=driver.findElement(By.xpath("(//img[@title='All Tabs'])[1]"));
	alltabs.click();
	Thread.sleep(6000);
	WebElement custtabs=driver.findElement(By.xpath("//input[@title='Customize My Tabs']"));
	custtabs.click();
	Thread.sleep(5000);
	
	WebElement reports=driver.findElement(By.xpath("//option[@value='report']"));
	reports.click();
	Thread.sleep(5000);
	//img[@title='Remove']
	WebElement remove=driver.findElement(By.xpath("//img[@title='Remove']"));
	remove.click();
	Thread.sleep(5000);
	WebElement save=driver.findElement(By.xpath("//input[@title='Save']"));
	save.click();
	
	WebElement profile=driver.findElement(By.xpath("//span[@id='userNavLabel']"));
	
	profile.click();
	
	clicklogout();
	Thread.sleep(5000);
	logger.info("inside login method");
	extentreport.logTestInfo("inside salesforce method");
	
	String username1=propertiesUtility.getPropertyValue("login.valid.userid");
   String password1=propertiesUtility.getPropertyValue("login.valid.password");
			
		Thread.sleep(5000);
		WebElement email1=driver.findElement(By.name("username"));
		enterText(email1,username1,"usernameEle");
		Thread.sleep(5000);
		WebElement pwd1=driver.findElement(By.id("password"));
		enterText(pwd1,password1,"passwordEle");		
		clicklogin();
		extentreport.logTestInfo("method ended");
		logger.info("login is successful");
		
		WebElement homeTab=driver.findElement(By.xpath("//a[@title='Home Tab']"));
		waitForElement(40,homeTab);
		String act=getTextFrmElement(homeTab, "home page");
		String exp="HOME";
		validation(act,exp,35);
		extentreport.logTestInfo("TC 35 is passed");

	}
@Test(priority=36)
public static void datelink() throws InterruptedException {
	logger.info("inside login method");
	extentreport.logTestInfo("inside salesforce method");
	PropertiesUtility propertiesUtility =new PropertiesUtility();
	propertiesUtility.loadFile("applicationDataProperties");
	String username=propertiesUtility.getPropertyValue("login.valid.userid");
   String password=propertiesUtility.getPropertyValue("login.valid.password");
			
		Thread.sleep(5000);
		WebElement email=driver.findElement(By.name("username"));
		enterText(email,username,"usernameEle");
		Thread.sleep(5000);
		WebElement pwd=driver.findElement(By.id("password"));
		enterText(pwd,password,"passwordEle");		
		clicklogin();
		extentreport.logTestInfo("method ended");
		logger.info("login is successful");

	
	WebElement homeTab=driver.findElement(By.xpath("//a[normalize-space()='Home']"));
	homeTab.click();
	Thread.sleep(15000);
	driver.findElement(By.id("tryLexDialogX")).click();
	WebElement dlink=driver.findElement(By.xpath("//a[normalize-space()='Monday February 20, 2023']"));
	dlink.click();
	//a[normalize-space()='8:00 PM']
	WebElement timelink=driver.findElement(By.xpath("//a[normalize-space()='8:00 PM']"));
	timelink.click();
	Thread.sleep(5000);
	//img[@title='Subject Combo (New Window)']
	
	WebElement icon=driver.findElement(By.xpath("//img[@title='Subject Combo (New Window)']"));
	icon.click();
	//li[@class='listItem4']//a[1]
	Thread.sleep(5000);
	String mainWindowHandle = driver.getWindowHandle();
    Set<String> allWindowHandles = driver.getWindowHandles();
    Iterator<String> iterator = allWindowHandles.iterator();

    // Here we will check if child window has other child windows and will fetch the heading of the child window
    while (iterator.hasNext()) {
        String ChildWindow = iterator.next();
            if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
            driver.switchTo().window(ChildWindow);
            Thread.sleep(5000);
            driver.manage().window().maximize();
            Thread.sleep(5000);
	WebElement other=driver.findElement(By.xpath("/html[1]/body[1]/div[2]/ul[1]/li[5]/a[1]"));
	other.click();
            }
    }
           driver.switchTo().window(mainWindowHandle);
	Thread.sleep(5000);
	//td[@id='bottomButtonRow']//input[@title='Save']
	WebElement save=driver.findElement(By.xpath("//td[@id='bottomButtonRow']//input[@title='Save']"));
	save.click();
	WebElement title=driver.findElement(By.xpath("//h1[normalize-space()='Calendar for laxmi New - Day View']"));
	String act=enterText(title, "text");
	String exp="Calendar for laxmi New - Day View";
	validation(act, exp, 36);
	extentreport.logTestInfo("TC 36 is passed");

}
@Test(priority=37)
public static void datlink() throws InterruptedException {
	logger.info("inside login method");
	extentreport.logTestInfo("inside salesforce method");
	PropertiesUtility propertiesUtility =new PropertiesUtility();
	propertiesUtility.loadFile("applicationDataProperties");
	String username=propertiesUtility.getPropertyValue("login.valid.userid");
   String password=propertiesUtility.getPropertyValue("login.valid.password");
			
		Thread.sleep(5000);
		WebElement email=driver.findElement(By.name("username"));
		enterText(email,username,"usernameEle");
		Thread.sleep(5000);
		WebElement pwd=driver.findElement(By.id("password"));
		enterText(pwd,password,"passwordEle");		
		clicklogin();
		extentreport.logTestInfo("method ended");
		logger.info("login is successful");
	Thread.sleep(6000);
	WebElement homeTab=driver.findElement(By.xpath("//a[normalize-space()='Home']"));
	homeTab.click();
	Thread.sleep(9000);
	driver.findElement(By.id("tryLexDialogX")).click();

	WebElement dlink=driver.findElement(By.xpath("//a[normalize-space()='Monday February 20, 2023']"));
	dlink.click();
	//a[normalize-space()='8:00 PM']
	WebElement timelink=driver.findElement(By.xpath("//a[normalize-space()='4:00 PM']"));
	timelink.click();
	Thread.sleep(5000);
	//img[@title='Subject Combo (New Window)']
	
	WebElement icon=driver.findElement(By.xpath("//img[@title='Subject Combo (New Window)']"));
	icon.click();
	//li[@class='listItem4']//a[1]
	Thread.sleep(5000);
	String mainWindowHandle = driver.getWindowHandle();
    Set<String> allWindowHandles = driver.getWindowHandles();
    Iterator<String> iterator = allWindowHandles.iterator();

    // Here we will check if child window has other child windows and will fetch the heading of the child window
    while (iterator.hasNext()) {
        String ChildWindow = iterator.next();
            if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
            driver.switchTo().window(ChildWindow);
            Thread.sleep(5000);
            driver.manage().window().maximize();
            Thread.sleep(5000);
	WebElement other=driver.findElement(By.xpath("/html[1]/body[1]/div[2]/ul[1]/li[5]/a[1]"));
	other.click();
            }
    }
           driver.switchTo().window(mainWindowHandle);
	Thread.sleep(5000);
	
	WebElement endtime=driver.findElement(By.xpath("//input[@id='EndDateTime_time']"));
	endtime.click();
	Thread.sleep(5000);
	WebElement seltime=driver.findElement(By.id("timePickerItem_38"));
	seltime.click();
	//input[@id='IsRecurrence']
	Thread.sleep(5000);
	WebElement chk=driver.findElement(By.xpath("//input[@id='IsRecurrence']"));
	chk.click();
	Thread.sleep(5000);
	//input[@id='rectypeftw']
	WebElement radio=driver.findElement(By.xpath("//input[@id='rectypeftw']"));
	radio.click();
	Thread.sleep(5000);
	//input[@id='RecurrenceEndDateOnly']
	WebElement enddate=driver.findElement(By.xpath("//input[@id='RecurrenceEndDateOnly']"));
	enddate.click();
	//td[normalize-space()='27']
	Thread.sleep(6000);
	WebElement selenddate=driver.findElement(By.xpath("//td[normalize-space()='27']"));
	selenddate.click();
	Thread.sleep(5000);
	//td[@id='bottomButtonRow']//input[@title='Save']
	WebElement save=driver.findElement(By.xpath("//td[@id='bottomButtonRow']//input[@title='Save']"));
	save.click();
	
	Thread.sleep(5000);
	WebElement monthview=driver.findElement(By.xpath("//img[@title='Month View']"));
	monthview.click();
	WebElement title=driver.findElement(By.xpath("//h1[normalize-space()='Calendar for laxmi New - Month View']"));
	String act=enterText(title, "text");
	String exp="Calendar for laxmi New - Month View";
	validation(act, exp, 37);
	extentreport.logTestInfo("TC 37 is passed");

}

}


