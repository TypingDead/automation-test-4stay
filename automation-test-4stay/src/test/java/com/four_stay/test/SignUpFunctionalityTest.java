package com.four_stay.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.four_stay.pages.SignUpPage;
import com.four_stay.utilities.BrowserUtils;
import com.four_stay.utilities.ConfigurationReader;
import com.four_stay.utilities.Driver;
import com.four_stay.utilities.TestBase;

public class SignUpFunctionalityTest extends TestBase {

	SignUpPage signUpPage = new SignUpPage();
	WebDriver driver;
	WebDriverWait wait;

	@Test( description = "Sign Up: Positive Path")
	public void TC012() throws InterruptedException {
		signUpPage.navigateToSingUpPage();
		BrowserUtils.waitFor(3);
		signUpPage.moreOptions.click();
		
		assertTrue(signUpPage.continueWithFacebookButton.isDisplayed());
		assertTrue(signUpPage.continueWithGoogleButton.isDisplayed());
		assertTrue(signUpPage.continueEmailButton.isDisplayed());
		
		signUpPage.continueEmailButton.click();
		System.out.println();
		//sign up field
		signUpPage.completeUserForm(signUpPage.userfirstName, signUpPage.userlLastName,
				signUpPage.newEmailAddress,signUpPage.newUserPassword );
		//click sing in button
		signUpPage.signUpButton.click();
		//	registered like a GUEST
		//click on GUEST
		signUpPage.guestIcon.click();
		//verify GUEST icon is selected
		assertTrue(signUpPage.guestButtonIsSelected.isDisplayed());
		//click on button "Next"
		signUpPage.nextButton.click();
		//profile-details
		signUpPage.profileDetails(signUpPage.userPhoneNumber,
				signUpPage.aboutMyself, signUpPage.userDoB);
		//click save button
		signUpPage.saveButton.click();
		//check name is displayed
		assertTrue(signUpPage.nameLink.isDisplayed());
		//registered like a HOST
		driver.get("https://4stay.com/sign-up#!/select-role");
		//click on HOST button
		signUpPage.hostIcon.click();
		//verify HOST icon is selected
		assertTrue(signUpPage.hostIconIsSelected.isDisplayed());
		//click on button "Next"
		signUpPage.nextButton.click();
		//profile-details
	//	BrowserUtils.waitFor(3);
		signUpPage.hostEmail.clear();
		signUpPage.hostEmail.sendKeys(signUpPage.newRandomEmailAddress(signUpPage.newEmailAddress));
		signUpPage.profileDetails(signUpPage.userPhoneNumber,
				signUpPage.aboutMyself, signUpPage.userDoB);
		//click save button
		signUpPage.saveButton.click();
		assertEquals(driver.getCurrentUrl(), "https://4stay.com/sign-up#!/profile-details");
	}

	@Test(description = "Sign Up: Negative Path")
	public void TC013() throws InterruptedException {

		driver = Driver.getDriver();
		driver.get(ConfigurationReader.getProperty("signupurl"));
		wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.elementToBeClickable(signUpPage.moreOptions));
		signUpPage.moreOptions.click();
		signUpPage.emailSignInOption.click();
		wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.visibilityOf(signUpPage.firstName));

		assertTrue(signUpPage.firstName.isDisplayed());
		assertTrue(signUpPage.lastName.isDisplayed());

		signUpPage.firstName.sendKeys("Elvira");
		signUpPage.lastName.sendKeys("Metoff");
		signUpPage.emailAddress.sendKeys(BrowserUtils.randomEmailGenerator());
		signUpPage.newPassword.sendKeys(ConfigurationReader.getProperty("password"));

		signUpPage.signUpButton.click();

		assertTrue(signUpPage.closeX.isEnabled());

		Thread.sleep(5000);
		signUpPage.closeX.click();

		signUpPage.verifyFirstNameIsNotPresent();
		signUpPage.verifyLastNameIsNotPresent();

	}

	@Test(description = "Sign Up: Negative Path Incorrect Phone Number")
	public void TC014() {

		driver = Driver.getDriver();
		driver.get(ConfigurationReader.getProperty("signupurl"));
		wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.elementToBeClickable(signUpPage.moreOptions));
		signUpPage.moreOptions.click();
		signUpPage.emailSignInOption.click();

		wait.until(ExpectedConditions.visibilityOf(signUpPage.firstName));

		assertTrue(signUpPage.firstName.isDisplayed());
		assertTrue(signUpPage.lastName.isDisplayed());

		signUpPage.firstName.sendKeys("Elvira");
		signUpPage.lastName.sendKeys("Metoff");
		signUpPage.emailAddress.sendKeys(BrowserUtils.randomEmailGenerator());
		signUpPage.newPassword.sendKeys(ConfigurationReader.getProperty("password"));

		signUpPage.signUpButton.click();

		signUpPage.guestIcon.click();
		signUpPage.nextButton.click();

		wait.until(ExpectedConditions.visibilityOf(signUpPage.phoneInput));
		signUpPage.phoneInput.sendKeys("11");
		signUpPage.aboutMe.sendKeys("I am a nice guest with a coding background");
		signUpPage.yearInput.sendKeys("1999");
		signUpPage.saveButton.click();

		assertTrue(signUpPage.logOut.isDisplayed());
	}

	@Test(description = "Sign Up: Negative Path Incorrect Year")
	public void TC015() {

		driver = Driver.getDriver();
		driver.get(ConfigurationReader.getProperty("signupurl"));
		wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.elementToBeClickable(signUpPage.moreOptions));
		signUpPage.moreOptions.click();
		signUpPage.emailSignInOption.click();

		wait.until(ExpectedConditions.visibilityOf(signUpPage.firstName));

		assertTrue(signUpPage.firstName.isDisplayed());
		assertTrue(signUpPage.lastName.isDisplayed());

		signUpPage.firstName.sendKeys("Elvira");
		signUpPage.lastName.sendKeys("Metoff");
		signUpPage.emailAddress.sendKeys(BrowserUtils.randomEmailGenerator());
		signUpPage.newPassword.sendKeys(ConfigurationReader.getProperty("password"));

		signUpPage.signUpButton.click();

		signUpPage.guestIcon.click();
		signUpPage.nextButton.click();

		wait.until(ExpectedConditions.visibilityOf(signUpPage.phoneInput));
		signUpPage.phoneInput.sendKeys("th");
		signUpPage.aboutMe.sendKeys("I am a nice guest with a coding background");
		signUpPage.yearInput.sendKeys("1999");
		signUpPage.saveButton.click();

		signUpPage.verifyLogOutIsNotPresent();
	}

}
