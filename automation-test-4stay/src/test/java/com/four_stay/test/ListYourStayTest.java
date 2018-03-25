package com.four_stay.test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.four_stay.pages.AdvancedSearchResultsPage;
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
//	ListYourStayPage listYourStayPage = new ListYourStayPage();
//	SignUpPage signup = new SignUpPage();

	@Test(description = "List Your Stay by creating new account using valid test data")
	public void TC008() {

//		Driver.getDriver().get(ConfigurationReader.getProperty("url"));
//		driverLaunch(ConfigurationReader.getProperty("url"));
		
		listYourStayPage.listYourStayButton.click();

		String current = Driver.getDriver().getCurrentUrl();
		Assert.assertEquals(current, listYourStayPage.actualHostUrl);

		listYourStayPage.firstName.sendKeys("Alex");
		listYourStayPage.lastName.sendKeys("Rodriguez");

		listYourStayPage.emailAddress.sendKeys(BrowserUtils.randomEmailGenerator());
		listYourStayPage.password.sendKeys(ConfigurationReader.getProperty("password"));

		listYourStayPage.checkBox();
		listYourStayPage.phoneNumber.sendKeys("11" + Keys.ENTER);
		BrowserUtils.waitFor(5);
		String current1 = Driver.getDriver().getCurrentUrl();
		Assert.assertEquals(current1, listYourStayPage.profileDetailsPage);

	}

	@Test(description = "List Your Stay using valid facebook account")
	public void TC009() {

		Driver.getDriver().get(ConfigurationReader.getProperty("url"));
		listYourStayPage.logOut();
		listYourStayPage.isAtUrl();
		listYourStayPage.listYourStayButton.click();
		assertEquals(listYourStayPage.expectedHostUrl(), listYourStayPage.actualHostUrl);

		listYourStayPage.facebookSignup.click();
		listYourStayPage.facebookEmail.sendKeys("5715337976");
		listYourStayPage.facebookpassword.sendKeys("123Typing" + Keys.ENTER);

		BrowserUtils.waitFor(3);
		assertEquals(listYourStayPage.expectedHostUrl(), listYourStayPage.profileDetailsPage);

	}


}
