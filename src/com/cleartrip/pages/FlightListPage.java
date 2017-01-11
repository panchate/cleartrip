package com.cleartrip.pages;

import java.util.List;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.cleartrip.utils.Constant;
import com.cleartrip.utils.utils;

public class FlightListPage {
	
	@FindBy(how = How.XPATH, using = Constant.xpathFromPrice) WebElement fromPrice;
	@FindBy(how = How.XPATH, using = Constant.xpathToPrice) WebElement toPrice;
	@FindBy(how = How.XPATH, using = Constant.xpathTotalAmt) WebElement totalAmt;
	@FindAll({@FindBy(how = How.XPATH, using = Constant.xpathListBookBtn)}) List<WebElement> listBookBtn;
	
	public boolean isPageLoaded(WebDriver driver){
		return utils.isPageReady(driver, totalAmt);
	}
	public void selectPriceNBook(WebDriver driver){
		fromPrice.click();
		toPrice.click();
		try{
			listBookBtn.get(0).click();
		}catch(ElementNotVisibleException e){
			listBookBtn.get(1).click();
		}
	}
}
