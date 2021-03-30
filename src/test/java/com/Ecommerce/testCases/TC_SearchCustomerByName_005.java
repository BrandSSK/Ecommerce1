package com.Ecommerce.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecommerce.pageObjects.AddCustomerPage;
import com.Ecommerce.pageObjects.LoginPage;
import com.Ecommerce.pageObjects.SearchCustomerPage;
import com.Ecommerce.testBase.BaseClass;

public class TC_SearchCustomerByName_005 extends BaseClass {

	@Test
	public void searchCustomerbyName() throws InterruptedException, IOException
	{
		logger.info("********* starting TC_SearchCustomerByName_005 *************");
		
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
		
		//Name
		SearchCustomerPage searchcust=new SearchCustomerPage(driver);
		searchcust.setFirstName("Victoria");
		searchcust.setLastName("Terces");
		searchcust.clickSearch();
		Thread.sleep(3000);
		
		boolean status=searchcust.searchCustomerByName("Victoria Terces");
		if(status==true)
		{
			logger.info("********* Search customer by name is passed *************");
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("********* Search customer by name is failed*************");
			captureScreen(driver,"searchCustomerbyName");
			Assert.assertTrue(false);
		}
		logger.info("********* End of TC_SearchCustomerByName_005 *************");
	}
	
}