package com.four_stay.test.B_Filip_4_6;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.four_stay.pages.HomePage;
import com.four_stay.utilities.BrowserUtils;
import com.four_stay.utilities.TestBase;

public class FunctionalTest extends TestBase {

	HomePage homepage = new HomePage();

	@Test(description = "First test case TC004")
	public void test4() {
		assertEquals(driver.getCurrentUrl(), "https://4stay.com/");
		assertTrue(homepage.login.isDisplayed());
		homepage.login.click();
		assertTrue(homepage.logo.isDisplayed());
		homepage.userPassword.sendKeys("Cyborg07");
		homepage.loginButton.click();
		BrowserUtils.waitFor(3);
		assertEquals(homepage.invalidmessage.getText(), "Invalid email or password. Please try again.");
		homepage.logout.click();
	}

	@Test(description = "Second test case TC005")
	public void test5() {

		assertEquals(driver.getCurrentUrl(), "https://4stay.com/");
		assertTrue(homepage.login.isDisplayed());
		homepage.login.click();
		assertTrue(homepage.logo.isDisplayed());
		homepage.loginButton.click();
		BrowserUtils.waitFor(3);
		assertEquals(homepage.invalidmessage.getText(), "Invalid email or password. Please try again.");
			homepage.logout.click();
	}

	@Test(description = "Third test case TC006")
	public void test6() throws InterruptedException {
		
		assertEquals(driver.getCurrentUrl(), "https://4stay.com/");
		assertTrue(homepage.login.isDisplayed());
		Thread.sleep(2000);
		homepage.login.click();
		assertTrue(homepage.logo.isDisplayed());
		
	//work on it
	

	}
}
