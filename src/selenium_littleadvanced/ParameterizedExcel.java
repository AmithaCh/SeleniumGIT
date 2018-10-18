package selenium_littleadvanced;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//import com.gargoylesoftware.htmlunit.javascript.host.file.File;

public class ParameterizedExcel {
	public WebDriver driver;
	public Properties prop;
	public String input;
    
	public ParameterizedExcel() throws IOException
	{
		System.setProperty("webdriver.chrome.driver", fetchProperty("path"));
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(fetchProperty("URL"));
		
	}
		public String fetchProperty(String key) throws IOException
		{
			prop=new Properties();
			FileInputStream fis=new FileInputStream("\\Users\\amitha\\eclipse-workspace\\Selenium\\application.properties");
			prop.load(fis);
			String value=prop.getProperty(key);
	        return value;
		}
		public void ReadingValuesFromExcel() throws IOException, InterruptedException 
		{
			File src=new File("E:\\ExcelSelenium.xlsx");
			FileInputStream fis=new FileInputStream(src);
			
			XSSFWorkbook wb= new XSSFWorkbook(fis);
			XSSFSheet ws=wb.getSheetAt(0);
			for(int i=0;i<=ws.getLastRowNum();i++)
			{
				input=ws.getRow(i).getCell(0).getStringCellValue();
				driver.findElement(By.name(fetchProperty("GoogleSearchBox"))).sendKeys(input);
		        Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@value='Google Search']")).click();
				Thread.sleep(2000);
				driver.get(fetchProperty("URL"));	
			}	
		}
		public void closing()
		{
			driver.close();
			driver.quit();
		}

	public static void main(String[] args) throws IOException, InterruptedException {
		
		ParameterizedExcel pe=new ParameterizedExcel();
		pe.ReadingValuesFromExcel();
		pe.closing();
		
	}

}
