package com.cleartrip.utils;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class utils {
	private static final HashMap<String, Integer> monthMap = new HashMap<String, Integer>();
	static{
		monthMap.put("January",1);
		monthMap.put("February",2);
		monthMap.put("March",3);
		monthMap.put("April",4);
		monthMap.put("May",5);
		monthMap.put("June",6);
		monthMap.put("July",7);
		monthMap.put("August",8);
		monthMap.put("September",9);
		monthMap.put("Octomber",10);
		monthMap.put("November",11);
		monthMap.put("December",12);
	}
	public static boolean isPageReady(WebDriver driver, WebElement elementToWatch){
		WebDriverWait _wait = new WebDriverWait(driver, 60);
		WebElement element = _wait.until(ExpectedConditions.visibilityOf(elementToWatch));
		if(element != null){
			return true;
		}
		return false;
	}
	
	public static int getMonthID(String month){
		return monthMap.get(month);					
	}
	
}

