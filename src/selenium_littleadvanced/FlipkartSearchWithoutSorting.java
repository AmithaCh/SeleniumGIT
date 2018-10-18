package selenium_littleadvanced;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipkartSearchWithoutSorting {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium prerequistes\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		WebElement search=driver.findElement(By.xpath("//input[@title='Search for products, brands and more']"));
		search.click();
		search.sendKeys("laptops");
		search.submit();
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@title='Acer']//div[@class='_1p7h2j']")));
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,250)","");
		driver.findElement(By.xpath("//div[@title='Acer']//div[@class='_1p7h2j']")).click();
		
		WebDriverWait wait1=new WebDriverWait(driver,30);
		wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Newest First']")));
		Thread.sleep(3000);
		
		
		//driver.findElement(By.xpath("//div[@class='_1xHtJz xufquN']")).click();
		
		/*WebElement element=driver.findElement(By.xpath("//div[@class='_1vC4OE _2rQ-NK']"));
		*/
		List<WebElement> links=driver.findElements(By.xpath("//div[@class='_1vC4OE _2rQ-NK']"));
		List<WebElement> element=driver.findElements(By.xpath("//div[class='_3wU53n']"));
		int largestPrice=0,elementindex=0,i=0;
		
		for(WebElement we:links)
		{
			//i.get(0).click();
			
			String amount=we.getText();
			int length=amount.length();
			String price=amount.substring(1, length);
			price=price.replaceAll(",", "");
			int priceInt=Integer.parseInt(price);
			
			System.out.println("Amount : "+priceInt);
			Thread.sleep(1000);
			
			if(priceInt>largestPrice)
			{
				largestPrice=priceInt;
				elementindex=i;
				
			}
			i++;
			
		}
		/*JavascriptExecutor jse= (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true);",element.get(elementindex-1));
		
		WebDriverWait wait2=new WebDriverWait(driver,30);
		
		wait2.until(ExpectedConditions.elementToBeClickable(element.get(elementindex)));
	    */
	    //element.get(elementindex).click();	
		
		
	}

}
