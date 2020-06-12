package stepDefinations;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObject.LandingPage;
import PageObject.LoginPage;
import PageObject.portalHomePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import junit.framework.Assert;
import resources.base;


@RunWith(Cucumber.class)
public class stepDefination extends base {

	  
	@Given("^Initialize the browser with chrome$")
	public void initialize_the_browser_with_chrome() throws Throwable {
		driver = invokeBrowser();
	   
	}

	@Given("^Navigate to \"([^\"]*)\" site$")
	public void navigate_to_site(String arg1) throws Throwable {
		driver.get(arg1);
		driver.manage().window().maximize();
	    
	}

	@Given("^Click on login link on HomePage and land on secure sign in Page$")
	public void click_on_login_link_on_HomePage_and_land_on_secure_sign_in_Page() throws Throwable {
		LandingPage lp = new LandingPage(driver);
		if(lp.getPopupSize() > 0 )
		{
			lp.getPopup().click();
		}
		lp.getLogin().click();
	   
	}

	@When("^User enters (.+)  and (.+) and logs in$")
    public void user_enters_and_and_logs_in(String username, String password) throws Throwable {
		LoginPage ll = new LoginPage(driver);
		ll.getLogin().sendKeys(username);
		ll.getPassword().sendKeys(password);
		ll.getSubmit().click();
	    
    }
		
	

	@Then("^Verify that the user is successfully logged in$")
	public void verify_that_the_user_is_successfully_logged_in() throws Throwable {
		//portalHomePage pp = new portalHomePage(driver);
		//Assert.assertTrue(pp.getSearchBox().isDisplayed());
		//LoginPage ll = new LoginPage(driver);
		//ll.getError().isDisplayed();
		System.out.println("Error Message is displayed");
	    
	}


	}



