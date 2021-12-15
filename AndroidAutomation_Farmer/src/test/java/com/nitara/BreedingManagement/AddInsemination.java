package com.nitara.BreedingManagement;

import java.util.Map;

import org.testng.annotations.Test;

import com.nitara.GenericBase.GenericBase;
import com.nitara.Helper.HelperFunctions;
import com.nitara.PageObjects.ArtificialInsemination_Page;
import com.nitara.PageObjects.BreedingActivities_Page;
import com.nitara.PageObjects.BreedingRecorded_Page;
import com.nitara.PageObjects.CattleList_Page;
import com.nitara.PageObjects.CattleRegistrationSuccess_Page;
import com.nitara.PageObjects.FarmerHomePage;
import com.nitara.PageObjects.NaturalInsemination_Page;
import com.nitara.utils.DataProviderUtils;

public class AddInsemination extends GenericBase{

	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void AddInsemination_ValidData(Map<String,String> data) throws Exception {
		
		//Register a milking cattle
		HelperFunctions help = new HelperFunctions();
		String Tag = help.RegisterCattle_MilkingCattle();

		//Go back to Home Page after cattle Registration
		CattleRegistrationSuccess_Page home = new CattleRegistrationSuccess_Page();
		home.goBackToHomePage();

		//Farmer Home page - Select Register Cattle
		FarmerHomePage obj = new FarmerHomePage();
		obj.press_BreedRecordingButton();

		// Select Cattle using Tag Numbers
		CattleList_Page list = new CattleList_Page();
		String searchTag = Tag.substring(0, 4);
		list.searchCattle(searchTag);
		list.findElement(Tag);
		Thread.sleep(2000);
		

		// Select Insemination accordingly from the list of activities and add insemination details
		BreedingActivities_Page breeding = new BreedingActivities_Page();
		if(data.get("type").equalsIgnoreCase("Artificial")) {
			Thread.sleep(1000);
			breeding.select_ArtificialInsemination(); 
			ArtificialInsemination_Page AI = new ArtificialInsemination_Page();
			AI.assert_CattleTag(Tag); 
			AI.enter_BullId(data.get("bullID"));
			AI.select_semenBrand(data.get("semenBrand"));
			AI.enter_InseminationDate(data.get("inseminationDate"));
			AI.press_SaveButton();
		}
		else {
			breeding.select_NaturalInsemination(); 
			Thread.sleep(1000);
			NaturalInsemination_Page NI = new NaturalInsemination_Page();
			NI.assert_CattleTag(Tag); 
			NI.enter_BullId(data.get("bullID"));
			NI.enter_Remarks(data.get("remarks"));
			NI.enter_InseminationDate(data.get("inseminationDate"));
			NI.press_SaveButton();
		}
		
		
		//Assert cattletag in breeding successfully recorded page
		BreedingRecorded_Page msg = new BreedingRecorded_Page();
		msg.cattletag_Assert(Tag);
		

	
	}
}