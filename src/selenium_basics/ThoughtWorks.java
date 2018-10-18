package selenium_basics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ThoughtWorks {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver","E:\\Selenium prerequistes\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//Reading values from file
		
		Properties p=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\amitha\\eclipse-workspace\\MindQ\\config.properties");
		p.load(fis);
		String url=p.getProperty("URL");
		driver.get(url);
		driver.manage().window().maximize();
		
		//driver.get("https://www.thoughtworks.com/careers");
		//Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Browse jobs']")).click();
        driver.findElement(By.linkText("India")).click();
        driver.findElement(By.linkText("Bangalore")).click();
        driver.findElement(By.linkText("Sales and Marketing Designer")).click();
        driver.findElement(By.xpath("//a[@data-event-action='Click to learn more']"))
        .click();
        Thread.sleep(5000);
        driver.switchTo().frame("grnhse_iframe");
        driver.findElement(By.id("first_name")).sendKeys("Amitha");
        driver.findElement(By.id("last_name")).sendKeys("User");
        driver.findElement(By.id("email")).sendKeys("User@random123");
        driver.findElement(By.xpath("//a[text()='Attach']")).click();
        driver.findElement(By.id("resume_file")).sendKeys("E:\\MindQ\\Resume.txt");
        
	}
	
	
}
