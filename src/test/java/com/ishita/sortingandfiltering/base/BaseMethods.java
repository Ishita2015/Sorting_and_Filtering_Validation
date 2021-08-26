package com.ishita.sortingandfiltering.base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.ishita.sortingandfiltering.library.PropertyReader;
import com.ishita.sortingandfiltering.pages.HomePage;

public class BaseMethods {

	private static WebDriver driver;
	private static HomePage home;
	private static WebDriverWait wait;
	
	@BeforeClass
	public void startBrowser() throws IOException {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(PropertyReader.configReader("url"));
		driver.manage().window().maximize();
		
		setHome(PageFactory.initElements(driver, HomePage.class));
		setWait(new WebDriverWait(driver, 10));
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.close();
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public void setDriver(WebDriver driver) {
		BaseMethods.driver = driver;
	}

	public HomePage getHome() {
		return home;
	}

	public void setHome(HomePage home) {
		BaseMethods.home = home;
	}

	public WebDriverWait getWait() {
		return wait;
	}

	public void setWait(WebDriverWait wait) {
		BaseMethods.wait = wait;
	}
	
}
