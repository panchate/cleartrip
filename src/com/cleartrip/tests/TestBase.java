package com.cleartrip.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.cleartrip.utils.BrowserFactory;

public class TestBase {
	WebDriver driver;
	private String browserName = "firefox";
	private String url = "https://www.cleartrip.com/";
	
	@BeforeClass
	public void initClass(){
		driver = BrowserFactory.startBrower(browserName, url);
	}
	
	@AfterClass
	public void afterClass(){
		driver.quit();
	}
}
