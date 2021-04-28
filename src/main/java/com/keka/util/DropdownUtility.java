package com.keka.util;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.keka.base.TestBase;

public class DropdownUtility extends TestBase {

	public void selectDropdown(String dropdownValue) {
		List<WebElement> options = driver.findElements(By.xpath("//div[@role='option']"));
		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase(dropdownValue)) {
				option.click();
				break;
			}
		}
	}
}
