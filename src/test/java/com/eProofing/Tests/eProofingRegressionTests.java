package com.eProofing.Tests;

import org.testng.annotations.Test;

import com.eProofing.PageOjects.eProofingHomePageObjects;
import com.eProofing.Properties.eProofingProperties;
import com.eProofing.Utilities.SeleniumWaits;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class eProofingRegressionTests {

	ExtentReports extent;
	ExtentTest logger;
	WebDriver driver;
	eProofingHomePageObjects ehp;
	eProofingProperties eprop;

	@BeforeMethod
	public void beforeMethod() {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		eprop = new eProofingProperties();

		ehp = new eProofingHomePageObjects(driver);

		driver.get(eprop.eProofingURL);

		extent = new ExtentReports(
				System.getProperty("user.dir") + "\\EproofingExtentReports\\" + "RegressionReport" + ".html");
		// extent.addSystemInfo("Host Name",
		// "SoftwareTestingMaterial").addSystemInfo("Environment", "Automation
		// Testing").addSystemInfo("User Name", "Vidya Suryavanshi");
		// extent.loadConfig(new
		// File(System.getProperty("user.dir")+"\\extent-config.xml"));
	}

	@Test
	public void startProofing() {
		logger = extent.startTest("Eproofing Test");
		ehp.startProof();
		logger.log(LogStatus.INFO, "Eproofing Started!");
	}

	@AfterMethod

	public void afterMethod(ITestResult results) throws IOException {
		if (results.getStatus() == ITestResult.FAILURE) {
			String screenShotPath = SeleniumWaits.capture(driver, "Eproofing_FailureScreenShot");

			logger.log(LogStatus.FAIL, "Test case Failed is: " + results.getName());
			logger.log(LogStatus.FAIL, "Test case Failed is: " + results.getThrowable());
			logger.log(LogStatus.FAIL, "Test case Failed is: " + logger.addScreenCapture(screenShotPath));

		} else if (results.getStatus() == ITestResult.SKIP) {

			logger.log(LogStatus.SKIP, "Test case Skipped is: " + results.getName());

		}

		extent.endTest(logger);

	}

	@AfterTest
	public void teardown() {

		extent.flush();
		driver.quit();
	}
}
