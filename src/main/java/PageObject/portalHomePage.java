package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.base;

public class portalHomePage {
	
	WebDriver driver;
	private By SearchBox = By.name("query");
	

	
	public portalHomePage(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement getSearchBox()
	{
		return driver.findElement(SearchBox);
	}
	
}

