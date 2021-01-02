package com.rajubanking.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AC2 {
	WebDriver ldriver;
	
	public AC2(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
}
	
	

}
