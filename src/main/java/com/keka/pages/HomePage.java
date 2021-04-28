package com.keka.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory	;

import com.keka.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//span[@class='profile-name']")
	WebElement profileName;

	@FindBy(xpath = "//a[@href ='/ui/#/me/leave']")
	WebElement meLink;
	

	@FindBy(xpath="//body/xhr-app-root[1]/div[1]/xhr-left-nav[1]/nav[1]/div[1]/ul[1]/li[2]/div[1]/ul[1]/li[2]/a[1]/span[1]")
	WebElement timesheet;

	@FindBy(xpath = "//a[@href='#/inbox']")
	WebElement inboxLink;

	@FindBy(xpath = "//span[contains(text(),'My Team')]")
	WebElement myTeamLink;

	@FindBy(xpath = "//span[contains(text(),'My Finances')]")
	WebElement myFinancesLink;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public String verifyProfileName() {
		return profileName.getText();
	}
	
//	public MeLinkPage clickOnMeLink() {
//		meLink.click();
//		return new MeLinkPage();
//	}
	
	public void clickOnMyTeamLink() {
		myTeamLink.click();
	}
	
	public void clickOnInboxLink() {
		inboxLink.click();
			
	}
	
	public void clickOnTimesheet() {
		Actions action = new Actions(driver);
		action.moveToElement(meLink).build().perform();
		timesheet.click();
		
	}
	
}
