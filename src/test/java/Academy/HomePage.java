package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.ForgotPassword;
import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.Base;

public class HomePage extends Base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());

	@BeforeTest
	public void tearup() throws IOException {
		driver = initializeDriver();

	}

	@Test(dataProvider = "getdata")
	public void basePageNavigation(String username, String pass, String text) {

		driver.get(prop.getProperty("url"));
		LandingPage lp = new LandingPage(driver);
		System.out.println(lp.featureText().getText());
		LoginPage login = lp.getLogin();
		login.getemail().sendKeys(username);
		login.getpass().sendKeys(pass);
		log.info(text);
		login.loginbtn().click();
		ForgotPassword fp= login.forgotpass();
		fp.getemailId().sendKeys("XXX");
		fp.sendme().click();
	}

	@DataProvider
	public Object[][] getdata() {
		Object[][] data = new Object[2][3];

		data[0][0] = "norestrictionuser.com";
		data[0][1] = "12345";
		data[0][2] = "No Restrict user";

		data[1][0] = "restrictionuser.com";
		data[1][1] = "1234";
		data[1][2] = "Restriction user";

		return data;
	}

	@AfterTest
	public void teardown() {
		driver.close();
	}

}
