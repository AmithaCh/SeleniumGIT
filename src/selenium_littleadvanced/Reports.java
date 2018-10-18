package selenium_littleadvanced;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Reports {
	public WebDriver driver;
	public Properties prop;
	public ExtentReports report;
	public ExtentTest logger;
	
	public String fetchProperty(String key) throws IOException
	{
		prop=new Properties();
		FileInputStream fis=new FileInputStream("\\Users\\amitha\\eclipse-workspace\\Selenium\\application.properties");
	    prop.load(fis);
	    String value=prop.getProperty(key);
		return value;
		
	}
	 
	public Reports() throws IOException, InterruptedException
	{
	report=new ExtentReports(fetchProperty("GeneratedReportsPath"));
	logger=report.startTest("Login Testing");
	System.setProperty("webdriver.chrome.driver", fetchProperty("path"));
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get(fetchProperty("URL"));
	logger.log(LogStatus.INFO, " FreeCRM page got loaded");
	Thread.sleep(3000);
	}
	
	public void GoogleSearch() throws InterruptedException, IOException
	{
		/*driver.findElement(By.name("q")).sendKeys("Flipkart");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='Google Search']")).click();*/
		logger.log(LogStatus.INFO, "Application is up and running");
		String title=driver.getTitle();
		if(title.contains("Google"))
		{
			logger.log(LogStatus.PASS, "Title verified");	
		}
		
		report.flush();
		driver.get(fetchProperty("GeneratedReportsPath"));
		
	}
	public void FreeCRMLogin() throws IOException, InterruptedException
	{
		driver.findElement(By.xpath(fetchProperty("usernameTextBox"))).sendKeys("badri_20");
		driver.findElement(By.xpath(fetchProperty("passwordTextBox"))).sendKeys("welcome123");
		logger.log(LogStatus.INFO, "Entered username and password");
		Thread.sleep(3000);
		driver.findElement(By.xpath(fetchProperty("LoginButton"))).click();
		logger.log(LogStatus.INFO, "FreeCRM page got loaded");
		String title=driver.getTitle();
		if(title.equals("CRMPRO"))
		{
			logger.log(LogStatus.PASS, "Successfully signed in with Google Chrome");	
		}
		else
		{
			logger.log(LogStatus.FAIL, "Failed to sign in");
		}
		
		
		report.flush();
		driver.get(fetchProperty("GeneratedReportsPath"));


	}
	public static void main(String[] args) throws IOException, InterruptedException {
		Reports r=new Reports();
		//r.GoogleSearch();
		r.FreeCRMLogin();
	}

}
