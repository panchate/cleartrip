package com.cleartrip.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserFactory {
	private static WebDriver driver;
	private static DesiredCapabilities capabilities;
	public static WebDriver startBrower(String browserName, String url){
		switch (browserName){
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "lib/geckodriver.exe");						
			driver = new FirefoxDriver();
		default:			
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.get(url);
		
		return driver;
	}
}
