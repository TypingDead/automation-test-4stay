package com.four_stay.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.four_stay.utilities.BrowserUtils;
import com.four_stay.utilities.ConfigurationReader;
import com.four_stay.utilities.Driver;
import com.four_stay.utilities.TestBase;

public class SingInFunctionalityTests extends TestBase {
	
	@Test( description = "Sign in with valid test data")
	public void TC001() {
		
		assertEquals(Driver.getDriver().getCurrentUrl(), "https://4stay.com/");
		assertTrue(homepage.login.isDisplayed());
		homepage.login.click();
		assertTrue(homepage.logo.isDisplayed());
		homepage.userEmail.sendKeys(ConfigurationReader.getProperty("username"));
		homepage.userPassword.sendKeys(ConfigurationReader.getProperty("password"));
		homepage.loginButton.click();
		assertTrue(homepage.dashboard.isDisplayed());
		homepage.logout.click();

	}

	@Test( description = "Sign in with invalid email & valid password")
	public void TC002() {

		assertEquals(Driver.getDriver().getCurrentUrl(), "https://4stay.com/");
		assertTrue(homepage.login.isDisplayed());
		homepage.login.click();
		assertTrue(homepage.logo.isDisplayed());
		homepage.userEmail.sendKeys("zmiakhel");
		homepage.userPassword.sendKeys(ConfigurationReader.getProperty("password"));
		homepage.loginButton.click();
		BrowserUtils.waitFor(3);
		assertEquals(homepage.invalidmessage.getText(), "Invalid email or password. Please try again.");
	}

	@Test( description = "Sign in with valid email & no password")
	public void TC003() throws InterruptedException {
		
		Driver.getDriver().get(ConfigurationReader.getProperty("url"));
		assertEquals(Driver.getDriver().getCurrentUrl(), "https://4stay.com/");
		assertTrue(homepage.login.isDisplayed());
		Thread.sleep(2000);
		homepage.login.click();
		assertTrue(homepage.logo.isDisplayed());
		homepage.userEmail.sendKeys("zmiakhel@gmail.com");
		homepage.loginButton.click();
		BrowserUtils.waitFor(3);
		assertEquals(homepage.invalidmessage.getText(), "Invalid email or password. Please try again.");

	}

	@Test(description = "Sign in with no email & valid password")
	public void TC004() {
		
		Driver.getDriver().get(ConfigurationReader.getProperty("url"));
		assertEquals(Driver.getDriver().getCurrentUrl(), "https://4stay.com/");
		assertTrue(homepage.login.isDisplayed());
		homepage.login.click();
		assertTrue(homepage.logo.isDisplayed());
		homepage.userPassword.sendKeys("Cyborg07");
		homepage.loginButton.click();
		BrowserUtils.waitFor(3);
		assertEquals(homepage.invalidmessage.getText(), "Invalid email or password. Please try again.");

	}

	@Test(description = "Sign in with no test data")
	public void TC005() {
				
		Driver.getDriver().get(ConfigurationReader.getProperty("url"));
		assertEquals(Driver.getDriver().getCurrentUrl(), "https://4stay.com/");
		assertTrue(homepage.login.isDisplayed());
		homepage.login.click();
		assertTrue(homepage.logo.isDisplayed());
		homepage.loginButton.click();
		BrowserUtils.waitFor(3);
		assertEquals(homepage.invalidmessage.getText(), "Invalid email or password. Please try again.");

	}

	@Test(description = "Forgot Password functionality on Sing in page")
	public void TC006() throws InterruptedException {

		Driver.getDriver().get(ConfigurationReader.getProperty("url"));
		assertEquals(Driver.getDriver().getCurrentUrl(), "https://4stay.com/");
		assertTrue(homepage.login.isDisplayed());
		Thread.sleep(2000);
		homepage.login.click();
		assertTrue(homepage.logo.isDisplayed());
		assertTrue(homepage.forgotPassword.isDisplayed());

		homepage.forgotPassword.click();
		assertTrue(homepage.forgotPasswordMessageDisplay.isDisplayed());

	}
	
	@Test(description = "Reset Password functionality on Sing in page")
	public void TC007() {

		Driver.getDriver().get(ConfigurationReader.getProperty("url"));
		homepage.isAtUrl();
		assertTrue(homepage.login.isDisplayed());
		homepage.login.click();

		boolean emptyEmail = homepage.userEmail.getText().isEmpty();
		assertTrue(emptyEmail);

		boolean emptyPassword = homepage.userPassword.getText().isEmpty();
		assertTrue(emptyPassword);

		homepage.forgotPasswordMessage();

		homepage.forgotPassword.click();
		BrowserUtils.waitFor(5);
		homepage.forgotPasswordDisplay();

		BrowserUtils.waitFor(5);
		homepage.resetInstruction.click();

		BrowserUtils.waitFor(5);
		homepage.emailCantBeBlank.isDisplayed();
		
	}
}
