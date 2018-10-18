package selenium_littleadvanced;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Logs {
	public WebDriver driver;
	public Properties prop;
	
	public String fetchProperty(String key) throws IOException
	{
		prop=new Properties();
		FileInputStream fis=new FileInputStream("\\Users\\amitha\\eclipse-workspace\\Selenium\\application.properties");
	    prop.load(fis);
	    String value=prop.getProperty(key);
		return value;
		
	}
	public Logs() throws IOException
	{
		System.setProperty("webdriver.chrome.driver", fetchProperty("path"));
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(fetchProperty("URL"));
	
	}
	public void LogsWriting() throws IOException, InterruptedException
	{
		File file=new File("E:\\LogsWriting.txt");
		FileWriter fw=new FileWriter(file);
		BufferedWriter bw=new BufferedWriter(fw);
		bw.write("FreeCRM Exercise.");
		bw.write("Browser has been launched.");
		driver.findElement(By.xpath(fetchProperty("usernameTextBox"))).sendKeys("badri_20");
		bw.write("I have entered username.");
		driver.findElement(By.xpath(fetchProperty("passwordTextBox"))).sendKeys("welcome123");
		bw.write("I have entered password.");
		Thread.sleep(3000);
		driver.findElement(By.xpath(fetchProperty("LoginButton"))).click();
		bw.write("I waited for 3 seconds and then clicked on login button.");
		System.out.println(driver.findElements(By.tagName("frame")).size());
		bw.write("I am getting the count of all the frames from this webpage.");
		driver.switchTo().frame(1);
		bw.write("I switched to second frame.");
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		bw.write("And then clicked on contacts tab.");
		Thread.sleep(5000);
		driver.close();
		bw.write("I waited for 5 seconds and closed the browser.");
		bw.flush();
		bw.close();
		System.out.println("Done successfully");
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		Logs l=new Logs();
		l.LogsWriting();
	}

}
