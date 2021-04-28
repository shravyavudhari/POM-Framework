package com.keka.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.keka.base.TestBase;

public class LoginPage extends TestBase {
	
	//Page Factory ObjectRepository
	@FindBy(linkText="login")
	WebElement loginLink;
	
	@FindBy(id="email")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//img[@class='logo']")
	WebElement mtLogo;
	
	//Initializing Page Objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
		
	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		loginBtn.click();
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
	}

}
