package com.ishita.sortingandfiltering.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ishita.sortingandfiltering.library.PageActions;

public class HomePage {
	
	public PageActions action;
	public HomePage() {
		action = new PageActions();
	}

	@FindBy(id="sort-select") WebElement sortDataDropdown;
	@FindBy(id="filter-input") WebElement filterDataTextbox;

	public void selectSortDataType(String type) {
		action.selectDataUsingVisibleText(sortDataDropdown, type);
	}
	
	public void enterDataToBeFiltered(String data) {
		action.enterDataIntoTextBox(filterDataTextbox, data);
	}

}
