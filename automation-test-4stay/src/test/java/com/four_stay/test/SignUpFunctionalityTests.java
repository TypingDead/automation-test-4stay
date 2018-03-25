package com.four_stay.test;

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

public class SignUpFunctionalityTests extends TestBase {
	
	WebDriverWait wait;

	@Test( description = "Sign up with valid test data")
	public void TC013() throws InterruptedException {

		Driver.getDriver().get(ConfigurationReader.getProperty("signupurl"));
		wait = new WebDriverWait(Driver.getDriver(), 3);
		wait.until(ExpectedConditions.elementToBeClickable(signUpPage.moreOptions));
		signUpPage.moreOptions.click();
		signUpPage.emailSignInOption.click();
		wait = new WebDriverWait(Driver.getDriver(), 3);
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

	@Test( description = "Sign up with with valid test data except two digit phone-number")
	public void TC014(){

		Driver.getDriver().get(ConfigurationReader.getProperty("signupurl"));
		wait = new WebDriverWait(Driver.getDriver(), 3);
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

	@Test(description = "Sign up with with valid test data except two letter phone-number")
	public void TC015() {

		Driver.getDriver().get(ConfigurationReader.getProperty("signupurl"));
		wait = new WebDriverWait(Driver.getDriver(), 3);
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
