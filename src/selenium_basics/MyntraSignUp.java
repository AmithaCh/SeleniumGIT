package selenium_basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MyntraSignUp {
	static String email="amitha.chidurala46@gmail.com";
	static String password="amitha12345@";
	static String mobile="3374969823";
	static String gender="Female";

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium prerequistes\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.myntra.com/");
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//div[@class='desktop-userIconsContainer']"))).build().perform();
		driver.manage().timeouts().implicitlyWait(2L, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@data-reactid='523']")).click();
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("mobile")).sendKeys(mobile);
		//driver.findElement(By.id("female")).click();
		if(gender.equalsIgnoreCase("Female"))
		{
			driver.findElement(By.xpath("//input[@value='female']")).click();
		}
		else {
			driver.findElement(By.xpath("//input[@value='male']")).click();
		}
		driver.findElement(By.xpath("//button[@class='register-register-button']")).click();
		//driver.manage().timeouts().implicitlyWait(2L, TimeUnit.SECONDS);
		Alert alert=driver.switchTo().alert();
		String string=alert.getText();
		System.out.println(string);
		alert.dismiss();

	}

}
