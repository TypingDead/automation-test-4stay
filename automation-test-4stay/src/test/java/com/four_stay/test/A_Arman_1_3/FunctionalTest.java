package com.four_stay.test.A_Arman_1_3;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue; 

import org.testng.annotations.Test;

import com.four_stay.pages.HomePage;
import com.four_stay.utilities.BrowserUtils;
import com.four_stay.utilities.TestBase;

public class FunctionalTest extends TestBase {

	HomePage homepage = new HomePage();

	@Test(priority = 0, description = "First test case TC001")
	public void test1() {
		assertEquals(driver.getCurrentUrl(), "https://4stay.com/");
		assertTrue(homepage.login.isDisplayed());
		homepage.login.click();
		assertTrue(homepage.logo.isDisplayed());
		homepage.userEmail.sendKeys("zmiakhel@gmail.com ");
		homepage.userPassword.sendKeys("Cyborg07");
		homepage.loginButton.click();
		assertTrue(homepage.dashboard.isDisplayed());

	}

	@Test(priority = 1, description = "Second test case TC002")
	public void test2() {
		homepage.logout.click();
		assertEquals(driver.getCurrentUrl(), "https://4stay.com/");
		assertTrue(homepage.login.isDisplayed());
		homepage.login.click();
		assertTrue(homepage.logo.isDisplayed());
		homepage.userEmail.sendKeys("zmiakhel");
		homepage.userPassword.sendKeys("Cyborg07");
		homepage.loginButton.click();
		BrowserUtils.waitFor(3);
		assertEquals(homepage.invalidmessage.getText(), "Invalid email or password. Please try again.");
	}

	@Test(priority = 2, description = "Third test case TC003")
	public void test3() throws InterruptedException {
		homepage.close.click();
		assertEquals(driver.getCurrentUrl(), "https://4stay.com/");
		assertTrue(homepage.login.isDisplayed());
		Thread.sleep(2000);
		homepage.login.click();
		assertTrue(homepage.logo.isDisplayed());
		homepage.userEmail.sendKeys("zmiakhel@gamil.com");
		homepage.loginButton.click();
		BrowserUtils.waitFor(3);
		assertEquals(homepage.invalidmessage.getText(), "Invalid email or password. Please try again.");

	}
}
