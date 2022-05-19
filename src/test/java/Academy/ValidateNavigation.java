package Academy;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.Base;

public class ValidateNavigation extends Base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());

	@BeforeTest
	public void tearup() throws IOException {
		driver = initializeDriver();

		driver.get(prop.getProperty("url"));
	}

	@Test
	public void basePageNavigation() {

		LandingPage lp = new LandingPage(driver);

		System.out.println(lp.navbar().isDisplayed());

		Assert.assertTrue(lp.navbar().isDisplayed());
		log.info("Navigation bar displayed");
		log.info("ValidateNavigation");
		int menulink = lp.menulinknumber().size();

		Assert.assertEquals(menulink, 8);

	}

	@AfterTest
	public void teardown() {
		driver.close();
	}

}
