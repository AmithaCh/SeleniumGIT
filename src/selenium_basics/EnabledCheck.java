package selenium_basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EnabledCheck {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","E:\\Selenium prerequistes\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.cleartrip.com/");
		
		System.out.println("Before clicking on RoundTrip radio button");
		System.out.println(driver.findElement(By.id("RoundTrip")).isSelected());
		driver.findElement(By.id("RoundTrip")).click();
		
		System.out.println("After clicking on RoundTrip radio button");
		System.out.println(driver.findElement(By.id("RoundTrip")).isSelected());
		
		driver.close();
	}

}
