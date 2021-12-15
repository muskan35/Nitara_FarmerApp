package HealthManagement;

import java.util.Map;

import org.testng.annotations.Test;

import com.nitara.GenericBase.GenericBase;
import com.nitara.Helper.GenerateRandomData;
import com.nitara.PageObjects.AddDeworming_Page;
import com.nitara.PageObjects.FarmerHomePage;
import com.nitara.PageObjects.ViewInsemination_Page;
import com.nitara.utils.DataProviderUtils;

public class ViewInsemination extends GenericBase{
	
	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void ViewActivity_Insemination(Map<String,String> data) throws InterruptedException {
		/*@Author: Muskan Khowala
		 * View Insemination script for viewing insemination data in breeding page */
		GenerateRandomData numb = new GenerateRandomData();
		FarmerHomePage obj = new FarmerHomePage();
		Thread.sleep(8000);
		obj.press_Search();/*Clicking on search button in homepage*/
		Thread.sleep(8000);
		ViewInsemination_Page reg = new ViewInsemination_Page();
		reg.SearchCattle(data.get("CattleName"));/*Searching the cattle*/
		reg.SelectCattle();/*Selecting the cattle*/
		reg.hideKeyboard();
		Thread.sleep(8000);
		reg.SelectBreed();/*Clicking on breeding*/
		Thread.sleep(8000);
		reg.addActivity();/*Clicking on add activity button*/
		Thread.sleep(8000);
		reg.press_Artificial();/*Clicking on artificial insemination button*/
		/*Asserting the heat date*/
		reg.findElement("27 Nov 2021");
		reg.assert_heatdate();
		reg.Bull(data.get("Bull_ID"));/*Inserting bullid from excel sheet*/
		reg.hideKeyboard();
		reg.press_Save();/*Pressing save button*/
		reg.press_back();/*Pressing back button*/
		/*Asserting the insemination date*/
		reg.findElement("27 Nov 2021");
		reg.assert_date();
		/*Asserting the type of insemination*/
		reg.findElement("Artificial");
		reg.assert_type();
		/*Asserting the bull id*/
		reg.findElement("100");
		reg.assert_bullid();
		/*Asserting the insemination with*/
		reg.findElement("SAG");
		reg.assert_with();
	}
}
