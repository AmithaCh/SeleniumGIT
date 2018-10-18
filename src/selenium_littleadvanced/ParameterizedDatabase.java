package selenium_littleadvanced;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ParameterizedDatabase {
	public WebDriver driver;
	public Properties prop;
	public String input;
	
	public String fetchProperty(String key) throws IOException
	{
		prop=new Properties();
		FileInputStream fis=new FileInputStream("\\Users\\amitha\\eclipse-workspace\\Selenium\\application.properties");
	    prop.load(fis);
	    String value=prop.getProperty(key);
		return value;
		
	}
	
	public ParameterizedDatabase() throws IOException
	{
		System.setProperty("webdriver.chrome.driver", fetchProperty("path"));
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		//driver.get(fetchProperty("URL"));
		driver.get("https://www.google.com/");
	}
	
	public void Database() throws ClassNotFoundException, SQLException, IOException, InterruptedException
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","inetsolv2580");
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select * from search");
		
		while(rs.next())
		{
			String val=rs.getString("searchValue");
			driver.findElement(By.name("q")).sendKeys(val);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@value='Google Search']")).click();
			Thread.sleep(2000);
			//driver.get(fetchProperty("URL"));
			driver.get("https://www.google.com/");
			
		}
		con.close();
	}
	public void closing()
	{
		driver.close();
		driver.quit();
	}


	public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException, SQLException {
		ParameterizedDatabase pf=new ParameterizedDatabase();
		pf.Database();
		//pf.closing();
		

	}

}
