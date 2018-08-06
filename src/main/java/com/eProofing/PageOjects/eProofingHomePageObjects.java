package com.eProofing.PageOjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class eProofingHomePageObjects {
	
	WebDriver driver;
	
	@FindBy(id="start_proof")
	WebElement start_proof ;
	
		
	public eProofingHomePageObjects(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void startProof()
	{
		start_proof.click();
	}

}
