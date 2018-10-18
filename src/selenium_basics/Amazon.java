package selenium_basics;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","E:\\Selenium prerequistes\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.com/");
		List<WebElement> count=driver.findElements(By.tagName("input"));
		System.out.println(count.size());
		List<WebElement> Links=driver.findElements(By.tagName("a"));
		System.out.println(Links.size());
		for(int i=0;i<Links.size();i++)
		{
			String DisplayTexts=Links.get(i).getText();
			System.out.println(DisplayTexts);
		}

	}

}
