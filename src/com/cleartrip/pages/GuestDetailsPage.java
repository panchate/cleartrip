package com.cleartrip.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import com.cleartrip.utils.Constant;
import com.cleartrip.utils.utils;

public class GuestDetailsPage {
	@FindBy(how = How.ID, using = Constant.idTitleTraveller) WebElement titleTraveller;
	@FindBy(how = How.ID, using = Constant.idFirstName) WebElement firstName;
	@FindBy(how = How.ID, using = Constant.idLastName) WebElement lastName;
	@FindBy(how = How.ID, using = Constant.idMobileNumber) WebElement mobileNumber;
	@FindBy(how = How.ID, using = Constant.idcontinueBtnTraveller) WebElement continueBtnTraveller;
	
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
