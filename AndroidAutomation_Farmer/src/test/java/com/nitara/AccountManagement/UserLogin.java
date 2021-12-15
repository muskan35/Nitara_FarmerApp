package com.nitara.AccountManagement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.nitara.GenericBase.GenericBase;
import com.nitara.PageObjects.LoginObjects;

public class UserLogin extends GenericBase{
	
	
	@Test(groups= {"Smoke"})
	public void userLogin() throws Exception {
		
		//ExtentTest test = extent.createTest("User Login", "Verify user is able to login with valid credentials");
		
		String username = prop.getProperty("Username");
		String password = prop.getProperty("Password"); 
		
		
		LoginObjects obj = new LoginObjects();
		obj.enterUserName(username);
	//	test.log(Status.INFO,"Username entered");
		obj.enterPassword(password);
		//test.log(Status.INFO,"Password entered");
		obj.pressLoginBtn();
		//test.log(Status.INFO,"Login Button clicked");
		String toast = obj.captureToast();
		//test.log(Status.INFO,toast);
		Assert.assertEquals(toast, "Logged In Successful");
		
			
	}
	

}
