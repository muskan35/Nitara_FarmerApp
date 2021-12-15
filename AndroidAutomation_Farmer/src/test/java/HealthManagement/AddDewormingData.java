package HealthManagement;

import com.nitara.GenericBase.GenericBase;
import com.nitara.Helper.GenerateRandomData;
import com.nitara.PageObjects.FarmerHomePage;
import com.nitara.PageObjects.AddDeworming_Page;
import com.nitara.utils.DataProviderUtils;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class AddDewormingData extends GenericBase{
	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void AddDeworming_Cattle(Map<String,String> data) throws InterruptedException {
		/*@Author: Muskan Khowala
		 * Add Deworming script for adding deworming data */
		GenerateRandomData numb = new GenerateRandomData();
		FarmerHomePage obj = new FarmerHomePage();
		Thread.sleep(8000);
		obj.press_HealthManagementButton();/*Selecting the health button*/
		Thread.sleep(8000);
		AddDeworming_Page reg = new AddDeworming_Page();
		reg.SearchCattle(data.get("CattleName"));/*Searching the cattle*/
		reg.SelectCattle();/*Selecting the cattle*/
		reg.hideKeyboard();
		Thread.sleep(8000);
		reg.assert_FindDeworming();/*Selecting the deworming button*/
		
		//reg.select_dewormer(data.get("Dewormer"));
		reg.dewormClick("Felbendazole");/*Selecting the dewormer*/
		reg.enter_amount("100");/*Entering amount*/
		//reg.enter_date("16 Nov 2021");
		reg.press_SaveButton();/*Pressing save button*/
	}
}
