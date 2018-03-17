package com.four_stay.test.C_Alex_7_9;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;

//mvn -Dtest=FunctionalTest test 

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.four_stay.pages.C_Alex_7_9.HomePage;
import com.four_stay.utilities.BrowserUtils;
import com.four_stay.utilities.TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author Rodriguez HomeTest Beta_4Stay
 *
 */
public class FunctionalTest extends TestBase {

	String actualUrl = "https://4stay.com/";
	String actualForgotPassword = "Forgot Password?";
	WebDriverWait wait;

	HomePage homepage = new HomePage();

	@Test(priority = 0, description = "First test case TC001")
	public void test() throws InterruptedException {
		String expectedUrl = driver.getCurrentUrl();
		assertEquals(expectedUrl, actualUrl);

		assertTrue(homepage.validateLogIn());

		homepage.logIn.click();

		boolean emptyEmail = homepage.emailAddress.getText().isEmpty();
		assertTrue(emptyEmail);

		boolean emptyPassword = homepage.password.getText().isEmpty();
		assertTrue(emptyPassword);

		wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.visibilityOf(homepage.forgotPassword));
		String expectedForgotPassword = homepage.forgotPassword.getText();
		assertEquals(expectedForgotPassword, actualForgotPassword);

		BrowserUtils.waitFor(5);
		homepage.forgotPassword.click();
		homepage.forgotPasswordDisplay();
		
		BrowserUtils.waitFor(5);
		homepage.resetInstruction.click();

		BrowserUtils.waitFor(5);
		homepage.emailCantBeBlank.isDisplayed();
		System.out.println(homepage.emailCantBeBlank.getText());
		// done
	}
	
	

}
