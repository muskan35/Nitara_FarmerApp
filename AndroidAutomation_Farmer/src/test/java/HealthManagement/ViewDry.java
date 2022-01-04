package HealthManagement;

import java.util.Map;

import org.testng.annotations.Test;

import com.nitara.GenericBase.GenericBase;
import com.nitara.Helper.GenerateRandomData;
import com.nitara.PageObjects.AddDeworming_Page;
import com.nitara.PageObjects.FarmerHomePage;
import com.nitara.PageObjects.ViewDry_Page;
import com.nitara.PageObjects.ViewInsemination_Page;
import com.nitara.PageObjects.ViewPD_Page;
import com.nitara.utils.DataProviderUtils;

public class ViewDry extends GenericBase{
	
	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void ViewActivity_Dry(Map<String,String> data) throws InterruptedException {
		/*@Author: Muskan Khowala
		 * View Dry script for viewing Dry data in breeding page */
		GenerateRandomData numb = new GenerateRandomData();
		FarmerHomePage obj = new FarmerHomePage();
		Thread.sleep(8000);
		obj.press_Search();/*Clicking on search button in homepage*/
		Thread.sleep(8000);
		ViewDry_Page reg = new ViewDry_Page();
		reg.SearchCattle(data.get("CattleName"));/*Searching the cattle*/
		reg.SelectCattle();/*Selecting the cattle*/
		reg.hideKeyboard();
		Thread.sleep(8000);
		reg.SelectBreed();/*Clicking on breeding*/
		Thread.sleep(8000);
		reg.addActivity();/*Clicking on add activity button*/
		Thread.sleep(8000);
		reg.press_Dry();/*Clicking on dry period button*/
		/*Asserting the last calving date*/
		reg.findElement("01 Sep 2021");
		reg.assert_calvingdate();
		reg.press_Save();/*Pressing save button*/
		reg.press_back();/*Pressing back button*/
		/*Asserting the insemination date*/
		reg.findElement("19 Dec 2021");
		reg.assert_date();
	}
}
