package selenium_basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

public class BrowserLaunching {
	public WebDriver driver;
	public void launchingOpera()
	{
		System.setProperty("webdriver.opera.driver","E:\\Selenium prerequistes\\operadriver_win64\\operadriver.exe");
		driver=new OperaDriver();
		
	}
	public void launchingChrome()
	{
		System.setProperty("webdriver.chrome.driver","E:\\Selenium prerequistes\\chromedriver.exe");	
		driver=new ChromeDriver();
	}
	
	public void launchingFirefox()
	{
		System.setProperty("webdriver.gecko.driver","E:\\Selenium prerequistes\\geckodriver.exe");	
		driver=new FirefoxDriver();
	}
	public void launchingInternetExplorer()
	{
		System.setProperty("webdriver.ie.driver","E:\\Selenium prerequistes\\IEDriverServer.exe");	
		driver=new InternetExplorerDriver();
	}
	
	public static void main(String[] args) {
		BrowserLaunching b=new BrowserLaunching();
		//b.launchingOpera();
		//b.launchingChrome();
		//b.launchingFirefox();
		b.launchingInternetExplorer();
		
	}

}
