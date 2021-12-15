package com.nitara.BreedingManagement;

import java.util.Map;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.nitara.GenericBase.GenericBase;
import com.nitara.Helper.GenerateRandomData;
import com.nitara.Helper.HelperFunctions;
import com.nitara.PageObjects.AddCalving_Page;
import com.nitara.PageObjects.BreedingActivities_Page;
import com.nitara.PageObjects.BreedingRecorded_Page;
import com.nitara.PageObjects.CattleList_Page;
import com.nitara.PageObjects.CattleRegistrationSuccess_Page;
import com.nitara.PageObjects.FarmerHomePage;
import com.nitara.PageObjects.LoginObjects;
import com.nitara.utils.DataProviderUtils;

public class AddCalving extends GenericBase{

	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void AddCalving_ValidData(Map<String,String> data) throws Exception {
		
		String username = prop.getProperty("Username");
		String password = prop.getProperty("Password"); 

		//Login with farmer credentials
		LoginObjects login = new LoginObjects();
		login.userLogin(username, password);
		
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
		list.press_SearchBtn();
		Thread.sleep(1000);
		list.findElement(Tag);
		
		//Add insemination for date 283 days from currentdate
		GenerateRandomData date = new GenerateRandomData();
		help.AddInsemination_ForGivenDate(Tag, date.getPastDate(283) );
		
		obj.press_BreedRecordingButton();
		BreedingRecorded_Page msg = new BreedingRecorded_Page();
		//msg.recordAnotherActivity();
		
		//Add PD 21 days after insemination
		help.AddPD_ForGivenDate(Tag, date.getPastDate(283-21) );
		msg.recordAnotherActivity();
		
	

		// Select Calving from the list of activities 
		BreedingActivities_Page breeding = new BreedingActivities_Page();
		breeding.select_Calving();


		AddCalving_Page calving = new AddCalving_Page();
		if(data.get("calfResult").equalsIgnoreCase("Single")) {
			calving.select_CalfResultSingle(data.get("calfResult"),data.get("calfGender1"));
		}
		else {
			calving.select_CalfResultTwins(data.get("calfResult"),data.get("calfGender1"),data.get("calfGender2"));
		}

		calving.select_Time(data.get("calvingTime"));
		calving.enter_CalvingDate(date.getPastDate(0));
		calving.press_SaveButton();

		//Assert cattletag in breeding successfully recorded page
		msg.cattletag_Assert("6408247");
	}

}
