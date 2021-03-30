package com.Ecommerce.testCases;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecommerce.pageObjects.LoginPage;
import com.Ecommerce.testBase.BaseClass;

 
public class TC_LoginTest_001 extends BaseClass{
	
	@Test
	public void loginTest() throws IOException
	{
		logger.info("**************** Starting TC_LoginTest_001 ************* ");
		driver.get(confgprobObj.getProperty("baseURL"));
		LoginPage lp=new LoginPage(driver);
		
		logger.info("**************** Providing login details ************* ");
		lp.setEmail(confgprobObj.getProperty("uname"));
		lp.setPassword(confgprobObj.getProperty("pwd"));
		lp.setLoginButton();
		
		String exp_title="Dashboard / nopCommerce administration";
		String act_title=driver.getTitle();
		
		if(exp_title.equals(act_title))
		{
			logger.info("**************** Login test is passed ************* ");
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("**************** Login test is failed ************* ");
			captureScreen(driver,"LoginTest");
			Assert.assertTrue(false);

		}
		lp.setLogoutButton();
		
	}
}
