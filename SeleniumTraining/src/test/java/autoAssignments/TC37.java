package autoAssignments;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC37 extends TC34{

	public static void main(String[] args) throws IOException, InterruptedException {
		loginpage();
		clicklogin();
		Thread.sleep(5000);
		hometab();
		Thread.sleep(10000);
		driver.findElement(By.id("tryLexDialogX")).click();
		Thread.sleep(5000);
		datlink();
		Thread.sleep(5000);
		validdata();

	}
	public static void datlink() throws InterruptedException {
		WebElement dlink=driver.findElement(By.xpath("//a[normalize-space()='Monday February 13, 2023']"));
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
		Thread.sleep(5000);
		WebElement selenddate=driver.findElement(By.xpath("//td[normalize-space()='27']"));
		selenddate.click();
		Thread.sleep(5000);
		//td[@id='bottomButtonRow']//input[@title='Save']
		WebElement save=driver.findElement(By.xpath("//td[@id='bottomButtonRow']//input[@title='Save']"));
		save.click();
		
		Thread.sleep(5000);
		WebElement monthview=driver.findElement(By.xpath("//img[@title='Month View']"));
		monthview.click();
		
	}
	public static void validdata() {
		//h1[normalize-space()='Calendar for laxmi New - Day View']
		WebElement title=driver.findElement(By.xpath("//h1[normalize-space()='Calendar for laxmi New - Month View']"));
		String act=enterText(title, "text");
		String exp="Calendar for laxmi New - Month View";
		validation(act, exp, 37);
	}


	}


