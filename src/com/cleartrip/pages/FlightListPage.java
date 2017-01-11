package com.cleartrip.pages;

import java.util.List;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.cleartrip.utils.utils;

public class FlightListPage {
	final static String xpathBookBtn =".//*[@id='flightForm']//*[@class='resultsContainer']/div[3]/div[3]//*[@class='booking fRight']";
	@FindBy(how = How.XPATH, using =".//*[@id='flightForm']//*[@class='resultsContainer']/div[4]/div[1]/nav/ul/li[1]/div") WebElement fromPrice;
	@FindBy(how = How.XPATH, using =".//*[@id='flightForm']//*[@class='resultsContainer']/div[4]/div[2]/nav/ul/li[1]/div") WebElement toPrice;
	@FindBy(how = How.XPATH, using =".//h2[@class='totalAmount']") WebElement totalAmt;
	@FindAll({@FindBy(how = How.XPATH, using = xpathBookBtn)}) List<WebElement> listBookBtn;
	
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
