package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Base;
import resources.ExtentReporterNG;

public class Listeners extends Base implements ITestListener {
	public static Logger log = LogManager.getLogger(Base.class.getName());
	public ExtentTest test;

	ExtentReports extent = ExtentReporterNG.getReportObject();
	ThreadLocal<ExtentTest> extendsreport = new ThreadLocal<ExtentTest>();
	public void onTestStart(ITestResult result) {

		test = extent.createTest(result.getMethod().getMethodName());
		extendsreport.set(test);
	}

	public void onTestSuccess(ITestResult result) {
		log.info("Test Success");
		extendsreport.get().log(Status.PASS, "Test Passed");
		String testMethodNamesuccess =result.getMethod().getMethodName();

		try {

		driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());

		}catch (Exception e)

		{



		}
		try {

			extendsreport.get().addScreenCaptureFromPath(getScreenShotPath(testMethodNamesuccess, driver), result.getMethod().getMethodName());

			} catch (IOException e) {

			e.printStackTrace();

			}
	}

	public void onTestFailure(ITestResult result) {
	 extendsreport.get().fail(result.getThrowable());
		WebDriver driver = null;
		log.info("Test Fail");
		String testname = result.getMethod().getMethodName();
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			extendsreport.get().addScreenCaptureFromPath(getScreenShotPath(testname, driver), result.getMethod().getMethodName());
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestFinish(ITestResult result) {

		// ExtentReports extent = ExtentReporterNG.getReportObject();
		extent.flush();
		
	}
}
