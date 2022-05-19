package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword {
	WebDriver driver;
	private By emailId = By.id("user_email");
	private By sendme = By.cssSelector("input[value*=\"Instruction\"]");
	           
	
	public ForgotPassword(WebDriver driver) {
		// TODO Auto-generated constructor stub
		 this.driver = driver;
	}

	public WebElement getemailId() {
		return driver.findElement(emailId);
	}
	
	public WebElement sendme() {
		return driver.findElement(sendme);
	}

}

	
