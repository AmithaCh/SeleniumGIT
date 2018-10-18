package selenium_basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tables {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","E:\\Selenium prerequistes\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		/*
		*/
	
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().timeouts().implicitlyWait(3L, TimeUnit.SECONDS);
		
		for(int rownum=2;rownum<=7;rownum++)
		{
			for(int colnum=1;colnum<=3;colnum++)
			{
				WebElement element=driver.findElement(By.xpath("//table[@id='customers']/tbody/tr["+rownum+"]/td["+colnum+"]"));
				System.out.println(element.getText());	
			}
		}

	}

}
