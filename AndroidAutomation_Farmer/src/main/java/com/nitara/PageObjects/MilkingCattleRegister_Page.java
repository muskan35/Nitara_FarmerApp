package com.nitara.PageObjects;

import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MilkingCattleRegister_Page  extends BasePage{
	
	@AndroidFindBy(id = "com.nitara.farmer:id/select_cattle_tv") 
	private MobileElement select_cattle;


	@AndroidFindBy(id = "com.nitara.farmer:id/phone_number") 
	private MobileElement phone_number;
	
	
	@AndroidFindBy(id = "com.nitara.farmer:id/earTagNumberOrName") 
	private MobileElement TagNumber;
	
	
	@AndroidFindBy(id = "com.nitara.farmer:id/cooperative_tag_number_et") 
	private MobileElement CoopTagNumber;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\"" +"com.nitara.farmer:id/crossed_with_list_spinner"+ "\"))")  
	private MobileElement crossed_with;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\"" +"com.nitara.farmer:id/cattle_type_spinner"+ "\"))")  
	private MobileElement cattle_type;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/cattle_type_lbl") 
	private MobileElement cattle_type_lbl;
	
	
	@AndroidFindBy(id = "com.nitara.farmer:id/breed_list_spinner") 
	private MobileElement breed_list;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/crossbreed_lbl") 
	private MobileElement crossbreed_lbl;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\"" +"com.nitara.farmer:id/crossbreed_toogle"+ "\"))")  
	private MobileElement crossbreed_toogle;
	
	
	@AndroidFindBy(id = "com.nitara.farmer:id/crossed_with_list_spinner") 
	private MobileElement crossbreed_list;


	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\"" +"com.nitara.farmer:id/is_pregnant"+ "\"))")  
	private MobileElement is_pregnant;
	
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\"" +"com.nitara.farmer:id/insemination_type_spinner"+ "\"))")  
	private MobileElement insemination_type;
	
	
	@AndroidFindBy(id = "com.nitara.farmer:id/pregnant_since_spinner") 
	private MobileElement pregnant_since;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\"" +"com.nitara.farmer:id/inserminationDate"+ "\"))")
	private MobileElement inserminationDate;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/semen_brand_spinner") 
	private MobileElement semen_brand;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\"" +"com.nitara.farmer:id/save_btn"+ "\"))") 
	private MobileElement save_btn;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\"" +"com.nitara.farmer:id/bull_id_et"+ "\"))")  
	private MobileElement bull_id;
	
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\"" +"com.nitara.farmer:id/is_Incerminated"+ "\"))")  
	private MobileElement is_Incerminated;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\"" +"com.nitara.farmer:id/insemination_date_lbl"+ "\"))")  
	private MobileElement insemination_date_lbl;
	
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\"" +"com.nitara.farmer:id/is_cattle_dry"+ "\"))")  
	private MobileElement is_cattle_dry;

	
	@AndroidFindBy(id = "com.nitara.farmer:id/dryPeriodDate") 
	private MobileElement dryPeriodDate;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/calf_result_spinner1") 
	private MobileElement calf_result;
	
	
	@AndroidFindBy(id = "com.nitara.farmer:id/calf_result_spinner_2") 
	private MobileElement calf_result2;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/calf_count_spinner") 
	private MobileElement calf_count;
	
	
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\"" +"com.nitara.farmer:id/current_lactation"+ "\"))")  
	private MobileElement current_lactation;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\"" +"com.nitara.farmer:id/calvingDate"+ "\"))")  
	private MobileElement calvingDate;
	

	public void assert_CattleType() {
		waitVisibility(select_cattle);
		Assert.assertEquals(select_cattle.getText(), "MILKING AND DRY CATTLE");
	}
	
	public void assert_Phone_Number(String phone) {
		waitVisibility(phone_number);
		Assert.assertEquals(phone_number.getText(), phone);
	}
	
	public void enter_TagNumber(String tag) {
		waitVisibility(TagNumber);
		sendKeys(TagNumber,tag);
	}
	
	public void enter_CoopTagNumber(String tag) {
		waitVisibility(CoopTagNumber);
		sendKeys(CoopTagNumber,tag);
	}
	
	
	public void select_cattleType(String type) {
		click(cattle_type);
		select_dropdown(type);
	}
	
	public void select_cattleBreed(String breed) {
		click(breed_list);
		select_dropdown(breed);
	}
	
	public void select_crossbreedToggle(String toggle,String crossbreed) {
		String checked = crossbreed_toogle.getAttribute("checked");
		if(checked.equals("false") && toggle.equals("true")) {
			crossbreed_toogle.click(); 
			click(crossed_with);
			select_dropdown(crossbreed);
		}
	}
	
	public void select_Lactation(String lact) {
		click(current_lactation);
		select_dropdown(lact);
	}
	
	
	public void enter_Calvingdate(String date) {
		sendKeys(calvingDate,date);
	}
	
	public void enter_CalfCount(String count) {
		click(calf_count);
		select_dropdown(count);
	}
	
	public void enter_Calf1Gender(String gender) {
		click(calf_result);
		select_dropdown(gender);
	}
	
	public void enter_Calf2Gender(String gender) {
		click(calf_result2);
		select_dropdown(gender);
	}
	
	
	public void isCattlePregnant(String months) {
		String checked = is_pregnant.getAttribute("checked");
		if(checked.equals("false")) {
			is_pregnant.click();	
			pregnant_Since(months);
		}
	}
	
	public void isCattleInseminated() {
		String checked = is_Incerminated.getAttribute("checked");
		if(checked.equals("false")) {
			is_Incerminated.click();	
		}
	}
	
	public void artificialInsemination(String date,String semen,String BullId) throws InterruptedException {
		enter_InseminationDate(date);
		click(insemination_type);
		select_dropdown("Artificial");
		System.out.println(semen);
		select_semenBrand(semen);
		enter_BullId(BullId);
		hideKeyboard();
	}
	
	
	public void naturalInsemination(String date,String BullId) {
		enter_InseminationDate(date);
		click(insemination_type);
		select_dropdown("Natural");
		enter_BullId(BullId);
		hideKeyboard();
	}
	
	public void pregnant_Since(String months) {
		click(pregnant_since);
		select_dropdown(months+" Month");
	}
	
	public void enter_InseminationDate(String Date) {
		sendKeys(inserminationDate,Date);
	}
	
	public void select_semenBrand(String semen) {
		click(semen_brand);
		select_dropdown(semen);
	}
	
	
	public void enter_BullId(String bullId) {
		sendKeys(bull_id,bullId);
	}
	
	public void press_SaveButton() {
		click(save_btn);	
	}
	
	public void cattleIsDry() {
		String checked = is_cattle_dry.getAttribute("checked");
		if(checked.equals("false")) {
			is_cattle_dry.click();	
		}	
	}
	
	public void enter_DryPeriodDate(String Date) {
		sendKeys(dryPeriodDate,Date);
	}
	
	
	

}
