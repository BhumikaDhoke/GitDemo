package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	WebDriver driver;
	
	private By signIn = By.xpath("//*[@id=\"homepage\"]/header/div[1]/div/nav/ul/li[4]/a/span");
	private By checkText = By.xpath("//div[@class= 'text-center']/h2");
	private By courses = By.xpath("//ul[@class ='nav navbar-nav navbar-right']");
	private By header = By.xpath("//div[contains (@class, 'video-banner')]/h3");
	private By popup = By.xpath("//button[text() = 'NO THANKS']");
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getLogin()
	{
		return driver.findElement(signIn);
	}
	public WebElement getValidation()
	{
		return driver.findElement(checkText);
	}
	public WebElement getCourseValidation()
	{
		return driver.findElement(courses);
	}
	public WebElement getHeader()
	{
		return driver.findElement(header);
	}
	public int getPopupSize()
	{
		return driver.findElements(popup).size();
	}
	public WebElement getPopup()
	{
		return driver.findElement(popup);
	}


}
