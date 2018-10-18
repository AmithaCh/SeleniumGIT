package selenium_littleadvanced;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PickingSuggestion {
	public static WebDriver driver;
	public Properties prop;

	public String fetchProperty(String key) throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"\\Users\\amitha\\eclipse-workspace\\Selenium\\application.properties");
		prop.load(fis);
		String value = prop.getProperty(key);
		return value;

	}

	public PickingSuggestion() throws IOException {
		System.setProperty("webdriver.chrome.driver", fetchProperty("path"));
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");

	}

	public void PickingASuggestion() throws InterruptedException {
		driver.findElement(By.name("q")).sendKeys("selenium");
		Thread.sleep(3000);
		driver.findElement(By.name("q")).sendKeys(Keys.DOWN);
		Thread.sleep(3000);
		driver.findElement(By.name("q")).sendKeys(Keys.DOWN);
		driver.findElement(By.name("q")).sendKeys(Keys.DOWN);
		Thread.sleep(3000);
		driver.findElement(By.name("q")).sendKeys(Keys.DOWN);
		driver.findElement(By.name("q")).sendKeys(Keys.DOWN);
		driver.findElement(By.name("q")).sendKeys(Keys.DOWN);
		driver.findElement(By.name("q")).sendKeys(Keys.DOWN);
		Thread.sleep(3000);
		driver.findElement(By.name("q")).sendKeys(Keys.DOWN);

		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

	}

	public void PickingSuggestionUsingDynamicXpath() throws InterruptedException {
		driver.findElement(By.name("q")).sendKeys("selenium");
		Thread.sleep(3000);
		List<WebElement> options = driver.findElements(By.xpath
		("//ul[@role='listbox']/li/div/descendant::div[@class='sbl1']"));
		int size = options.size();
		for (int i = 0; i <= size; i++) {
			if (options.get(i).getText().equals("selenium webdriver")) {
				options.get(i).click();
			}
		}

	}
	

	public static void main(String[] args) throws IOException, InterruptedException {

		PickingSuggestion ps = new PickingSuggestion();
		// ps.PickingASuggestion();
		ps.PickingSuggestionUsingDynamicXpath();

	}

}
