package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObject.LandingPage;
import junit.framework.Assert;
import resources.base;

public class Validation extends base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	LandingPage lp;
	@BeforeTest
	public void intialization() throws IOException
	{
		driver = invokeBrowser();
		log.info("Browser Initiated");
		driver.get(prop.getProperty("url"));
		log.info("Landed to Home page");
		driver.manage().window().maximize();
	}
	
	@Test
	public void validateCourses() throws IOException
	{
		
		
		lp = new LandingPage(driver);
		Assert.assertEquals(lp.getValidation().getText(), "FEATURED COURSES");
		log.info("Validation 1 Passed");
		Assert.assertTrue(lp.getCourseValidation().isDisplayed());
		log.info("Validation 2 Passed");
	}
	
	@Test
	public void headerValidation()
	{
		
		Assert.assertEquals(lp.getHeader().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
		log.info("Validation 1 Passed");
	}
	@AfterTest
	public void teardown()
	{
		driver.close();
	}

}
