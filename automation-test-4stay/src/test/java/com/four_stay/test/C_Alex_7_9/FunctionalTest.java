package com.four_stay.test.C_Alex_7_9;

 import org.openqa.selenium.By;

//mvn -Dtest=FunctionalTest test 

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.four_stay.pages.HomePage;
import com.four_stay.utilities.TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FunctionalTest extends TestBase{
		
	 private WebDriver driver;

	 
	// HomePage homepage = new HomePage();
	 @Test(priority = 0, description = "First test case TC001")
	 public void test() {
		 System.out.println("hi");
		
			
		
	}
}
