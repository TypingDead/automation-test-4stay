package com.four_stay.test;

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

public class SmokeTest extends TestBase {

	WebDriverWait wait;

	@Test
	public void smokeTest() throws InterruptedException {
		
		Driver.getDriver().get(ConfigurationReader.getProperty("url"));
		wait = new WebDriverWait(Driver.getDriver(), 5);

		assertEquals(Driver.getDriver().getTitle(), "Room rental, roommate finder, off-campus housing, homestay | 4stay");
		homepage.login.click();

		wait.until(ExpectedConditions.visibilityOf(homepage.userEmail));
		assertTrue(homepage.login.isDisplayed());

		homepage.userEmail.sendKeys(ConfigurationReader.getProperty("username"));
		homepage.userPassword.sendKeys(ConfigurationReader.getProperty("password"));
		homepage.loginButton.click();

		Thread.sleep(5000);

		// wait.until(ExpectedConditions.visibilityOf(homepage.searchTab));
		assertTrue(homepage.dashboard.isDisplayed());
		homepage.searchTab.sendKeys("Locust St, Pittsburgh, PA, USA");
		Thread.sleep(2000);
		homepage.searchTab.sendKeys(Keys.DOWN);
		homepage.searchTab.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		homepage.searchButton.click();

		assertEquals(Driver.getDriver().getTitle(),
				"Advanced searchLocust St, Pittsburgh, PA, USA stays | Room rental, roommate finder, off-campus housing, homestay | 4stay");
		advancedSearchPage.firstResult.click();
		AdvancedSearchResultsPage.changeWindow(Driver.getDriver());

		advancedSearchPage.dropDown.click();
		advancedSearchPage.logOut.click();
		


	}

}
