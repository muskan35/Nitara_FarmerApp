package com.nitara.PageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CattleList_Page extends BasePage{
	
	@AndroidFindBy(id = "com.nitara.farmer:id/search_farm_param") 
	private MobileElement search_cattle;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/search_btn") 
	private MobileElement search_btn;
	
	public void searchCattle(String Tag) {
		// TODO Auto-generated method stub
		sendKeys(search_cattle,Tag);
		
	}
	
	public void press_SearchBtn() {
		click(search_btn);
	}

}
