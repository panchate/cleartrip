package com.cleartrip.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import com.cleartrip.utils.Constant;
import com.cleartrip.utils.utils;

public class HomePage {

	@FindBy(how=How.ID, using = Constant.idRoundTrip) WebElement roundTrip;
	@FindBy(how=How.ID, using = Constant.idFromTag) WebElement from;
	@FindBy(how=How.ID, using = Constant.idToTag) WebElement to;
	@FindBy(how=How.ID, using = Constant.idDepartDate) WebElement departDate;
	@FindBy(how=How.ID, using = Constant.idRetrunDate) WebElement returnDate;
	@FindBy(how=How.XPATH, using = Constant.xpathSearchForm) WebElement searchForm;
	@FindBy(how=How.ID, using = Constant.idAdults) WebElement adults;
	@FindBy(how=How.ID, using = Constant.idSearchBtn) WebElement searchBtn;
	@FindAll({@FindBy(how=How.XPATH, using = Constant.xpathListCities)}) List<WebElement> listCities;
	@FindBy(how=How.XPATH, using = Constant.xpathMonth1) WebElement month1;
	@FindBy(how=How.XPATH, using = Constant.xpathMonth1) WebElement nextMonth;
	@FindAll({@FindBy(how=How.XPATH, using = Constant.xpathDates)}) List<WebElement> dates;

	public String getSearchFrom(){
		searchForm.click();
		return searchForm.getText();
	}

	public boolean isPageReady(WebDriver driver){
		return utils.isPageReady(driver, searchBtn);
	}

	public void selectTripType(String tripType){
		if(tripType.equalsIgnoreCase("roundtrip")){
			roundTrip.click();
		}
	}

	public void selectAdults(String noOfAdults){
		Select selectAdult = new Select(adults);
		selectAdult.selectByVisibleText(noOfAdults);
	}

	public void selectFrom(String origin, WebDriver driver){
		try {
			from.sendKeys(origin);
			Thread.sleep(5000);
			for(WebElement element:listCities){
				if(element.getText().contains(origin)){
					element.click();
					break;
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void selectTo(String toPlace, WebDriver driver){
		try {
			to.sendKeys(toPlace);
			Thread.sleep(5000);
			for(WebElement element:listCities){
				if(element.getText().contains(toPlace)){
					element.click();
					break;
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	//need enhancement to verify next year 
	public void selectDepartDate(String date, String month, String year, WebDriver driver){
		departDate.click();

		int currentMonth = utils.getMonthID(month);
		int targetMonth = utils.getMonthID(month);

		if(targetMonth < currentMonth)
			targetMonth = targetMonth + 12;

		int loop = targetMonth - currentMonth;

		while(loop > 0)
		{
			nextMonth.click();
			loop--;
		}
		for(WebElement element:dates){
			String d = element.getText();
			if(d.equalsIgnoreCase(date)){
				element.click();
				break;
			}
		}
	}

	public void selectReturnDate(String date, String month, String year, WebDriver driver){
		int currentMonth = utils.getMonthID(month);
		int targetMonth = utils.getMonthID(month);

		if(targetMonth < currentMonth)
			targetMonth = targetMonth + 12;

		int loop = targetMonth - currentMonth;

		while(loop > 0)
		{
			nextMonth.click();
			loop--;			
		}
		for(WebElement element:dates){
			String d = element.getText();
			if(d.equalsIgnoreCase(date)){
				element.click();
				break;
			}
		}
	}

	public void search(){
		searchBtn.click();
	}
}
