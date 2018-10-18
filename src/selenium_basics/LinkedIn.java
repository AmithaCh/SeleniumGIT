package selenium_basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkedIn {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium prerequistes\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.linkedin.com/");
		driver.findElement(By.xpath("//input[@class='login-email']")).sendKeys("amitha.chidurala46@gmail.com");
		driver.findElement(By.xpath("//input[@class='login-password']")).sendKeys("inetsolv2580");
		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@class='login submit-button']")).click();
		
		//driver.findElement(By.xpath("//div[@class='nav-item__title-container'] /span[@class='nav-item__title nav-item__dropdown-trigger--title']")).click();
		driver.findElement(By.xpath("//button[@id='nav-settings__dropdown-trigger']")).click();
		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Sign out")).click();

	}

}
