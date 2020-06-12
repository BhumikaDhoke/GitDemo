package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObject.LandingPage;
import PageObject.LoginPage;
import resources.base;

public class HomePage extends base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void intialization() throws IOException
	{
		driver = invokeBrowser();
		log.info("Browser Initiated");
		
	}
	
	@Test(dataProvider = "getData")
	public void basePageNavigation(String Username, String Password, String Text) throws IOException
	{
		
		driver.get(prop.getProperty("url"));
		log.info("Landed to Home page");
		driver.manage().window().maximize();
		LandingPage lp = new LandingPage(driver);
		lp.getLogin().click();
		log.info("Landed to Landed page");
		LoginPage ll = new LoginPage(driver);
		ll.getLogin().sendKeys(Username);
		log.info("Username Entered");
		ll.getPassword().sendKeys(Password);
		log.info("Password Entered");
		log.info(Text);
		ll.getSubmit().click();
		
		
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	@DataProvider
	public Object[][] getData()
	{
		Object[][]data =  new Object[2][3];
		data[0][0] = "registered@gmail.com";
		data[0][1] = "May@2019";
		data[0][2] = "Registered User";
		data[1][0] = "non-registered@gmail.com";
		data[1][1] = "May@2019";
		data[1][2] = "Non-Registered User";
		return data;
	}
	
	

}
