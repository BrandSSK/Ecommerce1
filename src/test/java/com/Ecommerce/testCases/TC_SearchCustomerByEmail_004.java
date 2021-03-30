package com.Ecommerce.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecommerce.pageObjects.AddCustomerPage;
import com.Ecommerce.pageObjects.LoginPage;
import com.Ecommerce.pageObjects.SearchCustomerPage;
import com.Ecommerce.testBase.BaseClass;

public class TC_SearchCustomerByEmail_004 extends BaseClass {

	@Test
	public void searchCustomerbyEmail() throws InterruptedException, IOException
	{
		logger.info("********* starting TC_SearchCustomerByEmail_004 *************");
		
		driver.get(confgprobObj.getProperty("baseURL"));
		LoginPage lp=new LoginPage(driver);
		
		logger.info("**************** Providing login details ************* ");
		lp.setEmail(confgprobObj.getProperty("uname"));
		lp.setPassword(confgprobObj.getProperty("pwd"));
		lp.setLoginButton();
		
		//Go to search page
		AddCustomerPage addcust=new AddCustomerPage(driver);
		
		addcust.clickOnCustomersMenu();
		addcust.clickOnCustomersMenuItem();
		
		//Email ID
		SearchCustomerPage searchcust=new SearchCustomerPage(driver);
		searchcust.setEmail("victoria_victoria@nopCommerce.com");
		searchcust.clickSearch();
		Thread.sleep(3000);
		
		boolean status=searchcust.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
		if(status==true)
		{
			logger.info("********* Search customer by email is passed *************");
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("********* Search customer by email is failed*************");
			captureScreen(driver,"searchCustomerbyEmail");
			Assert.assertTrue(false);
		}
		logger.info("********* End of TC_SearchCustomerByEmail_004 *************");
	}
	
}