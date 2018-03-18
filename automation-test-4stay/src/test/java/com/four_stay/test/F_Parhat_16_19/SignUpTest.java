package com.four_stay.test.F_Parhat_16_19;

 import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import javax.swing.border.TitledBorder;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

//mvn -Dtest=FunctionalTest test 

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.four_stay.pages.F_Parhay_16_19.HomePage;
import com.four_stay.pages.F_Parhay_16_19.SignUpPage;
import com.four_stay.utilities.BrowserUtils;
import com.four_stay.utilities.ConfigurationReader;
import com.four_stay.utilities.Driver;
import com.four_stay.utilities.TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SignUpTest extends TestBase{
		
	
	 HomePage homepage = new HomePage();
	 SignUpPage signUp = new SignUpPage();
	
	// @Test(priority = 0, description = "test case TC018")
	 public void testCase18() {
		assertTrue(homepage.isAt());
		assertTrue(homepage.isAtUrl());
		homepage.clickSearchBox();
		assertTrue(homepage.searchBox.getText().isEmpty());
		homepage.ClickSearchButton();
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
		homepage.ClickSearchButton();
		String value = homepage.result.getText();
		Integer.parseInt(value);
		assertTrue(Integer.parseInt(value) > 0);
	} 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
