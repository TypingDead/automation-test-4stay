package com.four_stay.test;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.four_stay.pages.AdvancedSearchResultsPage;
import com.four_stay.pages.HomePage;
import com.four_stay.pages.ListYourStayPage;
import com.four_stay.pages.SignUpPage;
import com.four_stay.utilities.BrowserUtils;
import com.four_stay.utilities.ConfigurationReader;
import com.four_stay.utilities.Driver;
import com.four_stay.utilities.TestBase;

/**
 * 
 * @author Rodriguez HomeTest Beta_4Stay
 *
 */
public class ListYourStayTest extends TestBase {

	WebDriverWait wait;	
	ListYourStayPage listYourStayPage = new ListYourStayPage();
	SignUpPage signup = new SignUpPage();


	@Test(description = "List Your Stay by creating new account using valid test data")
	public void TC008() {
		driver = Driver.getDriver();
		driver.get(ConfigurationReader.getProperty("url"));

		listYourStayPage.listYourStayButton.click();

		String current = driver.getCurrentUrl();
		Assert.assertEquals(current, listYourStayPage.actualHostUrl);

		listYourStayPage.firstName.sendKeys("Alex");
		listYourStayPage.lastName.sendKeys("Rodriguez");

		listYourStayPage.emailAddress.sendKeys(BrowserUtils.randomEmailGenerator());
		listYourStayPage.password.sendKeys(ConfigurationReader.getProperty("password"));

		listYourStayPage.checkBox();
		listYourStayPage.phoneNumber.sendKeys("11" + Keys.ENTER);
		BrowserUtils.waitFor(5);
		String current1 = driver.getCurrentUrl();
		Assert.assertEquals(current1, listYourStayPage.profileDetailsPage);

	}

	//@Test(description = "List Your Stay using valid facebook account")
	public void TC009() {
		driver = Driver.getDriver();
		driver.get(ConfigurationReader.getProperty("url1"));
		
		listYourStayPage.isAtUrl();
		listYourStayPage.listYourStayButton.click();
		assertEquals(listYourStayPage.expectedHostUrl(), listYourStayPage.actualHostUrlFB);
	
		listYourStayPage.facebookSignup.click();
		listYourStayPage.facebookEmail.sendKeys("5715337976");
		listYourStayPage.facebookpassword.sendKeys("123Typing" + Keys.ENTER);

		BrowserUtils.waitFor(3);
		assertEquals(listYourStayPage.expectedHostUrl(), listYourStayPage.profileDetailsPageFB);

	}
	
	//@Test(priority = 0, description = "First test case TC011")
	public void TC011() {

		ListYourStayPage listYourStayPage = new ListYourStayPage();
		AdvancedSearchResultsPage advancedSearchPage = new AdvancedSearchResultsPage();
		driver = Driver.getDriver();
		driver.get(ConfigurationReader.getProperty("url1"));
		listYourStayPage.listYourStayButton.click();
		listYourStayPage.loginHereLink.click();
		listYourStayPage.emailAddressBox.sendKeys(ConfigurationReader.getProperty("username"));
		listYourStayPage.passwordBox.sendKeys(ConfigurationReader.getProperty("password"));
		listYourStayPage.loginButton.click();

		Assert.assertNotEquals(listYourStayPage.currentUrl, listYourStayPage.profileDetailsPage);
		listYourStayPage.close.click();
		driver.navigate().refresh();
		listYourStayPage.close.click();
		advancedSearchPage.dropDown.click();
		advancedSearchPage.logOut.click();

	}

}
