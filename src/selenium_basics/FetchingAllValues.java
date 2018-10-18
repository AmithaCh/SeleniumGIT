package selenium_basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FetchingAllValues {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","E:\\Selenium prerequistes\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.irctc.co.in/eticketing/userSignUp.jsf");
		Select select=new Select(driver.findElement(By.id("userRegistrationForm:countries")));
		List<WebElement> countries=select.getOptions();
		
		for(WebElement element:countries)
		{
			System.out.println(element.getText());
			if(element.getText().equals("Jamaica"))
			{
				System.err.println("Element found");
				
			}
			
		}
	}

}
