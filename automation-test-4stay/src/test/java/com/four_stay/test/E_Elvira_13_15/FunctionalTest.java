package com.four_stay.test.E_Elvira_13_15;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.four_stay.pages.E_Elvira_13_15.HomePage;
import com.four_stay.utilities.BrowserUtils;
import com.four_stay.utilities.ConfigurationReader;
import com.four_stay.utilities.Driver;
import com.four_stay.utilities.TestBase;

public class FunctionalTest extends TestBase {

	HomePage homepage = new HomePage();
	WebDriver driver;
	WebDriverWait wait;

	@Test( description = "Test case TC013")
	public void test13() throws InterruptedException {

		driver = Driver.getDriver();
		driver.get(ConfigurationReader.getProperty("signupurl"));
		wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.elementToBeClickable(homepage.moreOptions));
		homepage.moreOptions.click();
		homepage.emailSignInOption.click();
		wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.visibilityOf(homepage.firstName));

		assertTrue(homepage.firstName.isDisplayed());
		assertTrue(homepage.lastName.isDisplayed());

		homepage.firstName.sendKeys("Elvira");
		homepage.lastName.sendKeys("Metoff");
		homepage.emailAddress.sendKeys(BrowserUtils.randomEmailGenerator());
		homepage.newPassword.sendKeys(ConfigurationReader.getProperty("password"));

		homepage.signUpButton.click();

		assertTrue(homepage.closeX.isEnabled());

		Thread.sleep(5000);
		homepage.closeX.click();

		// driver.navigate().back();
		// JavascriptExecutor jse = (JavascriptExecutor)driver;
		// jse.executeScript("window.history.go(-1);");

		// wait.until(ExpectedConditions.elementToBeClickable(homepage.closeX));

		// JavascriptExecutor jse = (JavascriptExecutor)driver;
		// jse.executeScript("arguments[0].click();", homepage.closeX);
		// Actions action = new Actions(driver);
		// action.click(homepage.closeX).build().perform();
		// driver.findElement(By.cssSelector("button[class='close p-1 mr-3 mt-2
		// mb-2']")).sendKeys(Keys.ENTER);

		homepage.verifyFirstNameIsNotPresent();
		homepage.verifyLastNameIsNotPresent();

	}

	@Test( description = "Test case TC014")
	public void test14(){

		driver = Driver.getDriver();
		driver.get(ConfigurationReader.getProperty("signupurl"));
		wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.elementToBeClickable(homepage.moreOptions));
		homepage.moreOptions.click();
		homepage.emailSignInOption.click();

		wait.until(ExpectedConditions.visibilityOf(homepage.firstName));

		assertTrue(homepage.firstName.isDisplayed());
		assertTrue(homepage.lastName.isDisplayed());

		homepage.firstName.sendKeys("Elvira");
		homepage.lastName.sendKeys("Metoff");
		homepage.emailAddress.sendKeys(BrowserUtils.randomEmailGenerator());
		homepage.newPassword.sendKeys(ConfigurationReader.getProperty("password"));

		homepage.signUpButton.click();

		homepage.guestIcon.click();
		homepage.nextButton.click();

		wait.until(ExpectedConditions.visibilityOf(homepage.phoneInput));
		homepage.phoneInput.sendKeys("11");
		homepage.aboutMe.sendKeys("I am a nice guest with a coding background");
		homepage.yearInput.sendKeys("1999");
		homepage.saveButton.click();

		assertTrue(homepage.logOut.isDisplayed());
	}

	@Test(description = "Test case TC015")
	public void test15() {

		driver = Driver.getDriver();
		driver.get(ConfigurationReader.getProperty("signupurl"));
		wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.elementToBeClickable(homepage.moreOptions));
		homepage.moreOptions.click();
		homepage.emailSignInOption.click();

		wait.until(ExpectedConditions.visibilityOf(homepage.firstName));

		assertTrue(homepage.firstName.isDisplayed());
		assertTrue(homepage.lastName.isDisplayed());

		homepage.firstName.sendKeys("Elvira");
		homepage.lastName.sendKeys("Metoff");
		homepage.emailAddress.sendKeys(BrowserUtils.randomEmailGenerator());
		homepage.newPassword.sendKeys(ConfigurationReader.getProperty("password"));

		homepage.signUpButton.click();

		homepage.guestIcon.click();
		homepage.nextButton.click();

		wait.until(ExpectedConditions.visibilityOf(homepage.phoneInput));
		homepage.phoneInput.sendKeys("th");
		homepage.aboutMe.sendKeys("I am a nice guest with a coding background");
		homepage.yearInput.sendKeys("1999");
		homepage.saveButton.click();

		homepage.verifyLogOutIsNotPresent();
	}

}
