package com.ishita.sortingandfiltering.library;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.ishita.sortingandfiltering.base.BaseMethods;

public class PageActions extends BaseMethods{

	public void enterDataIntoTextBox(WebElement element, String data) {
		getWait().until(ExpectedConditions.visibilityOf(element));
		element.clear();
		element.sendKeys(data);
	}
	
	public void clickButton(WebElement element) {
		getWait().until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	
	public void selectDataUsingVisibleText(WebElement element, String visibletext) {
		getWait().until(ExpectedConditions.textToBePresentInElement(element, visibletext));
		Select selectdata = new Select(element);
		selectdata.selectByVisibleText(visibletext);
	}

}
