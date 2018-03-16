package com.four_stay.test.F_Parhat_16_19;

 import javax.swing.border.TitledBorder;

import org.openqa.selenium.By;

//mvn -Dtest=FunctionalTest test 

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.four_stay.pages.F_Parhay_16_19.SignUpPage;
import com.four_stay.utilities.ConfigurationReader;
import com.four_stay.utilities.Driver;
import com.four_stay.utilities.TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SignUpTest extends TestBase{
		
	

		
	
	 @Test(priority = 0, description = "test case TC016")
	 public void test() {
		String url= driver.getCurrentUrl();
		System.out.println(url);
		
		//	 SignUpPage signUp = new SignUpPage();
		 driver.get(ConfigurationReader.getProperty("signupurl"));
		//signUp.login.click();
	//	System.out.println(driver.getTitle());
		
	}
}
