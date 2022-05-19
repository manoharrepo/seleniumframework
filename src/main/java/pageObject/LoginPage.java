package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	WebDriver driver;
	private By emailId = By.id("user_email");
	private By pass = By.id("user_password");
	private By loginbtn = By.xpath("//input[contains(@type,'submit')]");
	private By  forgotpass = By.linkText("Forgot Password?");
	           
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		 this.driver = driver;
	}
	public WebElement getemail() {
		return driver.findElement(emailId);
		 }
	public WebElement getpass() {
		return driver.findElement(pass);
	}
	public WebElement loginbtn() {
		return driver.findElement(loginbtn);
	}
	

	public ForgotPassword forgotpass() {
		// TODO Auto-generated method stub
		driver.findElement(forgotpass).click();
		ForgotPassword fp = new ForgotPassword(driver);
		return fp;
	}
}

	
