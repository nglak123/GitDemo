package seleniumday;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class tech7Mousehover {
	
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.amazon.com/");
		WebElement hov=driver.findElement(By.id("nav-link-accountList-nav-line-1"));
		Actions action=new Actions(driver);
		action.moveToElement(hov).build().perform();
		

	}

}
