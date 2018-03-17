package com.four_stay.test.A_Arman_1_3;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

//mvn -Dtest=FunctionalTest test 

import org.testng.annotations.Test;

import com.four_stay.pages.A_Arman_1_3.HomePage;
import com.four_stay.utilities.BrowserUtils;
import com.four_stay.utilities.ConfigurationReader;
import com.four_stay.utilities.Driver;
import com.four_stay.utilities.TestBase;

public class FunctionalTest extends TestBase {

	HomePage homepage = new HomePage();

	@Test(priority = 0, description = "First test case TC001")
	public void test1() {
		assertEquals(driver.getCurrentUrl(), "https://4stay.com/");
		assertTrue(homepage.LogIn.isDisplayed());
		homepage.LogIn.click();
		assertTrue(homepage.logo.isDisplayed());
		homepage.Emailaddress.sendKeys("zmiakhel@gmail.com ");
		homepage.Password.sendKeys("Cyborg07");
		homepage.Loginbutton.click();
		assertTrue(homepage.dashboard.isDisplayed());

	}

	@Test(priority = 1, description = "Second test case TC002")
	public void test2() {
		homepage.LogOut.click();
		assertEquals(driver.getCurrentUrl(), "https://4stay.com/");
		assertTrue(homepage.LogIn.isDisplayed());
		homepage.LogIn.click();
		assertTrue(homepage.logo.isDisplayed());
		homepage.Emailaddress.sendKeys("zmiakhel");
		homepage.Password.sendKeys("Cyborg07");
		homepage.Loginbutton.click();
		BrowserUtils.waitFor(3);
		assertEquals(homepage.invalidmessage.getText(), "Invalid email or password. Please try again.");
	}

	@Test(priority = 2, description = "Third test case TC003")
	public void test3() throws InterruptedException {
		homepage.close.click();
		assertEquals(driver.getCurrentUrl(), "https://4stay.com/");
		assertTrue(homepage.LogIn.isDisplayed());
		Thread.sleep(2000);
		homepage.LogIn.click();
		assertTrue(homepage.logo.isDisplayed());
		homepage.Emailaddress.sendKeys("zmiakhel@gamil.com");
		homepage.Loginbutton.click();
		BrowserUtils.waitFor(3);
		assertEquals(homepage.invalidmessage.getText(), "Invalid email or password. Please try again.");

	}
}
