package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	WebDriver driver;
	private By login = By.xpath("//input[@id = 'user_email']");
	private By password = By.xpath("//input[@id = 'user_password']");
	private By submit = By.xpath("//input[@value = 'Log In']");
	private By error = By.xpath("//div[@class = 'alert alert-danger']");

	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement getLogin()
	{
		return driver.findElement(login);
	}
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	public WebElement getSubmit()
	{
		return driver.findElement(submit);
	}
	public WebElement getError()
	{
		return driver.findElement(error);
	}

}

