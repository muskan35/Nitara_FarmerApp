package com.nitara.PageObjects;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ViewDry_Page extends BasePage{
	
	@AndroidFindBy(id = "com.nitara.farmer:id/search_farm_param") 
	private MobileElement search_cattle;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/cattle_img") 
	private MobileElement select_cattle;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/breedingBtn") 
	private MobileElement select_breed;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\"" +"com.nitara.farmer:id/ivAddHistoryIcon"+ "\"))")  
	private MobileElement add_btn;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\"" +"com.nitara.farmer:id/dryCardView"+ "\"))")  
	private MobileElement dry_btn;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/saveBtn") 
	private MobileElement save_btn;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/back_cattle_result") 
	private MobileElement back_btn;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/lastCalvingDate") 
	private MobileElement cal_date;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\"" +"com.nitara.farmer:id/tvDateRight"+ "\"))")  
	private MobileElement date_cattle;
	
	public void SearchCattle(String cattle_name) {
		waitVisibility(search_cattle);
		click(search_cattle);
		sendKeys(search_cattle,cattle_name);
	}
	public void SelectCattle() {
		waitVisibility(select_cattle);
		click(select_cattle);
	}
	public void SelectBreed() {
		waitVisibility(select_breed);
		click(select_breed);
	}
	public void addActivity() {
		click(add_btn);	
	}
	public void press_Dry() {
		click(dry_btn);
	}
	public void press_Save() {
		click(save_btn);	
	}
	public void press_back() {
		waitVisibility(back_btn);
		click(back_btn);
	}
	public void assert_date() {
		waitVisibility(date_cattle);
		Assert.assertEquals(date_cattle.getText(), "19 Dec 2021");
	}
	public void assert_calvingdate() {
		waitVisibility(cal_date);
		Assert.assertEquals(cal_date.getText(), "01 Sep 2021");
	}
}
