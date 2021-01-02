package com.rajubanking.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver) {
		
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(name="uid")
	@CacheLookup
	WebElement txtusername;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement txtpassword;
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement submit;
	
	@FindBy(xpath="/html/body/div[4]/div/ul/li[10]/a")
	@CacheLookup
	WebElement logout;

	public void setusername(String uname) {
		txtusername.sendKeys(uname);
	}
	public void setpassword(String pwd) {
		txtpassword.sendKeys(pwd);
	}
	
	public void btnLogin() {
		submit.click();
	}

	public void clicklogout() {
		logout.click();
	}

}