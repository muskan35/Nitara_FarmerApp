package com.nitara.PageObjects;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ViewInsemination_Page extends BasePage{

	@AndroidFindBy(id = "com.nitara.farmer:id/search_farm_param") 
	private MobileElement search_cattle;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/cattle_img") 
	private MobileElement select_cattle;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/breedingBtn") 
	private MobileElement select_breed;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\"" +"com.nitara.farmer:id/ivAddHistoryIcon"+ "\"))")  
	private MobileElement add_btn;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/artificial_insemination") 
	private MobileElement artificial_insem;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/bullId") 
	private MobileElement bullid;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/saveBtn") 
	private MobileElement save_btn;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/back_cattle_result") 
	private MobileElement back_btn;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/tvDateLeft") 
	private MobileElement date_cattle;
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.View/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[1]/android.widget.TextView[1]") 
	private MobileElement insem_type;
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.View/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[1]/android.widget.TextView[2]") 
	private MobileElement insem_bull;
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.View/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[1]/android.widget.TextView[3]") 
	private MobileElement insem_with;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/lastHeatDate") 
	private MobileElement heat_date;
	
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
	public void press_Artificial() {
		waitVisibility(artificial_insem);
		click(artificial_insem);
	}
	public void Bull(String bull_id) {
		waitVisibility(bullid);
		click(bullid);
		sendKeys(bullid,bull_id);
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
		Assert.assertEquals(date_cattle.getText(), "27 Nov 2021");
	}
	public void assert_type() {
		waitVisibility(insem_type);
		Assert.assertEquals(insem_type.getText(), "Artificial");
	}
	public void assert_bullid() {
		waitVisibility(insem_bull);
		Assert.assertEquals(insem_bull.getText(), "100");
	}
	public void assert_with() {
		waitVisibility(insem_with);
		Assert.assertEquals(insem_with.getText(), "SAG");
	}
	public void assert_heatdate() {
		waitVisibility(heat_date);
		Assert.assertEquals(heat_date.getText(), "27 Nov 2021");
	}
}
