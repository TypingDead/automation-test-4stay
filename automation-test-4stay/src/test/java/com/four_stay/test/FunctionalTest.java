package com.four_stay.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.four_stay.utilities.BrowserUtils;
import com.four_stay.utilities.ConfigurationReader;
import com.four_stay.utilities.Driver;
import com.four_stay.utilities.TestBase;

public class FunctionalTest extends TestBase {
	// testCase#11
	@Test(description = "Dima`s test case")
	public void TC011() {

//		ListYourStayPage listYourStayPage = new ListYourStayPage();
//		AdvancedSearchResultsPage advancedSearchPage = new AdvancedSearchResultsPage();
		Driver.getDriver().get(ConfigurationReader.getProperty("url"));

		listYourStayPage.listYourStayButton.click();
		listYourStayPage.loginHereLink.click();
		listYourStayPage.emailAddressBox.sendKeys(ConfigurationReader.getProperty("username"));
		listYourStayPage.passwordBox.sendKeys(ConfigurationReader.getProperty("password"));
		listYourStayPage.loginButton.click();
		Assert.assertNotEquals(listYourStayPage.currentUrl, listYourStayPage.profileDetailsPage);

	}

	@Test(description = " Dima`s test case")
	public void TC012_() throws InterruptedException {
//		SignUpPage singUpPage = new SignUpPage();
		signUpPage.navigateToSingUpPage();
		BrowserUtils.waitFor(3);
		signUpPage.moreOptions.click();
		assertTrue(signUpPage.continueWithFacebookButton.isDisplayed());
		assertTrue(signUpPage.continueWithGoogleButton.isDisplayed());
		assertTrue(signUpPage.continueEmailButton.isDisplayed());
		signUpPage.continueEmailButton.click();
		System.out.println();
		// sign up field
		signUpPage.completeUserForm(signUpPage.userfirstName, signUpPage.userlLastName, signUpPage.newEmailAddress,
				signUpPage.newUserPassword);
		// click sing in button
		signUpPage.signUpButton.click();
		// registered like a GUEST
		// click on GUEST
		signUpPage.guestIcon.click();
		// verify GUEST icon is selected
		assertTrue(signUpPage.guestButtonIsSelected.isDisplayed());
		// click on button "Next"
		signUpPage.nextButton.click();
		// profile-details
		signUpPage.profileDetails(signUpPage.userPhoneNumber, signUpPage.aboutMyself, signUpPage.userDoB);
		// click save button
		signUpPage.saveButton.click();
		BrowserUtils.waitFor(3);
		// singUpPage.logOut.click();
		// check name is displayed
		if (signUpPage.logOut.isDisplayed()) {
			signUpPage.logOut.click();
		} else {
			assertTrue(signUpPage.nameLink.isDisplayed());
		}
		// assertTrue(singUpPage.nameLink.isDisplayed());
		// registered like a HOST
		BrowserUtils.waitFor(1);
		Driver.getDriver().get("https://4stay.com/sign-up#!/select-role");
		// click on HOST button
		BrowserUtils.waitFor(1);
		signUpPage.hostIcon.click();
		// verify HOST icon is selected
		BrowserUtils.waitFor(1);
		assertTrue(signUpPage.hostIconIsSelected.isDisplayed());
		// click on button "Next"
		BrowserUtils.waitFor(1);
		signUpPage.nextButton.click();
		// profile-details
		// BrowserUtils.waitFor(3);
		signUpPage.hostEmail.clear();
		signUpPage.hostEmail.sendKeys(signUpPage.newRandomEmailAddress(signUpPage.newEmailAddress));
		signUpPage.profileDetails(signUpPage.userPhoneNumber, signUpPage.aboutMyself, signUpPage.userDoB);
		// click save button
		signUpPage.saveButton.click();
		assertEquals(Driver.getDriver().getCurrentUrl(), "https://4stay.com/sign-up#!/profile-details");

	}
}
