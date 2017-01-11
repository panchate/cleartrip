package com.cleartrip.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObjectFactory {
	public static <T> T initializePage(WebDriver driver, Class<T> object){		
		return PageFactory.initElements(driver, object);
	}
}
