package com.cleartrip.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.cleartrip.utils.utils;

public class LoginPage {
	@FindBy(how = How.ID, using = "username") WebElement username;
	@FindBy(how = How.ID, using = "LoginContinueBtn_1") WebElement continueBtnLogin;
	@FindBy(how = How.ID, using = "subscribe_newsletter") WebElement subsribeLetter;
	
	public boolean isPageLoaded(WebDriver driver){
		return utils.isPageReady(driver, continueBtnLogin);
	}
	public void setLoginDetails(String email){
		username.sendKeys(email);
		subsribeLetter.click();
		continueBtnLogin.click();
	}
}
