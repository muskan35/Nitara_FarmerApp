package HealthManagement;

import java.util.Map;

import org.testng.annotations.Test;

import com.nitara.GenericBase.GenericBase;
import com.nitara.Helper.GenerateRandomData;
import com.nitara.PageObjects.EditPD_Page;
import com.nitara.PageObjects.FarmerHomePage;
import com.nitara.PageObjects.ViewPD_Page;
import com.nitara.utils.DataProviderUtils;

public class EditPD extends GenericBase{
	
	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void ViewActivity_EditPD(Map<String,String> data) throws InterruptedException {
		/*@Author: Muskan Khowala
		 * View PD script for viewing PD data in breeding page */
		GenerateRandomData numb = new GenerateRandomData();
		FarmerHomePage obj = new FarmerHomePage();
		Thread.sleep(8000);
		obj.press_Search();/*Clicking on search button in homepage*/
		Thread.sleep(8000);
		EditPD_Page reg = new EditPD_Page();
		reg.SearchCattle(data.get("CattleName"));/*Searching the cattle*/
		reg.SelectCattle();/*Selecting the cattle*/
		reg.hideKeyboard();
		Thread.sleep(8000);
		reg.SelectBreed();/*Clicking on breeding*/
		Thread.sleep(8000);
		reg.addActivity();/*Clicking on add activity button*/
		Thread.sleep(8000);
		Thread.sleep(8000);
		reg.clickPD();/*Clicking on pd button*/
		if(data.get("isCattlePregnant").equalsIgnoreCase("true")) {
			reg.isCattlePregnant();
		}
		reg.press_SaveButton();/*Clicking on save button*/
		reg.goback();/*Clicking on go back button*/
		Thread.sleep(8000);
		reg.pressEdit();/*Clicking on edit button*/
		if(data.get("isCattlePregnant").equalsIgnoreCase("true")) {
			reg.isCattlePregnant();
		}
		reg.update();/*Clicking on update button*/
		reg.goback();/*Clicking on go back button*/
		Thread.sleep(8000);
		reg.pressActivity();/*Finding the add activity button*/
		/*Asserting the edited information*/
		//Thread.sleep(8000);
		reg.findElement("02 Jan 2022");
		reg.assert_date();
	}
}
