package com.nitara.Helper;

import java.io.IOException;
import java.util.Map;
import com.nitara.utils.ExcelUtils;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.nitara.GenericBase.GenericBase;
import com.nitara.PageObjects.AddPD_Page;
import com.nitara.PageObjects.ArtificialInsemination_Page;
import com.nitara.PageObjects.BreedingActivities_Page;
import com.nitara.PageObjects.BreedingRecorded_Page;
import com.nitara.PageObjects.CattleList_Page;
import com.nitara.PageObjects.CattleRegistrationSuccess_Page;
import com.nitara.PageObjects.FarmerHomePage;
import com.nitara.PageObjects.LoginObjects;
import com.nitara.PageObjects.MilkingCattleRegister_Page;
import com.nitara.PageObjects.NaturalInsemination_Page;



public class HelperFunctions extends GenericBase{

	public String RegisterCattle_MilkingCattle() throws  Exception {

		GenerateRandomData numb = new GenerateRandomData();

		String username = prop.getProperty("Username");
		String password = prop.getProperty("Password"); 


		String tagNumber = numb.generateRandomNumber(7);
		String cooptagNumber = numb.generateRandomNumber(12);

	/*	//Login with SP credentials
		LoginObjects login = new LoginObjects();
		login.userLogin(username, password);*/

		String nameofCurrMethod = new Throwable()
				.getStackTrace()[0]
						.getMethodName();

		String sheet = nameofCurrMethod.substring(0,nameofCurrMethod.lastIndexOf("_"));

		System.out.println(sheet);
		System.out.println(nameofCurrMethod);

		ExcelUtils testdata = new ExcelUtils();
		Map<String,String> data = testdata.getTestData(sheet,nameofCurrMethod);


		//Farmer Home page - Select Register Cattle
		FarmerHomePage obj = new FarmerHomePage();
		obj.press_RegisterCattleButton();


		MilkingCattleRegister_Page reg = new MilkingCattleRegister_Page();
		reg.findElement("MILKING AND DRY CATTLE");
		reg.assert_CattleType();
		reg.enter_TagNumber(tagNumber);
		reg.enter_CoopTagNumber(cooptagNumber);
		reg.select_cattleType(data.get("cattleType"));
		reg.select_cattleBreed(data.get("breed"));

		if(data.get("isCrossBreed").equalsIgnoreCase("true")) {
			reg.select_crossbreedToggle(data.get("isCrossBreed"), data.get("crossedWith"));}

		reg.select_Lactation(data.get("currentLactation"));
		reg.enter_Calvingdate(data.get("lastCalvingDate"));
		reg.enter_CalfCount(data.get("calfCount"));
		reg.enter_Calf1Gender(data.get("calf1Gender"));

		if(data.get("calfCount").equalsIgnoreCase("twins")) {
			reg.enter_Calf2Gender(data.get("calf2Gender"));
		}

		// Check cattle Pregnant - Artificial or Natural Insemination
		if(data.get("isCattlePregnant").equalsIgnoreCase("true")) {
			if(data.get("inseminationType").equalsIgnoreCase("artificial")) {
				reg.isCattlePregnant(data.get("pregnantSince"));
				reg.artificialInsemination(data.get("inseminationDate"),data.get("semenBrand") ,data.get("bullId"));
			}
			else{
				reg.isCattlePregnant(data.get("pregnantSince"));
				reg.naturalInsemination(data.get("inseminationDate"),data.get("bullId"));
			}
		}

		// Check cattle is not pregnant and is only inseminated - Artificial or Natural Insemination
		else if(data.get("isCattleInseminated").equalsIgnoreCase("true")) {
			if(data.get("inseminationType").equalsIgnoreCase("artificial")) {
				reg.isCattleInseminated();
				reg.artificialInsemination(data.get("inseminationDate"),data.get("semenBrand"),data.get("bullId"));}

			else{
				reg.isCattleInseminated();
				reg.naturalInsemination(data.get("inseminationDate"),data.get("bullId"));
			}
		}

		if(data.get("isCattleDry").equalsIgnoreCase("true")) {
			reg.cattleIsDry();
			reg.enter_DryPeriodDate(data.get("dryPeriodDate"));
		}

		reg.press_SaveButton();

		Thread.sleep(10000);
		//Cattle Registration Success page
		CattleRegistrationSuccess_Page msg = new CattleRegistrationSuccess_Page();
		msg.assertCattleTag(tagNumber);
		msg.assertSuccessMsg("Registration has been saved successfully for");
		return tagNumber;	
	}


	public void AddInsemination_ForGivenDate(String Tag, String date) throws IOException, InterruptedException {


		String nameofCurrMethod = new Throwable()
				.getStackTrace()[0]
						.getMethodName();

		String sheet = nameofCurrMethod.substring(0,nameofCurrMethod.lastIndexOf("_"));

		System.out.println(sheet);
		System.out.println(nameofCurrMethod);

		ExcelUtils testdata = new ExcelUtils();
		Map<String,String> data = testdata.getTestData(sheet,nameofCurrMethod);


		// Select Insemination accordingly from the list of activities and add insemination details
		BreedingActivities_Page breeding = new BreedingActivities_Page();
		if(data.get("type").equalsIgnoreCase("Artificial")) {
			Thread.sleep(2000);
			breeding.select_ArtificialInsemination(); 
			ArtificialInsemination_Page AI = new ArtificialInsemination_Page();
			AI.assert_CattleTag(Tag); 
			AI.enter_BullId(data.get("bullID"));
			AI.select_semenBrand(data.get("semenBrand"));
			AI.enter_InseminationDate(date);
			AI.press_SaveButton();
		}
		else {
			Thread.sleep(2000);
			breeding.select_NaturalInsemination(); 
			NaturalInsemination_Page NI = new NaturalInsemination_Page();
			NI.assert_CattleTag(Tag); 
			NI.enter_BullId(data.get("bullID"));
			NI.enter_Remarks(data.get("remarks"));
			NI.enter_InseminationDate(date);
			NI.press_SaveButton();
		}


		//Assert cattletag in breeding successfully recorded page
		BreedingRecorded_Page msg = new BreedingRecorded_Page();
		msg.cattletag_Assert(Tag);
		msg.homeButton();

	}



	public void AddPD_ForGivenDate(String Tag, String date) throws IOException, InterruptedException {

		String nameofCurrMethod = new Throwable()
				.getStackTrace()[0]
						.getMethodName();

		String sheet = nameofCurrMethod.substring(0,nameofCurrMethod.lastIndexOf("_"));

		System.out.println(sheet);
		System.out.println(nameofCurrMethod);

		ExcelUtils testdata = new ExcelUtils();
		Map<String,String> data = testdata.getTestData(sheet,nameofCurrMethod);
		
		CattleList_Page list = new CattleList_Page();
		String searchTag = Tag.substring(0, 4);
		list.searchCattle(searchTag);
	//	Thread.sleep(1000);
		list.press_SearchBtn();
		Thread.sleep(1000);
		list.findElement(Tag);
		
		// Select PD accordingly from the list of activities 
		BreedingActivities_Page breeding = new BreedingActivities_Page();
		Thread.sleep(1000);
		breeding.select_pd();

		AddPD_Page pd = new AddPD_Page();
		pd.enter_PDdate(date);
		pd.select_isCattlePregnant(data.get("isCattlePregnant"));
		pd.assert_CattleTag(Tag);
		pd.press_SaveButton();


		//Assert cattletag in breeding successfully recorded page
		BreedingRecorded_Page msg = new BreedingRecorded_Page();
		msg.cattletag_Assert(Tag);
	}
}