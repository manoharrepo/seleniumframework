package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.Base;

public class ValidateTitle extends Base {
	public WebDriver driver;
	public static Logger log =  LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void tearup() throws IOException {
		driver = initializeDriver();
 log.info("Driver Initiated");
		driver.get(prop.getProperty("url"));
		log.info("Home Page Open");
	}

	@Test
	public void basePagetitle() {

		LandingPage lp = new LandingPage(driver);
		String expect = lp.featureText().getText();
		System.out.println(expect);

		Assert.assertEquals(expect, "FEATURED COURSES");
        log.info("Heading validated");
		System.out.println(lp.navbar().isDisplayed());

		Assert.assertTrue(lp.navbar().isDisplayed());

	}

	@AfterTest
	public void teardown() {
		driver.close();
	}

}
