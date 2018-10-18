package selenium_basics;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InbuiltFunctions {
	public WebDriver driver;
	Properties p;
	
	public String fetchProperty(String key) throws IOException
    {
	 p=new Properties();
	 FileInputStream fis=new FileInputStream("\\Users\\amitha\\eclipse-workspace\\Selenium\\application.properties");
	 p.load(fis);
	 String value=p.getProperty(key);
	 return value;
	}
  
	public InbuiltFunctions() throws IOException
	{
		System.setProperty("webdriver.chrome.driver","E:\\Selenium prerequistes\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		//driver.get("https://www.freecrm.com/register/");
		driver.get(fetchProperty("URL"));
		
	}
	public void isDisplayed() throws IOException
	{
	// It will check the presence of the element, before performing some operation

		WebElement chkBox = driver.findElement(By.xpath(fetchProperty("checkboxProp")));
				if(chkBox.isDisplayed())
				{
					chkBox.click();
				}
				else
				{
					System.out.println("Checkbox is not displayed / Not present in the webpage");
				}
}
	public void isEnabled() throws InterruptedException, IOException
	{
		WebElement submit = driver.findElement(By.xpath(fetchProperty("submitBTN")));
		if(submit.isEnabled())
		{
			System.out.println("It is enabled");
		}
		else
		{
			System.out.println("It is disabled");
		}
	}
	public void isSelected() throws IOException
	{
		//driver.get(fetchProperty("URL"));
		WebElement OTPchkbx=driver.findElement(By.xpath(fetchProperty("OTPchkbx")));
		if(OTPchkbx.isSelected())
		{
			System.out.println("It is selected");
		}
		else
		{
			System.out.println("It is not selected");
		}
		OTPchkbx.click();
		if(OTPchkbx.isSelected())
		{
			System.out.println("It is selected");
		}
		else
		{
			System.out.println("It is not selected");
		}
		
		
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		InbuiltFunctions ibf=new InbuiltFunctions();
		//ibf.isDisplayed();
		//ibf.isEnabled();
		  ibf.isSelected();
		
		 

	}

}
