package com.ishita.sortingandfiltering.testcases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ishita.sortingandfiltering.base.BaseMethods;

/**
 * This test case performs and validates the sorting functionality.
 *
 */

public class TC001_PerformSorting extends BaseMethods {

	private static final String NAME_COLUMN = "//div[@class='table-row']/div[@class='table-data data-name']";
	private static final String AVERAGE_IMPACT_COLUMN = "//div[@class='table-row']/div[@class='table-data data-averageImpact']";
	
	@Test
	public void performSortingByNameAndValidate() throws IOException {
		getHome().selectSortDataType("Name");
		List<WebElement> actualSortedColumn = getDriver().findElements(By.xpath(NAME_COLUMN));
		validateSortingByName(actualSortedColumn);
	}
	
	private void validateSortingByName(List<WebElement> actualSortedColumn) {
		List<String> actualSortedData = new ArrayList<String>();
		
		for (WebElement data : actualSortedColumn) {
			actualSortedData.add(data.getText());
		}
		
		List<String> expectedSortedData = new ArrayList<String>();
		
		for (String data : actualSortedData) {
			expectedSortedData.add(data);
		}
		
		Collections.sort(expectedSortedData, String.CASE_INSENSITIVE_ORDER);
		Assert.assertEquals(expectedSortedData,actualSortedData);
	}
	
	@Test
	public void performSortingByImpactScoreAndValidate() throws IOException {
		getHome().selectSortDataType("Impact score");
		List<WebElement> actualSortedColumn = getDriver().findElements(By.xpath(AVERAGE_IMPACT_COLUMN));
		validateSortingByImpactScore(actualSortedColumn);
	}

	private void validateSortingByImpactScore(List<WebElement> actualSortedColumn) {
		List<Float> actualSortedData = new ArrayList<Float>();
		
		for (WebElement data : actualSortedColumn) {
			actualSortedData.add(Float.parseFloat(data.getText()));
		}
		
		List<Float> expectedSortedData = new ArrayList<Float>();
		
		for (Float data : actualSortedData) {
			expectedSortedData.add(data);
		}
		
		Collections.sort(expectedSortedData);
		Assert.assertEquals(expectedSortedData,actualSortedData);
	}

}
