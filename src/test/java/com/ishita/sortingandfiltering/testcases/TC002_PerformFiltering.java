package com.ishita.sortingandfiltering.testcases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ishita.sortingandfiltering.base.BaseMethods;
import com.ishita.sortingandfiltering.library.PropertyReader;

/**
 * This test case performs and validates the filtering functionality.
 *
 */

public class TC002_PerformFiltering extends BaseMethods {

	private static final String FILTERED_DATA = "//div[@class='table-row']";
	private static final String ACTUAL_NAME_COMPLEXITY_DATA = "//div[@class='table-data data-name' or @class='table-data data-complexity'] ";

	@Test
	public void performFilteringAndValidate() throws IOException {
		
		List<WebElement> actualNameComplexityData = getDriver().findElements(By.xpath(ACTUAL_NAME_COMPLEXITY_DATA));
		String actualData = "";
		for (WebElement row: actualNameComplexityData) {
			actualData = actualData + row.getText().toLowerCase().replace("\n", "").replace(" ", "");
		}
		
		String[] dataToBeFiltered = PropertyReader.configReader("filter_data").split(",");

		for (String data : dataToBeFiltered ) {
			getHome().enterDataToBeFiltered(data);
			
			List<WebElement> filterDataRows = getDriver().findElements(By.xpath(FILTERED_DATA));
			
			if (filterDataRows.size() > 0) {
				for (WebElement row : filterDataRows) {		
					Assert.assertTrue(row.getText().toLowerCase().replace("\n", "").replace(" ", "").contains(data));
				}
			}
			else {	
				Assert.assertFalse(actualData.contains(data));
			}
		}
	}

}
