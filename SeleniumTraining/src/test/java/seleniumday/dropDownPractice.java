package seleniumday;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dropDownPractice {
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriverManager.chromedriver().setup();
driver=new ChromeDriver();
driver.get("https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html");
WebElement dropdown=driver.findElement(By.id("course"));
Select select=new Select(dropdown);
select.selectByValue("python");


	}

}
