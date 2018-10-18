package selenium_basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDowns {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","E:\\Selenium prerequistes\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.irctc.co.in/eticketing/userSignUp.jsf");
		
		Select s= new Select(driver.findElement(By.id("userRegistrationForm:countries")));
		s.selectByValue("14");
		s.selectByVisibleText("India");

		
	}

}
