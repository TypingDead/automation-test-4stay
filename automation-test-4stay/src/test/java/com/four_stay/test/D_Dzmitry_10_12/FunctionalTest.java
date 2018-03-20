package com.four_stay.test.D_Dzmitry_10_12;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.four_stay.pages.ListYourStayPage;
import com.four_stay.utilities.ConfigurationReader;
import com.four_stay.utilities.TestBase;

public class FunctionalTest extends TestBase {
	@Test(priority = 0, description = "First test case TC011")
	public void test() throws InterruptedException {

		ListYourStayPage listYourStayPage = new ListYourStayPage();

		listYourStayPage.listYourStayButton.click();

		listYourStayPage.loginHereLink.click();

		listYourStayPage.emailAddressBox.sendKeys(ConfigurationReader.getProperty("username"));

		listYourStayPage.passwordBox.sendKeys(ConfigurationReader.getProperty("password"));

		listYourStayPage.loginButton.click();

		Assert.assertNotEquals(listYourStayPage.currentUrl, listYourStayPage.profileDetailsPage);

		
		
	}
}
