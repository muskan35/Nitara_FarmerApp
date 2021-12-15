package com.nitara.PageObjects;

import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class AddPD_Page extends BasePage{

	@AndroidFindBy(id = "com.nitara.farmer:id/pregnancy_test_date") 
	private MobileElement pdDate;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/is_cattle_pregnant") 
	private MobileElement is_cattle_pregnant;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\"" +"com.nitara.farmer:id/saveBtn"+ "\"))")  
	private MobileElement save_btn;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/cattleTagName") 
	private MobileElement cattleTag;
	

	public void assert_CattleTag(String tag) {
		Assert.assertEquals(cattleTag.getText(), tag);
	}
	
	public void select_isCattlePregnant(String status) {
		if(status.equalsIgnoreCase("true")) {
			is_cattle_pregnant.click();
		}
	}
	
	public void enter_PDdate(String date) {
		pdDate.clear();
		sendKeys(pdDate,date);
	}
	

	public void press_SaveButton() {
		click(save_btn);	
	}


}
