package com.nitara.BreedingManagement;

import java.util.Map;

import org.testng.annotations.Test;

import com.nitara.GenericBase.GenericBase;
import com.nitara.Helper.GenerateRandomData;
import com.nitara.Helper.HelperFunctions;
import com.nitara.PageObjects.AddDryPeriod_Page;
import com.nitara.PageObjects.AddPD_Page;
import com.nitara.PageObjects.BreedingActivities_Page;
import com.nitara.PageObjects.BreedingRecorded_Page;
import com.nitara.PageObjects.CattleList_Page;
import com.nitara.PageObjects.CattleRegistrationSuccess_Page;
import com.nitara.PageObjects.FarmerHomePage;
import com.nitara.PageObjects.LoginObjects;
import com.nitara.utils.DataProviderUtils;

public class AddDryPeriod extends GenericBase{

	@Test
	public void AddDryPeriod_ValidData() throws Exception {


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
		//	Thread.sleep(1000);
		list.press_SearchBtn();
		Thread.sleep(1000);
		list.findElement(Tag);

		//Add insemination for date 40 days from currentdate
		GenerateRandomData date = new GenerateRandomData();
		help.AddInsemination_ForGivenDate(Tag, date.getPastDate(40) );

		obj.press_BreedRecordingButton();
		BreedingRecorded_Page msg = new BreedingRecorded_Page();
		//msg.recordAnotherActivity();


		// Select Cattle using Tag Numbers
		list = new CattleList_Page();
		searchTag = Tag.substring(0, 4);
		list.searchCattle(searchTag);
		//	Thread.sleep(1000);
		list.press_SearchBtn();
		Thread.sleep(1000);
		list.findElement(Tag);

		// Select DryPeriod from the list of activities 
		BreedingActivities_Page breeding = new BreedingActivities_Page();
		breeding.select_DryPeriod();


		AddDryPeriod_Page dry = new AddDryPeriod_Page();
		dry.enter_Drydate(date.getPastDate(20));
		dry.press_SaveButton();

		//Assert cattletag in breeding successfully recorded page
		msg.cattletag_Assert(Tag);
	}


}
