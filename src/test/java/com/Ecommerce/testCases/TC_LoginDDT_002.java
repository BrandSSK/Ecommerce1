package com.Ecommerce.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Ecommerce.pageObjects.LoginPage;
import com.Ecommerce.testBase.BaseClass;
import com.Ecommerce.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass{

	@Test(dataProvider="LoginData")
	public void loginTest(String user,String pwd,String exp) throws InterruptedException
	{
		logger.info("********* starting TC_LoginDDT_002 *************");
		
		driver.get(confgprobObj.getProperty("baseURL"));
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(user);
		lp.setPassword(pwd);
		lp.setLoginButton();
		Thread.sleep(5000);
		
		String exp_title="Dashboard / nopCommerce administration";
		String act_title=driver.getTitle();
		
		if(exp_title.equals(act_title))
		{
			if(exp.equals("Pass"))
			{
				logger.info("**************** loginTest is Passed ************* ");
				lp.setLogoutButton();
				Thread.sleep(3000);
				Assert.assertTrue(true);
			}
			else if(exp.equals("Fail"))
			{
				logger.warn("**************** loginTest is Failed************* ");
				lp.setLogoutButton();
				Thread.sleep(3000);
				Assert.assertTrue(false);
			}
					
		}
		else if(!exp_title.equals(act_title))
		{
			if(exp.equals("Pass"))
			{
				logger.warn("**************** loginTest is Failed************* ");
				Assert.assertTrue(false);
			}
			else if(exp.equals("Fail"))
			{
				logger.info("**************** loginTest is Passed ************* ");
				Assert.assertTrue(true);
			}

		}
		logger.info("********* Finished  TC_LoginDDT_002 *************");
	}
	
	
	
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/TestData/LoginData.xlsx";
		
		int totalrows=XLUtils.getRowCount(path, "Sheet1");	
		int totalcols=XLUtils.getCellCount(path,"Sheet1",1);
				
		String logindata[][]=new String[totalrows][totalcols];
		
		for(int i=1;i<=totalrows;i++)  //5
		{		
			for(int j=0;j<totalcols;j++)
			{
				logindata[i-1][j]= XLUtils.getCellData(path, "Sheet1",i, j);  //1,0
			}
		}
	return logindata;
	
	
		
		
				
	}
	
}