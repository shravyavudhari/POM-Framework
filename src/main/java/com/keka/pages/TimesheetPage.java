package com.keka.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.keka.base.TestBase;
import com.keka.util.DropdownUtility;

public class TimesheetPage extends TestBase {

	DropdownUtility dropdownUtility;

	public TimesheetPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(text(),'Timesheet')]")
	WebElement timesheet;
//	
//	@FindBy(xpath="//tbody/tr[1]/td[1]/div[1]/div[1]/a[1]")
//	WebElement addTaskbtn;
//	
//	@FindBy(xpath="//p[contains(text(),'VTS 2.0')]")
//	WebElement projectTask;
//	
//	@FindBy(xpath="//p[contains(text(),'01_Customer Billing')]")
//	WebElement custBillingTask;
//	
//	@FindBy(xpath="//tbody/tr[1]/td[2]/div[1]/div[1]/input[1]")
//	WebElement monHrs;
//	
//	@FindBy(xpath="//tbody/tr[1]/td[3]/div[1]/div[1]/input[1]")
//	WebElement tueHrs;
//	
//	@FindBy(xpath="//tbody/tr[1]/td[4]/div[1]/div[1]/input[1]")
//	WebElement wedHrs;
//	
//	@FindBy(xpath="//tbody/tr[1]/td[5]/div[1]/div[1]/input[1]")
//	WebElement thurHrs;
//	
//	@FindBy(xpath="//tbody/tr[1]/td[6]/div[1]/div[1]/input[1]")
//	WebElement friHrs;

	@FindBy(xpath = "//button[@tooltip='Card View']")
	WebElement cardView;

	@FindBy(xpath = "//label[contains(text(),'Project')]//following::input[@role='combobox'][1]")
	@CacheLookup
	//stores element in cache memory and retrieve from it instead of getting it every time from DOM html
	//improves script performance
	//in any case if page gets refreshed then cache memory is corrupted and gives stale element exception
	WebElement clickOnProject;

	@FindBy(xpath = "//ng-select[@formcontrolname='taskId']")
	WebElement clickOnTask;

	@FindBy(xpath = "//input[@formcontrolname='totalHours']")
	WebElement totalHrs;

	@FindBy(xpath = "//textarea[@formcontrolname='comments']")
	WebElement addComments;
	
	@FindBy(xpath = "//button[contains(text(),'Cancel')]")
	WebElement cancelBtn;
	
	@FindBy(xpath="//button[contains(text(),'Add Time')]")
	WebElement saveBtn;
	
	@FindBy(xpath="//div[@id='toast-container']")
	WebElement toastMessage;

	public void selectDropdown(String dropdownValue) {
		List<WebElement> options = driver.findElements(By.xpath("//div[@role='option']"));
		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase(dropdownValue)) {
				option.click();
				break;
			}
		}
	}

	public void dayToEntry(String day) {
		driver.findElement(By.xpath("//p[contains(text(),'" + day
				+ "')]//following::div[1]/div[1]/div[1]/div[@class='card clear-margin']")).click();
	}

	public void timesheetFilling(String day, String hrs, String projCode,String taskCode,String addComment) throws InterruptedException {

		cardView.click();
		dayToEntry(day);
		clickOnProject.click();
		selectDropdown(projCode);
		clickOnTask.click();
		selectDropdown(taskCode);
		totalHrs.sendKeys(hrs);
		addComments.sendKeys(addComment);
		saveBtn.click();
		Thread.sleep(5000);
		
//		String message = toastMessage.getText();
//		System.out.println(message);

	}
}
