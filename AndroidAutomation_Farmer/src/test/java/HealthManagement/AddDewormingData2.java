package HealthManagement;

import java.util.Map;

import org.testng.annotations.Test;

import com.nitara.GenericBase.GenericBase;
import com.nitara.Helper.GenerateRandomData;
import com.nitara.PageObjects.AddDeworming_Page;
import com.nitara.PageObjects.FarmerHomePage;
import com.nitara.utils.DataProviderUtils;

public class AddDewormingData2 extends GenericBase{

	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void AddDeworming_DeleteCattle(Map<String,String> data) throws InterruptedException {
		/*@Author: Muskan Khowala
		 * Delete Deworming script for deleting deworming data */
		GenerateRandomData numb = new GenerateRandomData();
		FarmerHomePage obj = new FarmerHomePage();
		Thread.sleep(8000);
		obj.press_Search();/*Clicking on search button in homepage*/
		Thread.sleep(8000);
		AddDeworming_Page reg = new AddDeworming_Page();
		reg.SearchCattle(data.get("CattleName"));/*Searching the cattle*/
		reg.SelectCattle();/*Selecting the cattle*/
		reg.hideKeyboard();
		Thread.sleep(8000);
		reg.select_health();/*Selecting the health button*/
		reg.assert_FindDeworming();/*Selecting the deworming button*/
		reg.press_addDeworm();/*Clicking on add deworming*/
		Thread.sleep(8000);
		//reg.select_dewormer("Felbendazole");
		reg.assert_ClickDeworm();/*Selecting the dewormer*/
		reg.enter_amount("100");/*Entering amount*/
		reg.press_SaveButton();/*Pressing save button*/
		reg.press_backBtn();/*Pressing back button*/
		reg.press_delete();/*Pressing delete button*/
		Thread.sleep(8000);
		reg.press_confirm();/*Conforming the activity*/
		/*Asserting the delete message*/
		reg.findElement("Deworming activity data recorded on 24 Nov 2021 for this Cattle has been deleted.");
		reg.assert_deletemsg();
	}
}
