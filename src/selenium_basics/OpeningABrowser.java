package selenium_basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpeningABrowser {
public WebDriver driver;

public OpeningABrowser()
{
	System.setProperty("webdriver.chrome.driver","E:\\Selenium prerequistes\\chromedriver.exe" );
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.amazon.com");
	
	
	//driver.close();
	
}
public void search()
{
	driver.findElement(By.name("q")).click();
	WebElement element=driver.findElement(By.name("q"));
	element.sendKeys("Rest Api wiki");
	element.submit();
	//driver.findElement(By.id("gsr")).click();
}
public void nextSearch()
{
	WebElement searchbox=driver.findElement(By.id("twotabsearchtextbox"));
	searchbox.click();
	searchbox.sendKeys("Samsung s9");
	driver.findElement(By.className("nav-input")).click();
	//searchbox.submit();
	driver.findElement(By.linkText("Today's Deals")).click();
	driver.findElement(By.xpath("//span[@class='a-size-small a-color-base']")).click();
	
}

	public static void main(String[] args) {
		
		OpeningABrowser Ob=new OpeningABrowser();
		//Ob.ChromeBrowser();
		Ob.nextSearch();
	}

}
