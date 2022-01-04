package com.nitara.AccountManagement;

import java.util.Map;

import org.testng.annotations.Test;

import com.nitara.GenericBase.GenericBase;
import com.nitara.Helper.GenerateRandomData;
import com.nitara.PageObjects.LoginOTP_Page;
import com.nitara.PageObjects.Removecattle_Page;
import com.nitara.utils.DataProviderUtils;

public class LoginWithOTP extends GenericBase{
	
	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void login_otp(Map<String,String> data) throws InterruptedException {
		/*@Author: Muskan Khowala
		 * Login with OTP foruser login */
		//GenerateRandomData numb = new GenerateRandomData();
		LoginOTP_Page reg = new LoginOTP_Page();
		Thread.sleep(8000);
		reg.EnterPhone(data.get("PhoneNumber"));/*Entering phone number*/
		reg.hideKeyboard();
		reg.clickContinue();/*Clicking continue button*/
		reg.logwithotp();/*Clicking login with otp button*/
		reg.Enterotp1(data.get("otp1"));/*Entering otp*/
		reg.Enterotp2(data.get("otp2"));/*Entering otp*/
		reg.Enterotp3(data.get("otp3"));/*Entering otp*/
		reg.Enterotp4(data.get("otp4"));/*Entering otp*/
		reg.hideKeyboard();
		reg.clickLogin();/*Clicking login button*/
		Thread.sleep(8000);
		/*Asserting the home page*/
		reg.findElement("Search");
		reg.assert_homepg();
	}
}
