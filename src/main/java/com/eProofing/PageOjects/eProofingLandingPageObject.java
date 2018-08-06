package com.eProofing.PageOjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class eProofingLandingPageObject {

	WebDriver driver;

	@FindBy(id = "ID")
	WebElement Usernametxtbox;

	@FindBy(id = "ID")
	WebElement Passwordtxtbox;

	@FindBy(id = "ID")
	WebElement SignInBtn;

	public eProofingLandingPageObject(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public eProofingHomePageObjects LogInTOAuthorServices(String Username, String Password) {

		Usernametxtbox.sendKeys(Username);
		Passwordtxtbox.sendKeys(Password);
		SignInBtn.click();

		return new eProofingHomePageObjects(driver);

	}

}
