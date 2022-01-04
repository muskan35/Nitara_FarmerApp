package com.nitara.PageObjects;

import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginOTP_Page extends BasePage{

	@AndroidFindBy(id = "com.nitara.farmer:id/editTextPhone") 
	private MobileElement phone;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/continue_button") 
	private MobileElement cont;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/loginWithOtpTv") 
	private MobileElement log;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/otp_txt1") 
	private MobileElement otp1;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/otp_txt2") 
	private MobileElement otp2;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/otp_txt3") 
	private MobileElement otp3;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/otp_txt4") 
	private MobileElement otp4;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/continue_button") 
	private MobileElement login;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/smallLabel") 
	private MobileElement home;
	
	public void EnterPhone(String phone_no) {
		waitVisibility(phone);
		click(phone);
		sendKeys(phone,phone_no);
	}
	public void clickContinue() {
		waitVisibility(cont);
		click(cont);
	}
	public void logwithotp() {
		waitVisibility(log);
		click(log);
	}
	public void Enterotp1(String ot1) {
		waitVisibility(otp1);
		click(otp1);
		sendKeys(otp1,ot1);
	}
	public void Enterotp2(String ot2) {
		waitVisibility(otp2);
		click(otp2);
		sendKeys(otp2,ot2);
	}
	public void Enterotp3(String ot3) {
		waitVisibility(otp3);
		click(otp3);
		sendKeys(otp3,ot3);
	}
	public void Enterotp4(String ot4) {
		waitVisibility(otp4);
		click(otp4);
		sendKeys(otp4,ot4);
	}
	public void clickLogin() {
		waitVisibility(login);
		click(login);
	}
	public void assert_homepg() {
		waitVisibility(home);
		Assert.assertEquals(home.getText(), "Search");
	}
}
