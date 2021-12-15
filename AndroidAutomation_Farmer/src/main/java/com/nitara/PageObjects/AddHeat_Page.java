package com.nitara.PageObjects;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class AddHeat_Page  extends BasePage{
	
	@AndroidFindBy(id = "com.nitara.farmer:id/naturalBtn") 
	private MobileElement natural_btn;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/artificialBtn") 
	private MobileElement artificial_btn;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/heatTime") 
	private MobileElement heatTime;
	
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
	
	@AndroidFindBy(id = "com.nitara.farmer:id/heat_date") 
	private MobileElement heat_date;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\"" +"com.nitara.farmer:id/saveBtn"+ "\"))")  
	private MobileElement save_btn;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/cattleTagName") 
	private MobileElement cattleTag;
	

	public void assert_CattleTag(String tag) {
		Assert.assertEquals(cattleTag.getText(), tag);
	}
	
	

	public void select_Time(String time) {
		String[] splitString = time.split(":");
		System.out.println(splitString);
		String hour = splitString[0];
		System.out.println(hour);
		String min = splitString[1];
		System.out.println(min);
		String a = splitString[2];
		System.out.println(a);
		heatTime.click();
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
	

	
	public void select_HeatType(String type) {
		
		if(type.equalsIgnoreCase("artificial")) {
			artificial_btn.click();
		}
	}
	

	
	public void enter_HeatDate(String date) {
		heat_date.clear();
		sendKeys(heat_date,date);
	}
	
	public void press_SaveButton() {
		click(save_btn);	
	}
	

}
