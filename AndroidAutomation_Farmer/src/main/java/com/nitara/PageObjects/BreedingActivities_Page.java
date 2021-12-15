package com.nitara.PageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class BreedingActivities_Page  extends BasePage{
	
	@AndroidFindBy(id = "com.nitara.farmer:id/heatCardView") 
	private MobileElement heat;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/artificial_insemination") 
	private MobileElement artificial_insemination;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/natural_insemination") 
	private MobileElement natural_insemination;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\"" +"com.nitara.farmer:id/pdCardView"+ "\"))")  
	private MobileElement pd;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\"" +"com.nitara.farmer:id/calvingCardView"+ "\"))")  
	private MobileElement calving;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\"" +"com.nitara.farmer:id/dryCardView"+ "\"))")  
	private MobileElement dryPeriod;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\"" +"com.nitara.farmer:id/backBtnText"+ "\"))")  
	private MobileElement backToCattleList;
	
	

	
	public void select_pd() {
		pd.click();
	}
	
	public void select_ArtificialInsemination() {
		artificial_insemination.click();
	}
	
	
	public void select_NaturalInsemination() {
		natural_insemination.click();
	}
	
	public void select_heat() {
		waitVisibility(heat);
		click(heat);
	}
	
	

	public void select_Calving() {
		waitVisibility(calving);
		click(calving);
	}
	

	public void select_DryPeriod() {
		waitVisibility(dryPeriod);
		click(dryPeriod);
	}
	

}
