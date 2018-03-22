package com.four_stay.test.D_Dzmitry_10_12;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.four_stay.pages.HomePage;
import com.four_stay.pages.ListYourStayPage;
import com.four_stay.pages.SignUpPage;
import com.four_stay.utilities.BrowserUtils;
import com.four_stay.utilities.ConfigurationReader;
import com.four_stay.utilities.Driver;
import com.four_stay.utilities.TestBase;

public class FunctionalTest extends TestBase {
	//testCase#11
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
	//testCase#12
	@Test(priority = 1, description = "First test case TC012")
	public void signUpTest() throws InterruptedException {
		SignUpPage singUpPage = new SignUpPage();
		singUpPage.navigateToSingUpPage();
		BrowserUtils.waitFor(3);
		singUpPage.moreOptions.click();
		
		assertTrue(singUpPage.continueWithFacebookButton.isDisplayed());
		assertTrue(singUpPage.continueWithGoogleButton.isDisplayed());
		assertTrue(singUpPage.continueEmailButton.isDisplayed());
		
		singUpPage.continueEmailButton.click();
		System.out.println();
		//sign up field
		singUpPage.completeUserForm(singUpPage.userfirstName, singUpPage.userlLastName,
				singUpPage.newEmailAddress,singUpPage.newUserPassword );
		//click sing in button
		singUpPage.signUpButton.click();
		//	registered like a GUEST
		//click on GUEST
		singUpPage.guestIcon.click();
		//verify GUEST icon is selected
		assertTrue(singUpPage.guestButtonIsSelected.isDisplayed());
		//click on button "Next"
		singUpPage.nextButton.click();
		//profile-details
		singUpPage.profileDetails(singUpPage.userPhoneNumber,
				singUpPage.aboutMyself, singUpPage.userDoB);
		//click save button
		singUpPage.saveButton.click();
		//check name is displayed
		assertTrue(singUpPage.nameLink.isDisplayed());
		//registered like a HOST
		driver.get("https://4stay.com/sign-up#!/select-role");
		//click on HOST button
		singUpPage.hostIcon.click();
		//verify HOST icon is selected
		assertTrue(singUpPage.hostIconIsSelected.isDisplayed());
		//click on button "Next"
		singUpPage.nextButton.click();
		//profile-details
	//	BrowserUtils.waitFor(3);
		singUpPage.hostEmail.clear();
		singUpPage.hostEmail.sendKeys(singUpPage.newRandomEmailAddress(singUpPage.newEmailAddress));
		singUpPage.profileDetails(singUpPage.userPhoneNumber,
				singUpPage.aboutMyself, singUpPage.userDoB);
		//click save button
		singUpPage.saveButton.click();
		assertEquals(driver.getCurrentUrl(), "https://4stay.com/sign-up#!/profile-details");
	}
	//testCase#9SY2
	@Test(priority = 2, description = "test case 9 from other test cases SY2")
	public void searshFunctionalityNegativeTest() {
		
		HomePage homePage = new HomePage();
		//navigate to Home Page 4stay.com
		driver = Driver.getDriver();
		driver.get(ConfigurationReader.getProperty("url"));
		
		assertTrue(homePage.isAt());
		homePage.searchButton.click();
		
		assertEquals(homePage.alertMessage.getText(),"Please type your city, college, or metro");
		
		assertTrue(homePage.isAt());
	}
}
