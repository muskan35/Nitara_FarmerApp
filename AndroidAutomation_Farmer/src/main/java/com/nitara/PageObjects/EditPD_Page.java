package com.nitara.PageObjects;

import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class EditPD_Page extends BasePage{
	
	@AndroidFindBy(id = "com.nitara.farmer:id/search_farm_param") 
	private MobileElement search_cattle;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/cattle_img") 
	private MobileElement select_cattle;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/breedingBtn") 
	private MobileElement select_breed;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\"" +"com.nitara.farmer:id/btnAddActivity"+ "\"))")  
	private MobileElement add_btn;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/pdCardView") 
	private MobileElement select_pd;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\"" +"com.nitara.farmer:id/is_cattle_pregnant"+ "\"))")  
	private MobileElement is_pregnant;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/saveBtn") 
	private MobileElement save_btn;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/back_cattle_result") 
	private MobileElement back_btn;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\"" +"com.nitara.farmer:id/btnEditRight"+ "\"))")  
	private MobileElement edit_btn;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/saveBtn") 
	private MobileElement upt_btn;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/tvDateRight") 
	private MobileElement pd_date;
	
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
		waitVisibility(add_btn);
		click(add_btn);
	}
	public void clickPD() {
		waitVisibility(select_pd);
		click(select_pd);
	}
	public void isCattlePregnant() {
		String checked = is_pregnant.getAttribute("checked");
		if(checked.equals("false")) {
			is_pregnant.click();	
			//pregnant_Since();
		}
	}
	public void press_SaveButton() {
		click(save_btn);	
	}
	public void goback() {
		waitVisibility(back_btn);
		click(back_btn);
	}
	public void pressEdit() {
		waitVisibility(edit_btn);
		click(edit_btn);
	}
	public void update() {
		waitVisibility(upt_btn);
		click(upt_btn);
	}
	public void pressActivity() {
		waitVisibility(add_btn);
	}
	public void assert_date() {
		waitVisibility(pd_date);
		Assert.assertEquals(pd_date.getText(), "02 Jan 2022");
	}
}
