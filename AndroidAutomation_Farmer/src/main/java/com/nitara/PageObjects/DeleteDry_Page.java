package com.nitara.PageObjects;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class DeleteDry_Page extends BasePage{

	@AndroidFindBy(id = "com.nitara.farmer:id/search_farm_param") 
	private MobileElement search_cattle;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/cattle_img") 
	private MobileElement select_cattle;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/breedingBtn") 
	private MobileElement select_breed;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\"" +"com.nitara.farmer:id/btnRemoveRight"+ "\"))")  
	private MobileElement delete_btn;
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[2]") 
	private MobileElement select_yes;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/snackbar_text") 
	private MobileElement delete_cattle;
	
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
	public void deleteActivity() {
		click(delete_btn);	
	}
	public void press_yes() {
		waitVisibility(select_yes);
		click(select_yes);
	}
	public void assert_deletemsg() {
		waitVisibility(delete_cattle);
		Assert.assertEquals(delete_cattle.getText(), " Dry Period data recorded on 19 Dec 2021 has been deleted for this Cattle");
	}
}
