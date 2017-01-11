package com.cleartrip.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import com.cleartrip.utils.utils;

public class GuestDetailsPage {
	@FindBy(how = How.ID, using = "AdultTitle1") WebElement titleTraveller;
	@FindBy(how = How.ID, using = "AdultFname1") WebElement firstName;
	@FindBy(how = How.ID, using = "AdultLname1") WebElement lastName;
	@FindBy(how = How.ID, using = "mobileNumber") WebElement mobileNumber;
	@FindBy(how = How.ID, using = "travellerBtn") WebElement continueBtnTraveller;
	
	public boolean isPageReady(WebDriver driver){
		return utils.isPageReady(driver, continueBtnTraveller);
	}
	public void setTravellerDetails(String title, String fname, String lname, String mobile){
		Select titleList = new Select(titleTraveller);
		titleList.selectByVisibleText(title);
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		mobileNumber.sendKeys(mobile);
		continueBtnTraveller.click();
	}
}
