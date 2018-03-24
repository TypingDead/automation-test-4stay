package com.four_stay.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.four_stay.pages.HomePage;
import com.four_stay.utilities.BrowserUtils;
import com.four_stay.utilities.ConfigurationReader;
import com.four_stay.utilities.Driver;
import com.four_stay.utilities.TestBase;

public class SingInFunctionalityTests extends TestBase {

	HomePage homepage = new HomePage();
	
	WebDriverWait wait;

	@Test( description = "Sign in with valid test data")
	public void TC001() {
		
		assertEquals(driver.getCurrentUrl(), "https://4stay.com/");
		assertTrue(homepage.login.isDisplayed());
		homepage.login.click();
		assertTrue(homepage.logo.isDisplayed());
		homepage.userEmail.sendKeys("zmiakhel@gmail.com ");
		homepage.userPassword.sendKeys("Cyborg07");
		homepage.loginButton.click();
		assertTrue(homepage.dashboard.isDisplayed());
		homepage.logout.click();

	}

	@Test( description = "Sign in with invalid email & valid password")
	public void TC002() {
				
		driver.get(ConfigurationReader.getProperty("url"));
		assertEquals(driver.getCurrentUrl(), "https://fourstay-staging.herokuapp.com/");
		assertTrue(homepage.login.isDisplayed());
		homepage.login.click();
		assertTrue(homepage.logo.isDisplayed());
		homepage.userEmail.sendKeys("zmiakhel");
		homepage.userPassword.sendKeys("Cyborg07");
		homepage.loginButton.click();
		BrowserUtils.waitFor(3);
		assertEquals(homepage.invalidmessage.getText(), "Invalid email or password. Please try again.");
	}

	@Test( description = "Sign in with valid email & no password")
	public void TC003() throws InterruptedException {
		
		driver = Driver.getDriver();
		driver.get(ConfigurationReader.getProperty("url"));
		assertEquals(driver.getCurrentUrl(), "https://4stay.com/");
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
		
		driver.get(ConfigurationReader.getProperty("url"));
		assertEquals(driver.getCurrentUrl(), "https://fourstay-staging.herokuapp.com/");
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
				
		driver.get(ConfigurationReader.getProperty("url"));
		assertEquals(driver.getCurrentUrl(), "https://fourstay-staging.herokuapp.com/");
		assertTrue(homepage.login.isDisplayed());
		homepage.login.click();
		assertTrue(homepage.logo.isDisplayed());
		homepage.loginButton.click();
		BrowserUtils.waitFor(3);
		assertEquals(homepage.invalidmessage.getText(), "Invalid email or password. Please try again.");

	}

	@Test(description = "Forgot Password functionality on Sing in page")
	public void TC006() throws InterruptedException {
		
		driver = Driver.getDriver();
		driver.get(ConfigurationReader.getProperty("url"));
		assertEquals(driver.getCurrentUrl(), "https://fourstay-staging.herokuapp.com/");
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

		driver.get(ConfigurationReader.getProperty("url"));
		homepage.isAtUrl();
		assertTrue(homepage.login.isDisplayed());
		homepage.login.click();

		boolean emptyEmail = homepage.userEmail.getText().isEmpty();
		assertTrue(emptyEmail);

		boolean emptyPassword = homepage.userPassword.getText().isEmpty();
		assertTrue(emptyPassword);

		wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.visibilityOf(homepage.forgotPassword));
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
