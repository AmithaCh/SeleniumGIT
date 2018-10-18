package selenium_basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TextboxExercise1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","E:\\Selenium prerequistes\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.freecrm.com/register/");
		//driver.findElement(By.linkText("Sign Up")).click();
		
		//can't link on Sign Up since it has two links with same text.
		
		driver.findElement(By.name("first_name")).click();
		driver.findElement(By.name("first_name")).sendKeys("Amitha");
		
		driver.findElement(By.name("surname")).click();
		driver.findElement(By.name("surname")).sendKeys("Chidurala");
		
		driver.findElement(By.name("email")).click();
		driver.findElement(By.name("email")).sendKeys("amithachidurala91@gmail.com");
		
		
		driver.findElement(By.xpath("//input[@placeholder='Confirm Email']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Confirm Email']")).sendKeys("amithachidurala91@gmail.com");
		
		driver.findElement(By.xpath("//input[@name='username']")).click();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("amithachidurala");
		
		driver.findElement(By.xpath("//*[@name='password']")).click();
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys("abcdef123");
		
		driver.findElement(By.xpath("//input[@name='passwordconfirm']")).click();
		driver.findElement(By.xpath("//input[@name='passwordconfirm']")).sendKeys("abcdef123");
		
		driver.findElement(By.xpath("//input[@name='agreeTerms']")).click();
	
		driver.findElement(By.className("myButton")).click();
		
		driver.close();
		
		
		
	}

}
