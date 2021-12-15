package com.nitara.BreedingManagement;

import java.util.Map;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.nitara.GenericBase.GenericBase;
import com.nitara.Helper.GenerateRandomData;
import com.nitara.Helper.HelperFunctions;
import com.nitara.PageObjects.AddHeat_Page;
import com.nitara.PageObjects.BreedingActivities_Page;
import com.nitara.PageObjects.BreedingRecorded_Page;
import com.nitara.PageObjects.CattleList_Page;
import com.nitara.PageObjects.CattleRegistrationSuccess_Page;
import com.nitara.PageObjects.FarmerHomePage;
import com.nitara.PageObjects.LoginObjects;
import com.nitara.utils.DataProviderUtils;

public class AddHeatForCattle extends GenericBase{
	
	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void AddHeat_ValidData(Map<String,String> data) throws Exception {
	
		
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
		
		// Select Heat from the list of activities
		BreedingActivities_Page breeding = new BreedingActivities_Page();
		breeding.select_heat();
		
		
		//Add Heat data
		AddHeat_Page heat = new AddHeat_Page();
		heat.assert_CattleTag(Tag);
		heat.select_HeatType(data.get("heatType"));
		heat.select_Time(data.get("heatStartTime"));
		heat.enter_HeatDate(data.get("heatDate"));
		heat.press_SaveButton();
		Thread.sleep(20000);
		
		

		BreedingRecorded_Page msg = new BreedingRecorded_Page();
		msg.cattletag_Assert(Tag);
		
	}
}
