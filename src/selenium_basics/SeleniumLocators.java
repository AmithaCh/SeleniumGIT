package selenium_basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumLocators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","E:\\Selenium prerequistes\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		
		//Selenium locators examples
		driver.findElement(By.id("q")).click();
		driver.findElement(By.name("q")).click();
		driver.findElement(By.className("q"));
		driver.findElement(By.tagName("a"));
		driver.findElement(By.linkText("Gmail"));
		driver.findElement(By.partialLinkText("Gma"));
		driver.findElement(By.xpath("//input[@id='q']"));
		driver.findElement(By.cssSelector("input[id='q']"));
		driver.close();
		
		
		
	}

}
