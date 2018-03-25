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

	@Test(description = "Sign in through List Your Stay")
	public void TC011() {

		Driver.getDriver().get(ConfigurationReader.getProperty("url"));

		listYourStayPage.listYourStayButton.click();
		listYourStayPage.loginHereLink.click();
		listYourStayPage.emailAddressBox.sendKeys(ConfigurationReader.getProperty("username"));
		listYourStayPage.passwordBox.sendKeys(ConfigurationReader.getProperty("password"));
		listYourStayPage.loginButton.click();
		Assert.assertNotEquals(listYourStayPage.currentUrl, listYourStayPage.profileDetailsPage);

	}

	@Test(description = "Sign up using Facebook page")
	public void TC012_() throws InterruptedException {
		signUpPage.navigateToSingUpPage();
		BrowserUtils.waitFor(3);
		signUpPage.moreOptions.click();
		assertTrue(signUpPage.continueWithFacebookButton.isDisplayed());
		assertTrue(signUpPage.continueWithGoogleButton.isDisplayed());
		assertTrue(signUpPage.continueEmailButton.isDisplayed());
		signUpPage.continueEmailButton.click();
		System.out.println();

		signUpPage.completeUserForm(signUpPage.userfirstName, signUpPage.userlLastName, signUpPage.newEmailAddress,
				signUpPage.newUserPassword);

		signUpPage.signUpButton.click();

		signUpPage.guestIcon.click();

		assertTrue(signUpPage.guestButtonIsSelected.isDisplayed());

		signUpPage.nextButton.click();

		signUpPage.profileDetails(signUpPage.userPhoneNumber, signUpPage.aboutMyself, signUpPage.userDoB);

		signUpPage.saveButton.click();
		BrowserUtils.waitFor(3);

		if (signUpPage.logOut.isDisplayed()) {
			signUpPage.logOut.click();
		} else {
			assertTrue(signUpPage.nameLink.isDisplayed());
		}

		BrowserUtils.waitFor(1);
		Driver.getDriver().get("https://4stay.com/sign-up#!/select-role");
		
		BrowserUtils.waitFor(1);
		signUpPage.hostIcon.click();

		BrowserUtils.waitFor(1);
		assertTrue(signUpPage.hostIconIsSelected.isDisplayed());

		BrowserUtils.waitFor(1);
		signUpPage.nextButton.click();

		signUpPage.hostEmail.clear();
		signUpPage.hostEmail.sendKeys(signUpPage.newRandomEmailAddress(signUpPage.newEmailAddress));
		signUpPage.profileDetails(signUpPage.userPhoneNumber, signUpPage.aboutMyself, signUpPage.userDoB);
	
		signUpPage.saveButton.click();
		assertEquals(Driver.getDriver().getCurrentUrl(), "https://4stay.com/sign-up#!/profile-details");
	}
}
