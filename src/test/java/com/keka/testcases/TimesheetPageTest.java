package com.keka.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.keka.base.TestBase;
import com.keka.pages.HomePage;
import com.keka.pages.LoginPage;
import com.keka.pages.TimesheetPage;
import com.keka.util.DropdownUtility;
import com.keka.util.TestUtil;

public class TimesheetPageTest extends TestBase {

	LoginPage loginPage;
	TimesheetPage timesheetPage;
	HomePage homePage;
	DropdownUtility dropdownUtility;

	String sheetname = "Timesheet";
	
	public TimesheetPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		timesheetPage = new TimesheetPage();
		homePage = new HomePage();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage.clickOnTimesheet();
	}
	
	@DataProvider
	public Object[][] getTimesheetTestData() {
		Object data[][] = TestUtil.getTestData(sheetname);
		return data;
	}

	@Test(dataProvider="getTimesheetTestData")
	public void verifyTimesheetTest(String day, String hours,String projectCode,String taskCode,String comments) throws InterruptedException{
//		timesheetPage.timesheetFilling("Monday", "8", "VTS 2.0", "01_Customer Billing", "Comments added");
		timesheetPage.timesheetFilling(day, hours, projectCode, taskCode, comments);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
