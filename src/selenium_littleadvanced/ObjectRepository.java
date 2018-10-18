package selenium_littleadvanced;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ObjectRepository {
    public WebDriver driver;
    Properties p;
    //String Browser="Chrome";
    //creating a function to read values from properties file
   public String fetchProperty(String key) throws IOException
     {
	 p=new Properties();
	 FileInputStream fis=new FileInputStream("\\Users\\amitha\\eclipse-workspace\\Selenium\\application.properties");
	 p.load(fis);
	 String value=p.getProperty(key);
	 return value;
	}
   //creating a constructor
   public ObjectRepository() throws IOException
   {
	   String Browser=fetchProperty("browser");
		 if(Browser.equals("Chrome"))
		 {
			 System.setProperty("webdriver.chrome.driver", fetchProperty("path"));
			   driver= new ChromeDriver();    
		 }
		 else if(Browser.equals("Firefox"))
		 {
			 System.setProperty("webdriver.gecko.driver", fetchProperty("Firefoxpath"));
			   driver= new FirefoxDriver();    
		 }
		 else if(Browser.equals("InternetExplorer"))
		 {
			 System.setProperty("webdriver.ie.driver", fetchProperty("IEpath"));
			   driver= new InternetExplorerDriver();    
		 }
		
	   
	   //System.setProperty("webdriver.chrome.driver", fetchProperty("path"));
	   //driver= new ChromeDriver();
	   driver.manage().window().maximize();
	   driver.get(fetchProperty("URL"));
	   
   }
   
   public void Login() throws IOException, InterruptedException
   {
	   driver.findElement(By.xpath(fetchProperty("usernameTextBox"))).sendKeys(fetchProperty("username"));
	   driver.findElement(By.xpath(fetchProperty("passwordTextBox"))).sendKeys(fetchProperty("password"));
	   Thread.sleep(3000);
	   driver.findElement(By.xpath(fetchProperty("LoginButton"))).click();
	   
   }

	public static void main(String[] args) throws IOException, InterruptedException {
		
		ObjectRepository or=new ObjectRepository();
		or.Login();
	}

}
