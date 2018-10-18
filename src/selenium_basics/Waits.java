package selenium_basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","E:\\Selenium prerequistes\\chromedriver.exe");	
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.cleartrip.com/");
		
		//Thread.sleep(40000);
		//driver.switchTo().alert().dismiss();
		WebDriverWait wait=new WebDriverWait(driver,50);
		
		WebElement From=wait.until(ExpectedConditions.elementToBeClickable(By.id("FromTag")));
		From.sendKeys("Hyderabad");
		
		WebElement To=wait.until(ExpectedConditions.elementToBeClickable(By.id("ToTag")));
		To.sendKeys("Chennai");
		
		
		
		
		
	}

}
