package com.rajubanking.TestCases;

import com.rajubanking.PageObject.LoginPage;

public class TC extends BaseClass{
	
	
	public void loginTest() {
	
		logger.info("URL is opened");
		
		LoginPage lp = new LoginPage(driver);
		lp.setusername(uname);
		
	}

}
