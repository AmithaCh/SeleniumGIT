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

public class JavaScriptExecutor {
	public static WebDriver driver;
	
	public static void drawBorder(WebElement element,WebDriver driver) throws IOException
	{
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.border='3px solid red'", element);
		
	}
	public static void generateAlert(WebDriver driver,String message)
	{
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("alert('"+message+"')");
		
	}
	
	public static void clickElementByJS(WebElement element,WebDriver driver)
	{
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
		
	}
	public static void refreshBrowserByJS(WebDriver driver)
	{
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("history.go(0)");
	
	}
	public static String getTitleByJS(WebDriver driver)
	{
		JavascriptExecutor js= (JavascriptExecutor)driver;
		String title=js.executeScript("return document.title;").toString();
		return title;
	}
	public static String getInnerTextByJS(WebDriver driver)
	{
		JavascriptExecutor js= (JavascriptExecutor)driver;
		String pageText=js.executeScript("return document.documentElement.innerText;").toString();
		return pageText;
	}
	
	public static void scrollDown(WebDriver driver)
	{
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		//js.executeScript("window.scrollBy(0,-5000");
	}
	
	public static void scrollIntoView(WebElement element, WebDriver driver)
	{
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}
	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium prerequistes\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		//WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
		driver.findElement(By.id("email")).sendKeys("amithachidu");
		driver.findElement(By.id("pass")).sendKeys("welcome123");
		
		driver.manage().timeouts().implicitlyWait(3L, TimeUnit.SECONDS);
		WebElement loginBtn=driver.findElement(By.xpath("//input[@value='Log In']"));
		
		drawBorder(loginBtn,driver);
		
		//Taking screenshot
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("E:\\MindQ\\Framework\\Screenshots\\searchBox.jpg"));
		
		//creating a customized alert by JS
		generateAlert(driver,"There is an issue with login button");
		driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
		driver.switchTo().alert().accept();
		
		//clickElementByJS(loginBtn,driver);//clicking on element by JS
		
		//refreshing browser using selenium
		driver.navigate().refresh();
		
		//refreshing the browser by JS
		refreshBrowserByJS(driver);
		
		//get title by JS
		System.out.println(getTitleByJS(driver));
		
		//get page text by JS, there is no method in selenium to get the inner text
		//System.out.println(getInnerTextByJS(driver));
		
		//scroll down by JS
		scrollDown(driver);
		WebElement instaLink=driver.findElement(By.linkText("Instagram"));
		
		//scrolling down until you find specific element
		scrollIntoView(instaLink,driver);
		
		

	}

}
