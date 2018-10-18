package selenium_basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Try {
	public static WebDriver driver;
	
	public void Browser()
	{
		System.setProperty("webdriver.chrome.driver","E:\\Selenium prerequistes\\chromedriver.exe");
	    driver=new ChromeDriver();
	    //driver.get("http://www.google.com");
		
	}

	/*public static void main(String[] args) {
	Try t=new Try();
	driver.get("http://www.google.com");
	}*/

}
