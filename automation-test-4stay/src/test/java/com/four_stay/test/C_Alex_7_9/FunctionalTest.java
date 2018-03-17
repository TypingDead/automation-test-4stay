package com.four_stay.test.C_Alex_7_9;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;

//mvn -Dtest=FunctionalTest test 

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.four_stay.pages.C_Alex_7_9.HomePage;
import com.four_stay.utilities.TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author Rodriguez HomeTest Beta_4Stay
 *
 */
public class FunctionalTest extends TestBase {

	/*
	 * Step 1 Launch the "4stay.com" application with URL. https://4stay.com/ *Home
	 * page is loeaded. *URL of leaded page is equal to ecpected URL.
	 * https://4stay.com
	 * 
	 * Step 2 This step will test log in functionality/option Log in option on
	 * homepage is displayed
	 * 
	 * Step 3 Log in option should be clickable, and new window for log in should be
	 * displayed New window for log in should pop up.
	 * 
	 * Step 4 Email and Password fields should be available and no input should be
	 * provided User field is empty Username: n/a
	 * 
	 * Step 5 User id field (email address) should be editable and no input should
	 * be provided email address field is empty Userpassword: n/a
	 * 
	 * Step 6 "Forgot Password?" option is available "Forgot Password?" is displayed
	 * 
	 * Step 7 After clicking, "Forgot password?" New window is opened, and
	 * "Forgot your password?" is displayed.
	 * 
	 * Step 8 Email field is left blank, and click
	 * "Send me reset password instructions" option. The color verification will be
	 * done manually. "Email can't be blank" is displayed in red color.
	 */

	String actualUrl = "https://4stay.com/";
	String actualForgotPassword ="Forgot Password?";
	
	HomePage homepage = new HomePage();

	@Test(priority = 0, description = "First test case TC001")
	public void test() throws InterruptedException {
		//Step1
		String expectedUrl = driver.getCurrentUrl();
		assertEquals(expectedUrl, actualUrl);
		//Step2
		assertTrue(homepage.validateLogIn());
		//Step3
		homepage.logInClickable();
		//Step4
		boolean emptyEmail= homepage.emailAddress.getText().isEmpty();
		assertTrue(emptyEmail);
		//homepage.emailAddressIsEmpty();
		//Step5
		boolean emptyPassword=homepage.password.getText().isEmpty();
		assertTrue(emptyPassword);
		//homepage.passwordIsEmpty();
		//Step6
		String expectedForgotPassword = homepage.forgotPassword.getText();
		assertEquals(expectedForgotPassword, actualForgotPassword);
		//Step7
		Thread.sleep(5000);
		homepage.forgotPassword.click();
		homepage.forgotPasswordDisplay();
		//Step8
		Thread.sleep(5000);
		homepage.resetInstruction.click();
		Thread.sleep(5000);
		homepage.emailCantBeBlank.isDisplayed();
		System.out.println(homepage.emailCantBeBlank.getText());
		//done
	}
		
	
}
