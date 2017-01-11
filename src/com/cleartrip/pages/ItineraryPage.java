package com.cleartrip.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cleartrip.utils.Constant;
import com.cleartrip.utils.utils;

public class ItineraryPage {
	@FindBy(how = How.ID, using = Constant.idContinueBookingBtn) WebElement continueBookingBtn;
	@FindBy(how = How.ID, using = Constant.idInsuranceChkBox) WebElement insuranceChkBox;
	
	public boolean isPageLoaded(WebDriver driver){
		return utils.isPageReady(driver, continueBookingBtn);
	}
	public void continueBooking(){
		insuranceChkBox.click();
		continueBookingBtn.click();
	}
}
