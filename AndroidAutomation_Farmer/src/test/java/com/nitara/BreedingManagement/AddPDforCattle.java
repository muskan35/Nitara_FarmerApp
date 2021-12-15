package com.nitara.BreedingManagement;

import java.util.Map;

import org.testng.annotations.Test;

import com.nitara.GenericBase.GenericBase;
import com.nitara.Helper.GenerateRandomData;
import com.nitara.Helper.HelperFunctions;
import com.nitara.PageObjects.AddPD_Page;
import com.nitara.PageObjects.BreedingActivities_Page;
import com.nitara.PageObjects.BreedingRecorded_Page;
import com.nitara.PageObjects.CattleList_Page;
import com.nitara.PageObjects.CattleRegistrationSuccess_Page;
import com.nitara.PageObjects.FarmerHomePage;
import com.nitara.PageObjects.LoginObjects;
import com.nitara.utils.DataProviderUtils;

public class AddPDforCattle extends GenericBase{

	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void AddPD_ValidData(Map<String,String> data) throws Exception {

		
		/*String username = prop.getProperty("Username");
		String password = prop.getProperty("Password"); 

		//Login with SP credentials
		LoginObjects login = new LoginObjects();
		login.userLogin(username, password);*/
		
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

		// Select PD accordingly from the list of activities 
		BreedingActivities_Page breeding = new BreedingActivities_Page();
		breeding.select_pd();

		AddPD_Page pd = new AddPD_Page();
		pd.enter_PDdate(date.getPastDate(40-21));
		pd.select_isCattlePregnant(data.get("isCattlePregnant"));
		pd.assert_CattleTag(Tag);
		pd.press_SaveButton();


		//Assert cattletag in breeding successfully recorded page
		msg.cattletag_Assert(Tag);
	}

}
