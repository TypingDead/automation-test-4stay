package com.four_stay.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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

public class FunctionalTest extends TestBase {
	// testCase#11
	@Test(description = "First test case TC011")
	public void TC011() {

		ListYourStayPage listYourStayPage = new ListYourStayPage();
		AdvancedSearchResultsPage advancedSearchPage = new AdvancedSearchResultsPage();
		driver.get(ConfigurationReader.getProperty("url"));

		listYourStayPage.listYourStayButton.click();
		listYourStayPage.loginHereLink.click();
		listYourStayPage.emailAddressBox.sendKeys(ConfigurationReader.getProperty("username"));
		listYourStayPage.passwordBox.sendKeys(ConfigurationReader.getProperty("password"));
		listYourStayPage.loginButton.click();
		Assert.assertNotEquals(listYourStayPage.currentUrl, listYourStayPage.profileDetailsPage);

	}

	@Test(description = " test case TC012")
	public void TC012_() throws InterruptedException {
		SignUpPage singUpPage = new SignUpPage();
		singUpPage.navigateToSingUpPage();
		BrowserUtils.waitFor(3);
		singUpPage.moreOptions.click();
		assertTrue(singUpPage.continueWithFacebookButton.isDisplayed());
		assertTrue(singUpPage.continueWithGoogleButton.isDisplayed());
		assertTrue(singUpPage.continueEmailButton.isDisplayed());
		singUpPage.continueEmailButton.click();
		System.out.println();
		// sign up field
		singUpPage.completeUserForm(singUpPage.userfirstName, singUpPage.userlLastName, singUpPage.newEmailAddress,
				singUpPage.newUserPassword);
		// click sing in button
		singUpPage.signUpButton.click();
		// registered like a GUEST
		// click on GUEST
		singUpPage.guestIcon.click();
		// verify GUEST icon is selected
		assertTrue(singUpPage.guestButtonIsSelected.isDisplayed());
		// click on button "Next"
		singUpPage.nextButton.click();
		// profile-details
		singUpPage.profileDetails(singUpPage.userPhoneNumber, singUpPage.aboutMyself, singUpPage.userDoB);
		// click save button
		singUpPage.saveButton.click();
		BrowserUtils.waitFor(3);
		// singUpPage.logOut.click();
		// check name is displayed
		if (singUpPage.logOut.isDisplayed()) {
			singUpPage.logOut.click();
		} else {
			assertTrue(singUpPage.nameLink.isDisplayed());
		}
		// assertTrue(singUpPage.nameLink.isDisplayed());
		// registered like a HOST
		BrowserUtils.waitFor(1);
		driver.get("https://4stay.com/sign-up#!/select-role");
		// click on HOST button
		BrowserUtils.waitFor(1);
		singUpPage.hostIcon.click();
		// verify HOST icon is selected
		BrowserUtils.waitFor(1);
		assertTrue(singUpPage.hostIconIsSelected.isDisplayed());
		// click on button "Next"
		BrowserUtils.waitFor(1);
		singUpPage.nextButton.click();
		// profile-details
		// BrowserUtils.waitFor(3);
		singUpPage.hostEmail.clear();
		singUpPage.hostEmail.sendKeys(singUpPage.newRandomEmailAddress(singUpPage.newEmailAddress));
		singUpPage.profileDetails(singUpPage.userPhoneNumber, singUpPage.aboutMyself, singUpPage.userDoB);
		// click save button
		singUpPage.saveButton.click();
		assertEquals(driver.getCurrentUrl(), "https://4stay.com/sign-up#!/profile-details");

	}
}
