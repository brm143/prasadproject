package com.rajubanking.TestCases;

import java.io.IOException;

//import static org.junit.Assert.assertTrue;

//import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.rajubanking.PageObject.LoginPage;

//import junit.framework.Assert;

//import junit.framework.Assert;

public class TC_LoginPage_001 extends BaseClass{
	
	@Test
	public void LoginTest() throws InterruptedException, IOException {
	
		logger.info("URL is opened");

	LoginPage lp = new LoginPage(driver);
	lp.setusername(username);
	
	logger.info("Entered username");
	
	lp.setpassword(password);
	
	logger.info("Entered password");
	
	lp.btnLogin();
	
	System.out.println(driver.getTitle());
	
	if(driver.getTitle().equals("GTPL Bank Manager HomePage123")) {
		
		Assert.assertTrue(true);
		
		logger.info("Login Test Case Passed");
		
	}else {
		captureScreen(driver ,"LoginTest");
		Assert.assertTrue(false);
		logger.info("Login test failed");
	}
	

}
	
}
