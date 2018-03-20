package com.four_stay.test.C_Alex_7_9;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.four_stay.pages.HomePage;
import com.four_stay.pages.ListYourStayPage;
import com.four_stay.utilities.BrowserUtils;
import com.four_stay.utilities.ConfigurationReader;
import com.four_stay.utilities.TestBase;

/**
 * 
 * @author Rodriguez HomeTest Beta_4Stay
 *
 */
public class FunctionalTest extends TestBase {

	WebDriverWait wait;

	HomePage homepage = new HomePage();
	ListYourStayPage listYourStayPage = new ListYourStayPage();

//	@Test(description = "First test case TC007")
	public void test007() {

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
		System.out.println(homepage.emailCantBeBlank.getText());
		// done
	}

	@Test(description = "First test case TC008")
	public void test008() throws InterruptedException {

		listYourStayPage.listYourStayButton.click();

		String current = driver.getCurrentUrl();
		Assert.assertEquals(current, listYourStayPage.actualHostUrl);

		listYourStayPage.firstName.sendKeys("Alex");
		listYourStayPage.lastName.sendKeys("Rodriguez");

		listYourStayPage.emailAddress.sendKeys(BrowserUtils.randomEmailGenerator());
		listYourStayPage.password.sendKeys(ConfigurationReader.getProperty("password"));

		
		listYourStayPage.checkBox();
		listYourStayPage.phoneNumber.sendKeys("11"+Keys.ENTER);
//	Actions actions= new Actions(driver);
//		WebElement element = driver.findElement(By.xpath("//div[@class='intercom-borderless-dismiss-button']/span"));
//		actions.doubleClick(element).perform();
	
//		BrowserUtils.waitFor(5);
//		listYourStayPage.createAccount.click();
		BrowserUtils.waitFor(5);
		String current1 = driver.getCurrentUrl();
		Assert.assertEquals(current1, listYourStayPage.profileDetailsPage);

	}

//	@Test(description = "First test case TC009")
	public void test009() {

		listYourStayPage.isAtUrl();
		listYourStayPage.listYourStayButton.click();
		assertEquals(listYourStayPage.expectedHostUrl(), listYourStayPage.actualHostUrl);

		listYourStayPage.facebookSignup.click();

	}

}
