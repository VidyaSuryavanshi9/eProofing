package com.eProofing.Utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWaits {

	WebDriver driver;

	public SeleniumWaits(WebDriver driver) {

		this.driver = driver;
	}

	public void ExplicitWait(WebDriver driver, long Time, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, Time);

		wait.until(ExpectedConditions.elementToBeClickable(element));

	}
	
	public static String capture(WebDriver driver,String screenShotName) throws IOException
	   {
	       TakesScreenshot ts = (TakesScreenshot)driver;
	       File source = ts.getScreenshotAs(OutputType.FILE);
	       String dest = System.getProperty("user.dir") +"\\ErrorScreenshots\\"+screenShotName+".png";
	       File destination = new File(dest);
	       
	       FileUtils.copyFile(source, destination);        
	                   
	       return dest;
	   }
}
