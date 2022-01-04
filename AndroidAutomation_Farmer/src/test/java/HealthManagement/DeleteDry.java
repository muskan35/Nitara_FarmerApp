package HealthManagement;

import java.util.Map;

import org.testng.annotations.Test;

import com.nitara.GenericBase.GenericBase;
import com.nitara.Helper.GenerateRandomData;
import com.nitara.PageObjects.AddDeworming_Page;
import com.nitara.PageObjects.DeleteDry_Page;
import com.nitara.PageObjects.DeleteInsemination_Page;
import com.nitara.PageObjects.FarmerHomePage;
import com.nitara.PageObjects.ViewInsemination_Page;
import com.nitara.utils.DataProviderUtils;

public class DeleteDry extends GenericBase{

	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void ViewActivity_DeleteDry(Map<String,String> data) throws InterruptedException {
		/*@Author: Muskan Khowala
		 * Delete Dry Period script for deleting dry period data in breeding page */
		GenerateRandomData numb = new GenerateRandomData();
		FarmerHomePage obj = new FarmerHomePage();
		Thread.sleep(8000);
		obj.press_Search();/*Clicking on search button in homepage*/
		Thread.sleep(8000);
		DeleteDry_Page reg = new DeleteDry_Page();
		reg.SearchCattle(data.get("CattleName"));/*Searching the cattle*/
		reg.SelectCattle();/*Selecting the cattle*/
		reg.hideKeyboard();
		Thread.sleep(8000);
		reg.SelectBreed();/*Clicking on breeding*/
		Thread.sleep(8000);
		reg.deleteActivity();/*Clicking on delete activity button*/
		Thread.sleep(8000);
		reg.press_yes();/*Conforming the activity*/
		/*Asserting the delete message*/
		reg.findElement(" Dry Period data recorded on 19 Dec 2021 has been deleted for this Cattle");
		reg.assert_deletemsg();
	}
}
