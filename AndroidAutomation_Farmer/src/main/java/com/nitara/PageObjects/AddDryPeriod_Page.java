package com.nitara.PageObjects;

import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class AddDryPeriod_Page extends BasePage{
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\"" +"com.nitara.farmer:id/saveBtn"+ "\"))")  
	private MobileElement save_btn;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/cattleTagName") 
	private MobileElement cattleTag;
	

	@AndroidFindBy(id = "com.nitara.farmer:id/dryPeriodDate") 
	private MobileElement dryPeriodDate;
	


	public void assert_CattleTag(String tag) {
		Assert.assertEquals(cattleTag.getText(), tag);
	}
	
	
	public void enter_Drydate(String date) {
		dryPeriodDate.clear();
		sendKeys(dryPeriodDate,date);
	}
	

	public void press_SaveButton() {
		click(save_btn);	
	}


}
