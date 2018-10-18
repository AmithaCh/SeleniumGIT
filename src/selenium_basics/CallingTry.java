package selenium_basics;

import org.openqa.selenium.WebDriver;

public class CallingTry extends Try {
	public static WebDriver driver;
	public static void Google()
	{
		driver.get("http://www.google.com");	
	}

	public static void main(String[] args) {
		Try t=new Try();
		t.Browser();
		
	}

}
