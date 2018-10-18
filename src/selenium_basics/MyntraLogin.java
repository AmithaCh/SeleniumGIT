package selenium_basics;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MyntraLogin {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium prerequistes\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.myntra.com/");
		/*Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//span[@data-reactid='513']"))).build().perform();
		driver.manage().timeouts().implicitlyWait(2L, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@data-reactid='524']")).click();
		driver.findElement(By.name("email")).sendKeys("amitha.chidurala46@gmail.com");
		driver.findElement(By.name("password")).sendKeys("amitha12345@");
		driver.findElement(By.xpath("//button[@class='login-login-button']")).click();
		driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
		*/driver.findElement(By.xpath("//input[@data-reactid='529']")).sendKeys("Earrings");
		driver.findElement(By.xpath("//input[@data-reactid='529']")).sendKeys(Keys.ENTER);
		/*JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,-5000)");
		*/WebElement we=driver.findElement(By.xpath("//*[@id='mountRoot']/div/main/div[2]/div[1]/section/div/div[3]/ul/li[1]/label/input"));
		//div[@class='vertical-filters-filters']/ul[@class='price-list']/li/label/input"));
		
		//for(int i=0;i<list.size();i++) {
		System.out.println(we.getText());
		/*if(list.get(i).getText().equalsIgnoreCase("Rs. 147 to Rs. 449"))
          {
			list.get(i).click();
          }
		*/
		//
		//*[@id="mountRoot"]/div/main/div[2]/div[1]/section/div/div[3]/ul/li[1]/label/input
	}

	}

