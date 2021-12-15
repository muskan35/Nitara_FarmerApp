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

public class DewormingData extends GenericBase{
	
	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void AddDeworming_DCattle(Map<String,String> data) throws InterruptedException {
		/*@Author: Muskan Khowala
		 * Add Deworming script for adding deworming data */
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
		reg.select_dewormer("Felbendazole");
		//reg.assert_ClickDeworm();
		reg.enter_amount("100");/*Selecting the dewormer*/
		reg.press_SaveButton();/*Pressing save button*/
		reg.press_backBtn();/*Pressing back button*/
		reg.press_more();/*Clicking on View more*/
		/*Asserting the deworming date*/
		reg.findElement("19 Nov 2021");
		reg.assert_date();
		/*Asserting the dewormer*/
		reg.findElement("Albendazole");
		reg.assert_dewormname();
		/*Asserting the farmer name*/
		reg.findElement("Test");
		reg.assert_farmername();
	}
}
