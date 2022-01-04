package com.nitara.PageObjects;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
public class ViewPD_Page extends BasePage{

	@AndroidFindBy(id = "com.nitara.farmer:id/search_farm_param") 
	private MobileElement search_cattle;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/cattle_img") 
	private MobileElement select_cattle;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/breedingBtn") 
	private MobileElement select_breed;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\"" +"com.nitara.farmer:id/ivAddHistoryIcon"+ "\"))")  
	private MobileElement add_btn;
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.View/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[1]/android.widget.TextView[1]") 
	private MobileElement insem_type;
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.View/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[1]/android.widget.TextView[1]") 
	private MobileElement insem_pd;
	
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
	}
	public void assert_type() {
		waitVisibility(insem_type);
		Assert.assertEquals(insem_type.getText(), "Physical");
	}
	public void assert_pd() {
		waitVisibility(insem_pd);
		Assert.assertEquals(insem_pd.getText(), "Pregnant");
	}
}
