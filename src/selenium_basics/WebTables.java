package selenium_basics;

import java.awt.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTables {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","E:\\Selenium prerequistes\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.cricbuzz.com/live-cricket-scorecard/20338/inda-vs-wia-3rd-match-india-a-tri-series-in-england-2018");
		driver.manage().timeouts().implicitlyWait(3L, TimeUnit.SECONDS);
		WebElement table=driver.findElement(By.xpath("//div[@class='cb-col cb-col-100 cb-ltst-wgt-hdr']"));
		table.findElements(By.cssSelector("cb-col cb-col-100 cb-scrd-itms")).size();
		
		int count=table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(2)")).size();
		for(int i=0;i<count-2;i++)
		{
			String tableValues=table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(2)")).get(i).getText();
			System.out.println(tableValues);
		}
	}
	}


