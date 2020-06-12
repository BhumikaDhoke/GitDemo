package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class base {
	public static WebDriver driver;
	public Properties prop;
	
	public WebDriver invokeBrowser() throws IOException
	{
		 prop = new Properties();
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		//String browserName = System.getProperty("browser");//if we want to send the browser in the maven command and not from the data file.
		String browserName = prop.getProperty("browser");
		
		if(browserName.contains("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe");
			
		if(browserName.contains("headless"))	
		{
			ChromeOptions option = new ChromeOptions();
			option.addArguments("headless","user-agent=mrbean");
			driver = new ChromeDriver(option);
		}
		else {
			driver = new ChromeDriver();
		}
		
		}
		else if(browserName.equals("firefox"))
		{
			
		}
		else if(browserName.equals("IE"))
		{
			
		}
		return driver;
		
	}
	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}
	
	
	
	

}
