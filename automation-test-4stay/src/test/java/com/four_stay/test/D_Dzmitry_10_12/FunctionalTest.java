package com.four_stay.test.D_Dzmitry_10_12;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.four_stay.pages.D_Dzmitry_10_12.SingUpPage;
import com.four_stay.utilities.ConfigurationReader;
import com.four_stay.utilities.TestBase;

public class FunctionalTest extends TestBase {
	@Test(priority = 0, description = "First test case TC011")
	public void test() throws InterruptedException {

		SingUpPage singUpPage = new SingUpPage();

		singUpPage.listYourStayButton.click();

		singUpPage.loginHereLink.click();

		singUpPage.emailAddressBox.sendKeys(ConfigurationReader.getProperty("username"));

		singUpPage.passwordBox.sendKeys(ConfigurationReader.getProperty("password"));

		singUpPage.loginButton.click();

		Assert.assertNotEquals(singUpPage.currentUrl, singUpPage.profileDetailsPage);

		
		
	}
}
