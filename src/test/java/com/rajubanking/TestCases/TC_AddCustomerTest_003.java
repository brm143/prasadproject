package com.rajubanking.TestCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STRef;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.rajubanking.PageObject.AddCustomerPage;
import com.rajubanking.PageObject.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {

	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		
	LoginPage lp = new LoginPage(driver);
	lp.setusername(username);
	lp.setpassword(password);
	lp.btnLogin();
	
	Thread.sleep(3000);
	
	AddCustomerPage addcust= new AddCustomerPage(driver);
	
	addcust.clickAddNewCustomer();
	addcust.custName("Raju");
	addcust.custgender("male");
	addcust.custdob("04", "17", "1995");
	Thread.sleep(3000);
	addcust.custaddress("INDIA");
	addcust.custcity("DMM");
	addcust.custstate("AP");
	addcust.custpinno("515671");
	addcust.custtelephoneno("8142920899");
	String email=randomString()+"@gmail.com";
	addcust.custemailid(email);
	addcust.custpassword("abcdef");
	addcust.custsubmit();
	Thread.sleep(3000);
	boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
	
	if(res==true) {
		Assert.assertTrue(true);
	}else {
		captureScreen(driver,"addNewCustomer");
		Assert.assertFalse(false);
	}
	
	}
	
	public String randomString() {
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		return(generatedstring);
	}
	
	public static String randomNumber() {
		String generatedstring2=RandomStringUtils.randomNumeric(8);
		return(generatedstring2);
	}
}
