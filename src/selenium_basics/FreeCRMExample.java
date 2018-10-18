package selenium_basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FreeCRMExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","E:\\Selenium prerequistes\\chromedriver.exe" );
		WebDriver driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    //driver.get("https://www.irctc.co.in/eticketing/userSignUp.jsf");
	    driver.get("https://www.cleartrip.com/");
	  /* WebElement Checkbox=driver.findElement(By.name("agreeTerms"));
	    System.out.println(Checkbox.isSelected());
	    if(Checkbox.isSelected()==true)
	    {
	    System.out.println("Checkbox is already selected");
	    }
	    else
	    {
	    	Checkbox.click();
	    }
	  */  /*WebElement radio=driver.findElement(By.id("RoundTrip"));
	    System.out.println(radio.isEnabled());
	    if(radio.isEnabled()==true)
	    {
	    	radio.click();
	    }
	    else {
	    	System.out.println("radiobutton is in disabled state");
	    }
	    */int count=driver.findElements(By.xpath("//input[@name='trip_type']")).size();
	    for(int i=0;i<count;i++)
	    {
	    	String Text=driver.findElements(By.xpath("//input[@name='trip_type']")).get(i).getAttribute("value");
	    	//System.out.println(Text);
	    	if(Text.equals("RoundTrip"))
	    	{
	    		driver.findElements(By.xpath("//input[@name='trip_type']")).get(i).click();
	    	}
	    }
	    Select dropdown=new Select(driver.findElement(By.id("Adults")));
	    //dropdown.selectByIndex(4);
	    //dropdown.selectByValue("2");
	    dropdown.selectByVisibleText("5");
	    	}

}
