package com.four_stay.test.E_Elvira_13_15;

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

public class FunctionalTestDemo extends TestBase {

	SignUpPage signUpPage = new SignUpPage();
	WebDriver driver;
	WebDriverWait wait;


	@Test( description = "Test case TC014")
	public void test14() {

		driver = Driver.getDriver();
		driver.get(ConfigurationReader.getProperty("signupurl"));
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.elementToBeClickable(signUpPage.moreOptions));
		
		BrowserUtils.highlightAreaWithJavascript(signUpPage.moreOptions);
		signUpPage.moreOptions.click();
		
		BrowserUtils.highlightAreaWithJavascript(signUpPage.emailSignInOption);
		signUpPage.emailSignInOption.click();

		wait.until(ExpectedConditions.visibilityOf(signUpPage.firstName));

		assertTrue(signUpPage.firstName.isDisplayed());
		assertTrue(signUpPage.lastName.isDisplayed());

		BrowserUtils.highLighterBackground(signUpPage.firstName);
		signUpPage.firstName.sendKeys("Elvira");
		
		BrowserUtils.highLighterBackground(signUpPage.lastName);
		signUpPage.lastName.sendKeys("Metoff");
		
		BrowserUtils.highLighterBackground(signUpPage.emailAddress);
		signUpPage.emailAddress.sendKeys(BrowserUtils.randomEmailGenerator());
		
		BrowserUtils.highLighterBackground(signUpPage.newPassword);
		signUpPage.newPassword.sendKeys(ConfigurationReader.getProperty("password"));

		BrowserUtils.highlightAreaWithJavascript(signUpPage.signUpButton);
		signUpPage.signUpButton.click();

		BrowserUtils.highlightAreaWithJavascript(signUpPage.guestIcon);
		signUpPage.guestIcon.click();
		
		BrowserUtils.highlightAreaWithJavascript(signUpPage.nextButton);
		signUpPage.nextButton.click();

		wait.until(ExpectedConditions.visibilityOf(signUpPage.phoneInput));
		
		BrowserUtils.highLighterBackground(signUpPage.phoneInput);
		signUpPage.phoneInput.sendKeys("11");
		
		BrowserUtils.highLighterBackground(signUpPage.aboutMe);
		signUpPage.aboutMe.sendKeys("I am a nice guest with a coding background");
		
		BrowserUtils.highLighterBackground(signUpPage.yearInput);
		signUpPage.yearInput.sendKeys("1999");
		
		BrowserUtils.highlightAreaWithJavascript(signUpPage.saveButton);
		signUpPage.saveButton.click();

		BrowserUtils.highlightAreaWithJavascript(signUpPage.logOut);
		assertTrue(signUpPage.logOut.isDisplayed());
	}


}
