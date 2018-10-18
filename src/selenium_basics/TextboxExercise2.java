package selenium_basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TextboxExercise2 {
	public WebDriver driver;
	public void launchingChrome()
	{
		System.setProperty("webdriver.chrome.driver","E:\\Selenium prerequistes\\chromedriver.exe");	
		driver=new ChromeDriver();
		driver.get("https://www.irctc.co.in/eticketing/userSignUp.jsf");
		
		driver.findElement(By.id("userRegistrationForm:userName")).click();
		driver.findElement(By.id("userRegistrationForm:userName")).sendKeys("randomuser");
		
		driver.findElement(By.id("userRegistrationForm:password")).click();
		driver.findElement(By.id("userRegistrationForm:password")).sendKeys("user123");
		
		driver.findElement(By.id("userRegistrationForm:confpasword")).click();
		driver.findElement(By.id("userRegistrationForm:confpasword")).sendKeys("user123");
		
		Select s=new Select(driver.findElement(By.id("userRegistrationForm:securityQ")));
		s.selectByValue("0");
		
		driver.findElement(By.xpath("//input[@id='userRegistrationForm:securityAnswer']")).click();
		driver.findElement(By.xpath("//input[@id='userRegistrationForm:securityAnswer']")).sendKeys("Cherry");
		
		Select s1=new Select(driver.findElement(By.id("userRegistrationForm:prelan")));
		s1.selectByVisibleText("English");

		driver.findElement(By.cssSelector("input[id='userRegistrationForm:firstName']")).click();
		driver.findElement(By.cssSelector("input[id='userRegistrationForm:firstName']")).sendKeys("Temporary");
		
		driver.findElement(By.cssSelector("input[id='userRegistrationForm:middleName']")).click();
		driver.findElement(By.cssSelector("input[id='userRegistrationForm:middleName']")).sendKeys("Random");
		
		driver.findElement(By.cssSelector("input[id='userRegistrationForm:lastName']")).click();
		driver.findElement(By.cssSelector("input[id='userRegistrationForm:lastName']")).sendKeys("User");
		
		driver.findElement((By.id("userRegistrationForm:gender:1"))).click();
		driver.findElement((By.id("userRegistrationForm:maritalStatus:0"))).click();
		
		Select s2=new Select(driver.findElement(By.id("userRegistrationForm:dobDay")));
		s2.selectByVisibleText("22");
		
		Select s3=new Select(driver.findElement(By.id("userRegistrationForm:dobMonth")));
		s3.selectByVisibleText("JAN");
		
		Select s4=new Select(driver.findElement(By.id("userRegistrationForm:dateOfBirth")));
		s4.selectByVisibleText("1991");
		
		Select s5=new Select(driver.findElement(By.id("userRegistrationForm:occupation")));
		s5.selectByVisibleText("Others");
		
		driver.findElement(By.name("userRegistrationForm:uidno")).click();
		driver.findElement(By.name("userRegistrationForm:uidno")).sendKeys("1234567890");
		
		driver.findElement(By.name("userRegistrationForm:idno")).click();
		driver.findElement(By.name("userRegistrationForm:idno")).sendKeys("9876543210");
		
		Select s6= new Select(driver.findElement(By.id("userRegistrationForm:countries")));
		s6.selectByVisibleText("India");
		
		driver.findElement(By.id("userRegistrationForm:email")).click();
		driver.findElement(By.id("userRegistrationForm:email")).sendKeys("randomuser@gmail.com");
		
		driver.findElement(By.id("userRegistrationForm:mobile")).click();
		driver.findElement(By.id("userRegistrationForm:mobile")).sendKeys("8888888888");
		
		Select s7= new Select(driver.findElement(By.id("userRegistrationForm:nationalityId")));
		s7.selectByVisibleText("India");
		
		driver.findElement(By.id("userRegistrationForm:address")).click();
		driver.findElement(By.id("userRegistrationForm:address")).sendKeys("1862");
		
		driver.findElement(By.id("userRegistrationForm:street")).click();
		driver.findElement(By.id("userRegistrationForm:street")).sendKeys("Hanamkonda");
		
		driver.findElement(By.id("userRegistrationForm:area")).click();
		driver.findElement(By.id("userRegistrationForm:area")).sendKeys("Kazipet");
		
		driver.findElement(By.cssSelector("input[id='userRegistrationForm:pincode']")).click();
		driver.findElement(By.cssSelector("input[id='userRegistrationForm:pincode']")).sendKeys("506001");
		
		driver.findElement(By.cssSelector("input[id='userRegistrationForm:statesName']")).click();
		//driver.findElement(By.cssSelector("input[id='userRegistrationForm:statesName']")).sendKeys("ANDHRA PRADESH");
		
	    Select s8= new Select(driver.findElement(By.id("userRegistrationForm:cityName")));
	    s8.selectByVisibleText("Warangal");
		
		Select s9= new Select(driver.findElement(By.id("userRegistrationForm:postofficeName")));
		s9.selectByVisibleText("Hanamkonda H.O");
		
		
		driver.findElement(By.xpath("//input[@id='userRegistrationForm:landline']")).click();
		driver.findElement(By.xpath("//input[@id='userRegistrationForm:landline']")).sendKeys("7777777777");
		
		//driver.close();
		
	}
	

	public static void main(String[] args) {
		TextboxExercise2 t=new TextboxExercise2();
		t.launchingChrome();

	}

}
