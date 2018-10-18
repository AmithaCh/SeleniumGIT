package selenium_basics;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserPopups {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","E:\\Selenium prerequistes\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://popuptest.com/goodpopups.html");
		
		driver.findElement(By.linkText("Good PopUp #1")).click();
		Set<String> ids=driver.getWindowHandles();
		
		Iterator<String> it=ids.iterator();
		String parent_id=it.next();
		String child_id=it.next();
		//System.out.println(parent_id);
		//System.out.println(child_id);
		driver.switchTo().window(child_id);
		System.out.println("First child title:");
		System.out.println(driver.getTitle());
		driver.close();
		
		
		driver.switchTo().window(parent_id);
		System.out.println("Parent title:");
		System.out.println(driver.getTitle());
		driver.findElement(By.linkText("Good PopUp #2")).click();
		Set<String> child_ids=driver.getWindowHandles();
		Iterator<String> ite=child_ids.iterator();
		String parent_ids=ite.next();
		String child_ide=ite.next();
		driver.switchTo().window(child_ide);
		System.out.println("Second child title:");
		System.out.println(driver.getTitle());
		driver.close();
		
		driver.switchTo().window(parent_ids);
		//System.out.println(driver.getTitle());
		driver.findElement(By.linkText("Good PopUp #3")).click();
		Set<String> id=driver.getWindowHandles();
		Iterator<String> iter=id.iterator();
		String parentID=iter.next();
		String childID=iter.next();
		driver.switchTo().window(childID);
		System.out.println("Third child title:");

		System.out.println(driver.getTitle());
		driver.close();
		
		driver.switchTo().window(parentID);
		driver.findElement(By.linkText("Good PopUp #4")).click();
		Set<String> last_id=driver.getWindowHandles();
		Iterator<String> itera=last_id.iterator();
		String parentIDs=itera.next();
		String childIDs=itera.next();
		driver.switchTo().window(childIDs);
		System.out.println("Fourth child title:");

		
		System.out.println(driver.getTitle());
		driver.close();
		driver.quit();
		
	
		

	}

}
