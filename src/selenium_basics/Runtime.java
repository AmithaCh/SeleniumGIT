package selenium_basics;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Runtime {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","E:\\Selenium prerequistes\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//driver.google();
		
		driver.get("http://www.spicejet.com");
		//System.out.println(driver.getCurrentUrl());
		Scanner scan=new Scanner(System.in);
		String URL=scan.nextLine();
		URL=driver.getCurrentUrl();
		System.out.println(URL);
	}

}
