package com.eProofing.Tests;

import org.testng.annotations.Test;

import com.eProofing.PageOjects.eProofingHomePageObjects;
import com.eProofing.Properties.eProofingProperties;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class eProofingRegressionTests extends eProofingProperties{
 
  WebDriver driver;

  @BeforeMethod
  public void beforeMethod() 
  {
	 driver = new ChromeDriver();
	 System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	 driver.get(eProofingURL);
  }
  
  
  @Test
  public void startProofing () 
  {
	  eProofingHomePageObjects ehp = new eProofingHomePageObjects(driver);
	  ehp.startProof();
  }

  @AfterMethod
  public void afterMethod() 
  {
	  driver.quit();      
  }

}
