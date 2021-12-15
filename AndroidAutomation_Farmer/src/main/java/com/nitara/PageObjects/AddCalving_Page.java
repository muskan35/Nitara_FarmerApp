package com.nitara.PageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class AddCalving_Page extends BasePage{

	@AndroidFindBy(id = "com.nitara.farmer:id/twinsRdBtn") 
	private MobileElement Twins_RdBtn;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/singleRdBtn") 
	private MobileElement Single_RdBtn;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/maleRdBtn_single") 
	private MobileElement Male_RdBtn;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/femaleRdBtn_single") 
	private MobileElement Female_RdBtn;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/calvingTime") 
	private MobileElement calvingTime;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/abortedRdBtn_single") 
	private MobileElement Aborted_RdBtn;
	
	@AndroidFindBy(id = "android:id/toggle_mode") 
	private MobileElement timePicker;
	
	@AndroidFindBy(id = "android:id/input_hour") 
	private MobileElement input_hour;
	
	@AndroidFindBy(id = "android:id/input_minute") 
	private MobileElement input_minute;
	
	@AndroidFindBy(id = "android:id/am_pm_spinner") 
	private MobileElement am_pm;
	
	
	@AndroidFindBy(id = "android:id/button1") 
	private MobileElement ok_btn;
	
	
	@AndroidFindBy(id = "com.nitara.farmer:id/calving_date") 
	private MobileElement calving_date;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\"" +"com.nitara.farmer:id/saveBtn"+ "\"))")  
	private MobileElement save_btn;
	
	public void select_Time(String time) {
		String[] splitString = time.split(":");
		System.out.println(splitString);
		String hour = splitString[0];
		System.out.println(hour);
		String min = splitString[1];
		System.out.println(min);
		String a = splitString[2];
		System.out.println(a);
		calvingTime.click();
		timePicker.click();
		input_hour.click();
		input_hour.clear();
		sendKeys(input_hour, hour);
		input_minute.click();
		input_minute.clear();
		sendKeys(input_minute, min);
		click(am_pm);
		select_dropdown(a);
		ok_btn.click();
		
	}
	
	
	public void enter_CalvingDate(String date) {
		calving_date.clear();
		sendKeys(calving_date,date);
	}
	
	public void enter_CalvingTime(String time) {
		calvingTime.sendKeys(time);
	}

	public void select_CalfResultSingle(String result,String gender) {
		
		
			Single_RdBtn.click();
			if(Male_RdBtn.getText().equalsIgnoreCase(gender))
			{
				Male_RdBtn.click();
			}
			
			else if(Female_RdBtn.getText().equalsIgnoreCase(gender))
			{
				Female_RdBtn.click();
			}
			
			else if(Aborted_RdBtn.getText().equalsIgnoreCase(gender))
			{
				Aborted_RdBtn.click();
			}

	}
	
	
	public void select_CalfResultTwins(String result,String gender1, String gender2) {
		
		
		Twins_RdBtn.click();
		if(Male_RdBtn.getText().equalsIgnoreCase(gender1) || Male_RdBtn.getText().equalsIgnoreCase(gender2))
		{
			Male_RdBtn.click();
		}
		
		if(Female_RdBtn.getText().equalsIgnoreCase(gender1) || Female_RdBtn.getText().equalsIgnoreCase(gender2))
		{
			Female_RdBtn.click();
		}
		
		if(Aborted_RdBtn.getText().equalsIgnoreCase(gender1)|| Aborted_RdBtn.getText().equalsIgnoreCase(gender2))
		{
			Aborted_RdBtn.click();
		}

}
	
	public void press_SaveButton() {
		click(save_btn);	
	}

}
