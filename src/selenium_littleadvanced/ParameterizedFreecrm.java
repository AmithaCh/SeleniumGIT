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
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ParameterizedFreecrm {
	public WebDriver driver;
	public Properties prop;
	public String inputUn;
	public String inputPswd;
	
	public String fetchProperty(String key) throws IOException
	{
		prop=new Properties();
		FileInputStream fis=new FileInputStream("\\Users\\amitha\\eclipse-workspace\\Selenium\\application.properties");
	    prop.load(fis);
	    String value=prop.getProperty(key);
		return value;
		
	}
	
	public ParameterizedFreecrm() throws IOException
	{
		System.setProperty("webdriver.chrome.driver", fetchProperty("path"));
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(fetchProperty("URL"));
	}
	
	public void FreeCRM() throws IOException, InterruptedException
	{
		File file=new File("E:\\ExcelSelenium.xlsx");
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet ws= wb.getSheet("Sheet2");
		
		for(int i=0, j=0;i<=ws.getLastRowNum();i++)
		{
			inputUn=ws.getRow(i).getCell(j).getStringCellValue();
			inputPswd=ws.getRow(i).getCell(j+1).getStringCellValue();
		
			driver.findElement(By.xpath(fetchProperty("usernameTextBox"))).sendKeys(inputUn);
			driver.findElement(By.xpath(fetchProperty("passwordTextBox"))).sendKeys(inputPswd);
			Thread.sleep(2000);
			driver.findElement(By.xpath(fetchProperty("LoginButton"))).click();
			Thread.sleep(6000);
			driver.get(fetchProperty("URL"));	
			j = 0;
			}			
}
		public void Database() throws ClassNotFoundException, SQLException, InterruptedException, IOException 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","inetsolv2580");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from login");
			
			while(rs.next())
			{
				String val=rs.getString("username");
				String val1=rs.getString("password");
				driver.findElement(By.xpath(fetchProperty("usernameTextBox"))).sendKeys(val);
				Thread.sleep(2000);
				driver.findElement(By.xpath(fetchProperty("passwordTextBox"))).sendKeys(val1);
				Thread.sleep(2000);
				driver.findElement(By.xpath(fetchProperty("LoginButton"))).click();
				Thread.sleep(2000);
				driver.get(fetchProperty("URL"));
			}
			con.close();
		}
	
	public void closing()
	{
		driver.close();
		driver.quit();
	}


	public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException, SQLException {
		ParameterizedFreecrm pf=new ParameterizedFreecrm();
		pf.FreeCRM();
		//pf.Database();
		//pf.closing();
		

	}

}
