package selenium_littleadvanced;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class HeadlessTesting {
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
	   public HeadlessTesting() throws IOException
	   {
		   driver=new HtmlUnitDriver();
		    driver.manage().window().maximize();
		    driver.get(fetchProperty("URL"));
		    System.out.println(driver.getTitle());
			   
	   }
	   

	public static void main(String[] args) throws IOException  {
		HeadlessTesting ht=new HeadlessTesting();
	

	}

}
