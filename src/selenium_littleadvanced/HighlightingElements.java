package selenium_littleadvanced;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

public class HighlightingElements {
	public static WebDriver driver;
	
	public static void flash(WebElement element,WebDriver driver) throws InterruptedException, IOException
	{
		String bgcolor= element.getCssValue("backgroundColor");
		for(int i=0;i<=5;i++)
		{
			changeColor("rgb(0,200,0)",element,driver);//highlighting element
			changeColor(bgcolor,element,driver);//drawing a border
		
		}
	}
	public static void changeColor(String color,WebElement element,WebDriver driver) throws InterruptedException
	{
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.backgroundColor='"+color+"'", element);
		Thread.sleep(1000);
	}
	
	
	public static void main(String[] args) throws InterruptedException, IOException {
			System.setProperty("webdriver.chrome.driver", "E:\\Selenium prerequistes\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.amazon.com/");
			WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
			flash(searchBox,driver);
			
			driver.close();
			}

}
