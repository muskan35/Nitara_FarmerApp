package HealthManagement;

import java.util.Map;

import org.testng.annotations.Test;

import com.nitara.GenericBase.GenericBase;
import com.nitara.Helper.GenerateRandomData;
import com.nitara.PageObjects.AddDeworming_Page;
import com.nitara.PageObjects.FarmerHomePage;
import com.nitara.PageObjects.ViewInsemination_Page;
import com.nitara.PageObjects.ViewPD_Page;
import com.nitara.utils.DataProviderUtils;

public class ViewPD extends GenericBase{

	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void ViewActivity_PD(Map<String,String> data) throws InterruptedException {
		/*@Author: Muskan Khowala
		 * View PD script for viewing PD data in breeding page */
		GenerateRandomData numb = new GenerateRandomData();
		FarmerHomePage obj = new FarmerHomePage();
		Thread.sleep(8000);
		obj.press_Search();/*Clicking on search button in homepage*/
		Thread.sleep(8000);
		ViewPD_Page reg = new ViewPD_Page();
		reg.SearchCattle(data.get("CattleName"));/*Searching the cattle*/
		reg.SelectCattle();/*Selecting the cattle*/
		reg.hideKeyboard();
		Thread.sleep(8000);
		reg.SelectBreed();/*Clicking on breeding*/
		Thread.sleep(8000);
		//Thread.sleep(8000);
		reg.addActivity();/*Clicking on add activity button*/
		Thread.sleep(8000);
		/*Asserting the type of insemination*/
		reg.findElement("Physical");
		reg.assert_type();
		/*Asserting the type of insemination*/
		reg.findElement("Pregnant");
		reg.assert_pd();
	}
}
