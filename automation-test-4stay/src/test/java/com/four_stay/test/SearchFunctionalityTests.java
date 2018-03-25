package com.four_stay.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import javax.swing.text.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.four_stay.pages.AdvancedSearchResultsPage;
import com.four_stay.pages.HomePage;
import com.four_stay.pages.SignUpPage;
import com.four_stay.utilities.BrowserUtils;
import com.four_stay.utilities.ConfigurationReader;
import com.four_stay.utilities.Driver;
import com.four_stay.utilities.TestBase;

public class SearchFunctionalityTests extends TestBase {

//	HomePage homepage = new HomePage();
//	SignUpPage signUp = new SignUpPage();
//	AdvancedSearchResultsPage searchResult = new AdvancedSearchResultsPage();

	@Test( description = "test case TC018")
	public void testCase18() {
		assertTrue(homepage.isAt());
		assertTrue(homepage.isAtUrl());
		homepage.searchTab.click();
		assertTrue(homepage.searchTab.getText().isEmpty());
		homepage.searchButton.click();
		assertEquals(homepage.AfterclicktheButton.getText(), "Please type your city, college, or metro");
	}

	@Test( description = "test case TC019")
	public void testCase19() throws InterruptedException {
		Actions action = new Actions(Driver.getDriver());
		assertTrue(homepage.isAt());
		assertTrue(homepage.isAtUrl());
		homepage.sendKeyToSearchBox();
		BrowserUtils.waitFor(2);
		action.sendKeys(Keys.ARROW_DOWN).perform();
		action.sendKeys(Keys.ENTER).perform();
		Thread.sleep(2000);
		homepage.searchButton.click();
		String value = homepage.result.getText();
		Integer.parseInt(value);
		assertTrue(Integer.parseInt(value) > 0);
	}

	@Test( description = "test case TC011 From different test case")
	public void testCase11() {
		Actions action = new Actions(Driver.getDriver());
		Driver.getDriver().get(ConfigurationReader.getProperty("url"));
		assertTrue(homepage.isAt());
		assertTrue(homepage.isAtUrl());
		homepage.sendKeyToSearchBox2();
		BrowserUtils.waitFor(2);
		action.sendKeys(Keys.ARROW_DOWN).perform();
		action.sendKeys(Keys.ENTER).perform();
		BrowserUtils.waitFor(2);
		homepage.searchButton.click();
		assertTrue(advancedSearchPage.isAt());
		assertTrue(advancedSearchPage.isUrl());
		advancedSearchPage.firstResult.click();
		AdvancedSearchResultsPage.changeWindow(Driver.getDriver());
		advancedSearchPage.titleContains();
		BrowserUtils.waitFor(2);
		advancedSearchPage.requestStay.click();
		BrowserUtils.waitFor(2);
		assertTrue(advancedSearchPage.logo.isDisplayed());

	}

	@Test( description = "test case TC012 From different test case")
	public void testCase12() {
		Actions action = new Actions(Driver.getDriver());
		Driver.getDriver().get(ConfigurationReader.getProperty("url"));
		assertTrue(homepage.isAt());
		assertTrue(homepage.isAtUrl());
		homepage.login.click();
		homepage.userEmail.sendKeys(ConfigurationReader.getProperty("username"));
		homepage.userPassword.sendKeys(ConfigurationReader.getProperty("password"));
		homepage.loginButton.click();
		assertTrue(homepage.dashboard.isDisplayed());
		homepage.sendKeyToSearchBox2();
		BrowserUtils.waitFor(2);
		action.sendKeys(Keys.ARROW_DOWN).perform();
		action.sendKeys(Keys.ENTER).perform();
		BrowserUtils.waitFor(2);
		homepage.searchButton.click();
		assertTrue(advancedSearchPage.isAt());
		assertTrue(advancedSearchPage.isUrl());
		advancedSearchPage.firstResult.click();
		AdvancedSearchResultsPage.changeWindow(Driver.getDriver());
		advancedSearchPage.titleContains();
		// BrowserUtils.waitFor(2);
		// searchResult.requestStay.click();
		// BrowserUtils.waitFor(2);
		// searchResult.CongratulationDisplay();
		// searchResult.requestCenter.click();
		// searchResult.cancelButton.click();

	}

}
