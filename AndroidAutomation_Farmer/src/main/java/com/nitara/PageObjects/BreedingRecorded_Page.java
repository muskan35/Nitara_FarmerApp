package com.nitara.PageObjects;

import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class BreedingRecorded_Page extends BasePage{
	
	@AndroidFindBy(id = "com.nitara.farmer:id/cattleTags") 
	private MobileElement cattleTags;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/home") 
	private MobileElement home;

	
	@AndroidFindBy(id = "com.nitara.farmer:id/record_another_cattle") 
	private MobileElement record_another;
	
	
	public void recordAnotherActivity() {
		record_another.click();
	}

	
	public void cattletag_Assert(String tagNumber) {
		
		Assert.assertEquals(cattleTags.getText(), tagNumber);
	}
	
	public void homeButton() {
		home.click();
	}
	

}
