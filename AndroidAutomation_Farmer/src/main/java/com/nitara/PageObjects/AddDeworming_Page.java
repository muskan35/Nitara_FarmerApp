package com.nitara.PageObjects;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
public class AddDeworming_Page extends BasePage{
	
	@AndroidFindBy(id = "com.nitara.farmer:id/filter_msg") 
	private MobileElement filter_cattle;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/search_farm_param") 
	private MobileElement search_cattle;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/cattle_img") 
	private MobileElement select_cattle;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/healthBtn") 
	private MobileElement health_bu;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/addDewromingData") 
	private MobileElement add_de;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/amountValue") 
	private MobileElement amt;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/dateValue") 
	private MobileElement dte;
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.View/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.widget.FrameLayout[2]/android.view.View") 
	private MobileElement deworm;
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.View/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.view.View/android.view.View[2]/android.widget.FrameLayout[1]/android.widget.CheckBox")
	private MobileElement click_deworm;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/go_back_to_cattle_result") 
	private MobileElement back;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/viewMore") 
	private MobileElement view;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/dewormerDate") 
	private MobileElement date_cattle;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/dewormerName") 
	private MobileElement dewormer_cattle;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/recordedByValue") 
	private MobileElement farmer_cattle;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/deleteDeworming") 
	private MobileElement delete_bu;
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[2]")
	private MobileElement confirm_bu;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\"" +"com.nitara.farmer:id/saveBtn"+ "\"))")  
	private MobileElement save_btn;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/snackbar_text") 
	private MobileElement delete_cattle;
	
	public void assert_FilterCattle() {
		waitVisibility(filter_cattle);
		Assert.assertEquals(filter_cattle.getText(), "123cattleasc");
	}
	
	public void select_health() {
		click(health_bu);	
	}
	
	public void assert_FindDeworming() {
		//waitVisibility(deworm);
		click(deworm);
	}
	public void SearchCattle(String cattle_name) {
		waitVisibility(search_cattle);
		click(search_cattle);
		sendKeys(search_cattle,cattle_name);
	}
	public void SelectCattle() {
		waitVisibility(select_cattle);
		click(select_cattle);
	}
	public void assert_ClickDeworm() {
		click(click_deworm);
	}
	public void enter_amount(String amount) {
		sendKeys(amt,"100");
	}
	public void enter_date(String date) {
		sendKeys(dte,"16 Nov 2021");
	}
	//public void select_addDeworm() {
		//click(add_deworm);	
	//}
	public void press_SaveButton() {
		click(save_btn);	
	}
	public void press_addDeworm() {
		click(add_de);	
	}
	public void press_backBtn() {
		click(back);	
	}
	public void press_more() {
		click(view);	
	}
	public void assert_date() {
		waitVisibility(date_cattle);
		Assert.assertEquals(date_cattle.getText(), "19 Nov 2021");
	}
	public void assert_dewormname() {
		waitVisibility(dewormer_cattle);
		Assert.assertEquals(dewormer_cattle.getText(), "Felbendazole");
	}
	public void assert_farmername() {
		waitVisibility(farmer_cattle);
		Assert.assertEquals(farmer_cattle.getText(), "Test");
	}
	public void press_delete() {
		click(delete_bu);	
	}
	public void dewormClick(String dewormer) {
		waitVisibility(click_deworm);
		select_dewormer(dewormer);
	}
	public void press_confirm() {
		click(confirm_bu);	
	}
	public void assert_deletemsg() {
		waitVisibility(delete_cattle);
		Assert.assertEquals(delete_cattle.getText(), "Deworming activity data recorded on 24 Nov 2021 for this Cattle has been deleted.");
	}
}
