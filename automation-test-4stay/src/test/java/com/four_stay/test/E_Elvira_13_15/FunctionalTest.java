package com.four_stay.test.E_Elvira_13_15;

 import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import com.four_stay.pages.E_Elvira_13_15.*;
import com.four_stay.utilities.BrowserUtils;
import com.four_stay.utilities.ConfigurationReader;
import com.four_stay.utilities.Driver;
import com.four_stay.utilities.TestBase;

public class FunctionalTest extends TestBase{
		
	HomePage homepage = new HomePage();
	WebDriver driver;
	WebDriverWait wait;
	 
	// HomePage homepage = new HomePage();
	 @Test(priority = 0, description = "First test case TC013")
	 public void test13() {
	
		driver = Driver.getDriver();
		driver.get(ConfigurationReader.getProperty("signupurl"));
		homepage.moreOptions.click();
		homepage.emailSignInOption.click();
		wait=new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("first-name")));
		homepage.firstName.sendKeys("Elvira");
		homepage.lastName.sendKeys("Metoff");
		homepage.emailAddress.sendKeys(BrowserUtils.randomEmailGenerator());
		homepage.newPassword.sendKeys(ConfigurationReader.getProperty("password"));
		
		homepage.signUpButton.click();
	}
}
