package selenium_basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Calendar {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","E:\\Selenium prerequistes\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.freecrm.com/index.html");
		driver.findElement(By.name("username")).sendKeys("badri_20");
		Thread.sleep(2000);
		driver.findElement(By.name("password")).sendKeys("welcome123");
		Thread.sleep(2000);
		//driver.manage().timeouts().implicitlyWait(3L, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	
		String input="15-August-2019";
		String arr[]=input.split("-");
		
		String date=arr[0];
		String month=arr[1];
		String year=arr[2];
		
		driver.switchTo().frame("mainpanel");
		
		Select Spcmonth=new Select(driver.findElement(By.name("slctMonth")));
		Spcmonth.selectByVisibleText(month);
		
		Select Spcyear=new Select(driver.findElement(By.name("slctYear")));
		Spcyear.selectByVisibleText(year);
		//boolean temp=false;
		
		//selecting date
		for(int rownum=2;rownum<=6;rownum++)
		{
			for(int colnum=1;colnum<=7;colnum++)
			{
				WebElement element=driver.findElement(By.xpath("//table[@class='crmcalendar']/tbody/tr[2]/td/table/tbody/tr["+rownum+"]/td["+colnum+"]"));
				String Spcdate=element.getText();
				if(Spcdate.equals(date))
				{
					element.click();
					//temp=true;
					break;
				}
			}
			/*if(temp=false)
			{
				break;
			}*/
		//break;
		}
		
		
		
		

	}

}
