package resources;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	public WebDriver driver;
	public Properties prop = new Properties();

	public WebDriver initializeDriver() throws IOException {

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browsername = prop.getProperty("browser");

		// mvn test -Dbrowsername=chrome
		// String browsername = System.getProperty("browsername"); 
		//System.out.println(browsername);
		if (browsername.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			if (browsername.contains("headless")) {
				options.addArguments("--headless");
			}
			driver = new ChromeDriver(options);
		} else if (browsername.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\Manohar Joshi\\Downloads\\geckodriver\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browsername.equals("IE")) {
			System.setProperty("webdriver.edge.driver",
					"C:\\Users\\Manohar Joshi\\Downloads\\edgedriver\\msedgedriver.exe");
			driver = new EdgeDriver();
		} else {
			System.out.println("No Browser specified");
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}

	public String getScreenShotPath(String testname, WebDriver driver) throws IOException {
		TakesScreenshot tc = (TakesScreenshot) driver;

		File source = tc.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\reports\\" + testname + ".png";
		org.apache.commons.io.FileUtils.copyFile(source, new File(destination));
		return destination;
	}
}
