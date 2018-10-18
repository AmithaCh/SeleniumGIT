package selenium_basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frames {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","E:\\Selenium prerequistes\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.freecrm.com/index.html");
		
		driver.findElement(By.name("username")).sendKeys("badri_20");
		driver.findElement(By.name("password")).sendKeys("welcome123");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		System.out.println(driver.findElements(By.tagName("frame")).size());
		driver.switchTo().frame("mainpanel");
		Thread.sleep(3000);

		//driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//*[@id='navmenu']/ul/li[4]/a")).click();

	}

}
