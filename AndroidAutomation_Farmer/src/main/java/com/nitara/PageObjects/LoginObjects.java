package com.nitara.PageObjects;



import com.nitara.utils.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginObjects extends BasePage{

	TestUtils utils = new TestUtils();
	
	@AndroidFindBy(id = "com.nitara.farmer:id/phone_number") 
	private MobileElement phone_number;
	
	
	@AndroidFindBy(id = "com.nitara.farmer:id/password") 
	private MobileElement password;
	
	
	@AndroidFindBy(id = "com.nitara.farmer:id/login_button") 
	private MobileElement login_button;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/error_msg_authorization") 
	private MobileElement errTxt;
	
	
	
	public void enterUserName(String username)  {
		sendKeys(phone_number,username);
	}
	
	public void enterPassword(String pssword) {
		sendKeys(password,pssword);	
		
	}
	
	public void pressLoginBtn() {
		click(login_button);
		
	}
	
	public String getErrTxt() {
		String err =getText(errTxt);
		System.out.println(err);
		return err;
	}
	
	public void userLogin(String username, String pssword) {
		sendKeys(phone_number,username);
		sendKeys(password,pssword);
		click(login_button);
	}
	
		
}
