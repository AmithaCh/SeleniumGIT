package selenium_basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Alerts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","E:\\Selenium prerequistes\\chromedriver.exe");	
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		//driver.get("https://www.guru99.com/alert-popup-handling-selenium.html");
		WebDriverWait wait=new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.alertIsPresent());
		
		//driver.findElement(By.xpath("//input[@value='Go']")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();

		//wait.until(ExpectedConditions.elementToBeSelected(element)))
	}

}
