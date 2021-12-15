package com.nitara.PageObjects;

import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ArtificialInsemination_Page extends BasePage{
		
		@AndroidFindBy(id = "com.nitara.farmer:id/bullId") 
		private MobileElement bullId;
		
		@AndroidFindBy(id = "com.nitara.farmer:id/insemination_date") 
		private MobileElement insemination_date;
		
		@AndroidFindBy(id = "com.nitara.farmer:id/semenBrand") 
		private MobileElement semenBrand;
		
		@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
				+ "new UiSelector().resourceIdMatches(\"" +"com.nitara.farmer:id/saveBtn"+ "\"))")  
		private MobileElement save_btn;
		
		@AndroidFindBy(id = "com.nitara.farmer:id/cattleTagName") 
		private MobileElement cattleTag;
		

		public void assert_CattleTag(String tag) {
			Assert.assertEquals(cattleTag.getText(), tag);
		}
		
		
		public void enter_BullId(String id) {
			sendKeys(bullId, id);
			
		}
		public void enter_InseminationDate(String date) {
			insemination_date.clear();
			sendKeys(insemination_date,date);
		}
		
		public void select_semenBrand(String semen) {
			click(semenBrand);
			select_dropdown(semen);
		}
		
		public void press_SaveButton() {
			click(save_btn);	
		}
		

		
		
		
		

	

}
