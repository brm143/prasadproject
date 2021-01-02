package com.rajubanking.TestCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.rajubanking.PageObject.LoginPage;
//import com.rajubanking.TestCases.BaseClass;
import com.rajubanking.utilites.XLUtils;

//import junit.framework.Assert;

public class TC_LoginDDT_002 extends BaseClass {

	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwd) {
		LoginPage lp = new LoginPage(driver);
		lp.setusername(user);
		logger.info("username is provided");
		lp.setpassword(pwd);
		logger.info("password is provided");
		lp.btnLogin();
		
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login failed");
		}else {
			Assert.assertTrue(true);
			logger.info("Login passed");
			lp.clicklogout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
		
	}
	
	public boolean isAlertPresent() {
		try {
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e) {
			return false;
		}
	}
	
	@DataProvider(name="LoginData")
	String[][] getdata() throws IOException{
		String path = System.getProperty("user.dir")+"/src/test/java/com/rajubanking/testData/LoginData.xlsx";
		
		int rownum =XLUtils.getRowCount(path,"Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);
		String logindata[][] = new String[rownum][colcount];
		for(int i=1;i<rownum;i++) {
			for(int j=0;j<colcount;j++) {
				logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
	return logindata;	
	}
}
