package selenium_littleadvanced;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrokenLinks {
	public WebDriver driver;
	public Properties prop;
    public int responseCode;

	public String fetchProperty(String key) throws IOException
	{
		prop=new Properties();
		FileInputStream fis=new FileInputStream("\\Users\\amitha\\eclipse-workspace\\Selenium\\application.properties");
		prop.load(fis);
		String value=prop.getProperty(key);
        return value;
	
	}
	public BrokenLinks() throws IOException
	{
		System.setProperty("webdriver.chrome.driver", fetchProperty("path"));
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(fetchProperty("URL"));
		
	}
	public void brokenlinks() throws MalformedURLException, IOException
	{
		// Fetching all the links from the given webpage
	    List<WebElement> links=driver.findElements(By.tagName("a"));
	    // Creation of ArrayList
		ArrayList<WebElement> activeLinks=new ArrayList();
		// Identifying href which are not null
        for(int i=0;i<links.size();i++)
		{
			if(links.get(i).getAttribute("href")!=null && (!links.get(i).getAttribute("href").contains("javascript")))
			{
				activeLinks.add(links.get(i));
				 // here we are storing all the links which are having proper href 
				//(href which are not null)
			}
		}
		// Capturing of response code using HTTPUrlConnection Class
		for(int i=0;i<activeLinks.size();i++)
		{
			HttpURLConnection connection = (HttpURLConnection)new URL
					(activeLinks.get(i).getAttribute("href")).openConnection();
			// we are establishing a connection with the URL
			connection.connect();
			responseCode=connection.getResponseCode();
			if(responseCode!=200)
			{
			System.out.println(activeLinks.get(i).getAttribute("href")+ "--->" +responseCode);
			}
			//System.out.println(activeLinks.get(i).getAttribute("href")+ "-->" +responseCode);
			connection.disconnect();
			
		}	
	}
	public void close()
	{
		driver.close();
		driver.quit();
	}

	public static void main(String[] args) throws IOException
	  {
		BrokenLinks bl =new BrokenLinks();
		bl.brokenlinks();
		bl.close();
	}

}
