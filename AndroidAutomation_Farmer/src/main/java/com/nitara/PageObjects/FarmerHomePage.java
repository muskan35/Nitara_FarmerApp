package com.nitara.PageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class FarmerHomePage extends BasePage{
	
	@AndroidFindBy(id = "com.nitara.farmer:id/registerCattleBtn") 
	private MobileElement register_cattle_btn;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/breedRecordingBtn") 
	private MobileElement breedRecording_btn;
	
	
	public void press_RegisterCattleButton()
	{	waitVisibility(register_cattle_btn);
		click(register_cattle_btn);	
	}
	
	public void press_BreedRecordingButton()
	{	waitVisibility( breedRecording_btn);
		click( breedRecording_btn);	
	}
	

}
