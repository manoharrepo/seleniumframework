package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	
	public WebDriver driver;
	
	private By signin = By.xpath("//a[contains(@href,'sign_in')]");
	private By featureText = By.xpath("//div[@class=\"text-center\"]/h2");
	private By navbar =By.xpath("//nav/ul[@class=\"nav navbar-nav navbar-right\"]");	
	
	private By menulinknumber = By.xpath("//ul[@class=\"nav navbar-nav navbar-right\"]/li");
	
	  public LandingPage(WebDriver driver) {
		  // TODO Auto-generated constructor stub
		  this.driver = driver; 
	  }
	 

	
	public LoginPage getLogin() {
		 driver.findElement(signin).click();
		 LoginPage llp = new LoginPage(driver);
		 return llp;
	}
	public WebElement featureText() {
		return driver.findElement(featureText);
	}
	
	public WebElement navbar() {
		return driver.findElement(navbar);
	}
	
	public List<WebElement> menulinknumber() {
		 List<WebElement> menulink =  driver.findElements(menulinknumber);
		 return menulink;
	}
}
