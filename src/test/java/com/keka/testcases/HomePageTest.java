package com.keka.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.keka.base.TestBase;
import com.keka.pages.HomePage;
import com.keka.pages.LoginPage;

public class HomePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	
	
	
	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test
	public void verifyProfileNameTest() {
		String profileName = homePage.verifyProfileName();
		System.out.println(profileName);
		Assert.assertEquals(profileName, "Shravya Reddy VUDHARI");
	}
	
	@Test
	public void verifyHomePageTitleTest() {
		String title = homePage.verifyHomePageTitle();
		System.out.println("HomePage title:" +title);
		Assert.assertEquals(title, "Keka");
	}
	
	@Test
	public void verifyMeLinkTest() {
		homePage.clickOnTimesheet();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
