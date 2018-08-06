package com.eProofing.Utilities;

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
}
