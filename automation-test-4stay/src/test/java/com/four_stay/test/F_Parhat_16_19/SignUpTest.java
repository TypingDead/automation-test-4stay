package com.four_stay.test.F_Parhat_16_19;

 import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.four_stay.pages.HomePage;
import com.four_stay.pages.SignUpPage;
import com.four_stay.utilities.BrowserUtils;
import com.four_stay.utilities.TestBase;

public class SignUpTest extends TestBase{
		
	
	 HomePage homepage = new HomePage();
	 SignUpPage signUp = new SignUpPage();
	
	// @Test(priority = 0, description = "test case TC018")
	 public void testCase18() {
		assertTrue(homepage.isAt());
		assertTrue(homepage.isAtUrl());
		homepage.clickSearchBox();
		assertTrue(homepage.searchTab.getText().isEmpty());
		homepage.searchButton.click();
		assertEquals(homepage.AfterclicktheButton.getText(), "Please type your city, college, or metro");
	}
	 
	 
	 
	 @Test(priority = 1, description = "test case TC019")
	 public void testCase19() {
		homepage.sendKeyToSearchBox();
	//	driver.findElement(By.id("1c424ec2bb8c8770377d066a207d31b4aff918a5")).click();
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ARROW_DOWN).perform();
		action.sendKeys(Keys.ENTER).perform();
		BrowserUtils.waitFor(5);
		homepage.searchButton.click();
		String value = homepage.result.getText();
		Integer.parseInt(value);
		assertTrue(Integer.parseInt(value) > 0);
	} 
	 
	
	 
	 @Test(priority = 2, description = "test case TC011 From different test case")
	 public void testCase11() {
		 
	 }
	 
	 
	 @Test(priority = 3, description = "test case TC012 From different test case")
	 public void testCase12() {
		 
	 }
	 
	 
	 
	 
	 
	 
	 
	 
}
