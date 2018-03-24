package com.four_stay.demo;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.four_stay.pages.AdvancedSearchResultsPage;
import com.four_stay.pages.HomePage;
import com.four_stay.utilities.BrowserUtils;
import com.four_stay.utilities.ConfigurationReader;
import com.four_stay.utilities.Driver;
import com.four_stay.utilities.TestBase;

public class SmokeTestDemo extends TestBase {

	HomePage homepage = new HomePage();
	AdvancedSearchResultsPage advancedSearchPage = new AdvancedSearchResultsPage();
	WebDriver driver;
	WebDriverWait wait;

	@Test
	public void smokeTest()  {
		driver = Driver.getDriver();
		driver.get(ConfigurationReader.getProperty("url"));
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 5);

		assertEquals(driver.getTitle(), "Room rental, roommate finder, off-campus housing, homestay | 4stay");
		BrowserUtils.highlightAreaWithJavascript(homepage.login);
		homepage.login.click();

		wait.until(ExpectedConditions.visibilityOf(homepage.userEmail));
		assertTrue(homepage.login.isDisplayed());

		BrowserUtils.highLighterBackground(homepage.userEmail);
		homepage.userEmail.sendKeys(ConfigurationReader.getProperty("username"));
		
		BrowserUtils.highLighterBackground(homepage.userPassword);
		homepage.userPassword.sendKeys(ConfigurationReader.getProperty("password"));
		
		BrowserUtils.highlightAreaWithJavascript(homepage.loginButton);
		homepage.loginButton.click();

		BrowserUtils.waitFor(2);

		// wait.until(ExpectedConditions.visibilityOf(homepage.searchTab));
		BrowserUtils.highlightAreaWithJavascript(homepage.dashboard);
		assertTrue(homepage.dashboard.isDisplayed());
		
		BrowserUtils.highLighterBackground(homepage.searchTab);
		homepage.searchTab.sendKeys("Locust St, Pittsburgh, PA, USA");
		BrowserUtils.waitFor(2);
		homepage.searchTab.sendKeys(Keys.DOWN);
		homepage.searchTab.sendKeys(Keys.ENTER);
		BrowserUtils.waitFor(2);
		BrowserUtils.highlightAreaWithJavascript(homepage.searchButton);
		homepage.searchButton.click();

		assertEquals(driver.getTitle(),
				"Advanced searchLocust St, Pittsburgh, PA, USA stays | Room rental, roommate finder, off-campus housing, homestay | 4stay");
		BrowserUtils.highlightAreaWithJavascript(advancedSearchPage.firstResult);
		advancedSearchPage.firstResult.click();
		AdvancedSearchResultsPage.changeWindow(driver);
		// advancedSearchPage.requestStay.click();

		BrowserUtils.highlightAreaWithJavascript(advancedSearchPage.dropDown);
		advancedSearchPage.dropDown.click();
		
		BrowserUtils.highlightAreaWithJavascript(advancedSearchPage.logOut);
		advancedSearchPage.logOut.click();
		


	}

}
